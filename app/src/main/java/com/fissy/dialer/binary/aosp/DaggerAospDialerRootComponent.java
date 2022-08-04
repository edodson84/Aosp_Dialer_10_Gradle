package com.fissy.dialer.binary.aosp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import com.android.bubble.Bubble;
import com.android.bubble.BubbleComponent;
import com.android.bubble.stub.BubbleStub_Factory;
import com.fissy.dialer.activecalls.ActiveCalls;
import com.fissy.dialer.activecalls.ActiveCallsComponent;
import com.fissy.dialer.activecalls.impl.ActiveCallsImpl_Factory;
import com.fissy.dialer.calllog.AnnotatedCallLogMigrator;
import com.fissy.dialer.calllog.AnnotatedCallLogMigrator_Factory;
import com.fissy.dialer.calllog.CallLogCacheUpdater;
import com.fissy.dialer.calllog.CallLogCacheUpdater_Factory;
import com.fissy.dialer.calllog.CallLogComponent;
import com.fissy.dialer.calllog.CallLogFramework;
import com.fissy.dialer.calllog.CallLogFramework_Factory;
import com.fissy.dialer.calllog.CallLogModule_ProvideCallLogDataSourcesFactory;
import com.fissy.dialer.calllog.CallLogState;
import com.fissy.dialer.calllog.CallLogState_Factory;
import com.fissy.dialer.calllog.ClearMissedCalls;
import com.fissy.dialer.calllog.ClearMissedCalls_Factory;
import com.fissy.dialer.calllog.RefreshAnnotatedCallLogWorker;
import com.fissy.dialer.calllog.RefreshAnnotatedCallLogWorker_Factory;
import com.fissy.dialer.calllog.config.CallLogConfig;
import com.fissy.dialer.calllog.config.CallLogConfigComponent;
import com.fissy.dialer.calllog.config.CallLogConfigImpl;
import com.fissy.dialer.calllog.config.CallLogConfigImpl_Factory;
import com.fissy.dialer.calllog.database.AnnotatedCallLogDatabaseHelper;
import com.fissy.dialer.calllog.database.AnnotatedCallLogDatabaseHelper_Factory;
import com.fissy.dialer.calllog.database.CallLogDatabaseComponent;
import com.fissy.dialer.calllog.database.CallLogDatabaseModule;
import com.fissy.dialer.calllog.database.CallLogDatabaseModule_ProvideMaxRowsFactory;
import com.fissy.dialer.calllog.database.Coalescer;
import com.fissy.dialer.calllog.database.Coalescer_Factory;
import com.fissy.dialer.calllog.database.MutationApplier;
import com.fissy.dialer.calllog.database.MutationApplier_Factory;
import com.fissy.dialer.calllog.datasources.DataSources;
import com.fissy.dialer.calllog.datasources.phonelookup.PhoneLookupDataSource;
import com.fissy.dialer.calllog.datasources.phonelookup.PhoneLookupDataSource_Factory;
import com.fissy.dialer.calllog.datasources.systemcalllog.SystemCallLogDataSource;
import com.fissy.dialer.calllog.datasources.systemcalllog.SystemCallLogDataSource_Factory;
import com.fissy.dialer.calllog.datasources.voicemail.VoicemailDataSource;
import com.fissy.dialer.calllog.datasources.voicemail.VoicemailDataSource_Factory;
import com.fissy.dialer.calllog.notifier.RefreshAnnotatedCallLogNotifier;
import com.fissy.dialer.calllog.notifier.RefreshAnnotatedCallLogNotifier_Factory;
import com.fissy.dialer.calllog.observer.MarkDirtyObserver;
import com.fissy.dialer.calllog.observer.MarkDirtyObserver_Factory;
import com.fissy.dialer.calllog.ui.CallLogUiComponent;
import com.fissy.dialer.calllog.ui.RealtimeRowProcessor;
import com.fissy.dialer.calllog.ui.RealtimeRowProcessor_Factory;
import com.fissy.dialer.commandline.Command;
import com.fissy.dialer.commandline.CommandLineComponent;
import com.fissy.dialer.commandline.CommandLineModule;
import com.fissy.dialer.commandline.CommandLineModule_AospCommandInjector_Factory;
import com.fissy.dialer.commandline.CommandLineModule_ProvideCommandSupplierFactory;
import com.fissy.dialer.commandline.impl.ActiveCallsCommand;
import com.fissy.dialer.commandline.impl.ActiveCallsCommand_Factory;
import com.fissy.dialer.commandline.impl.BlockingCommand;
import com.fissy.dialer.commandline.impl.BlockingCommand_Factory;
import com.fissy.dialer.commandline.impl.CallCommand;
import com.fissy.dialer.commandline.impl.CallCommand_Factory;
import com.fissy.dialer.commandline.impl.Echo_Factory;
import com.fissy.dialer.commandline.impl.Help;
import com.fissy.dialer.commandline.impl.Help_Factory;
import com.fissy.dialer.commandline.impl.Version;
import com.fissy.dialer.commandline.impl.Version_Factory;
import com.fissy.dialer.common.concurrent.DefaultDialerExecutorFactory;
import com.fissy.dialer.common.concurrent.DefaultDialerExecutorFactory_Factory;
import com.fissy.dialer.common.concurrent.DialerExecutorComponent;
import com.fissy.dialer.common.concurrent.DialerExecutorFactory;
import com.fissy.dialer.common.concurrent.DialerExecutorModule_ProvideBackgroundExecutorFactory;
import com.fissy.dialer.common.concurrent.DialerExecutorModule_ProvideLightweightExecutorFactory;
import com.fissy.dialer.common.concurrent.DialerExecutorModule_ProvideNonUiSerialExecutorServiceFactory;
import com.fissy.dialer.common.concurrent.DialerExecutorModule_ProvideNonUiThreadPoolFactory;
import com.fissy.dialer.common.concurrent.DialerExecutorModule_ProvideUiSerialExecutorServiceFactory;
import com.fissy.dialer.common.concurrent.DialerExecutorModule_ProvideUiThreadExecutorServiceFactory;
import com.fissy.dialer.common.concurrent.DialerExecutorModule_ProvideUiThreadPoolFactory;
import com.fissy.dialer.configprovider.ConfigProvider;
import com.fissy.dialer.configprovider.ConfigProviderComponent;
import com.fissy.dialer.configprovider.SharedPrefConfigProvider;
import com.fissy.dialer.configprovider.SharedPrefConfigProvider_Factory;
import com.fissy.dialer.contacts.ContactsComponent;
import com.fissy.dialer.contacts.ContactsModule_ProvideContactDisplayPreferencesFactory;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferences;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferencesImpl;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferencesImpl_Factory;
import com.fissy.dialer.contacts.displaypreference.ContactDisplayPreferencesStub_Factory;
import com.fissy.dialer.contacts.hiresphoto.HighResolutionPhotoRequester;
import com.fissy.dialer.contacts.hiresphoto.HighResolutionPhotoRequesterImpl;
import com.fissy.dialer.contacts.hiresphoto.HighResolutionPhotoRequesterImpl_Factory;
import com.fissy.dialer.duo.Duo;
import com.fissy.dialer.duo.DuoComponent;
import com.fissy.dialer.duo.stub.DuoStub_Factory;
import com.fissy.dialer.enrichedcall.EnrichedCallComponent;
import com.fissy.dialer.enrichedcall.EnrichedCallManager;
import com.fissy.dialer.enrichedcall.RcsVideoShareFactory;
import com.fissy.dialer.enrichedcall.stub.StubEnrichedCallModule;
import com.fissy.dialer.enrichedcall.stub.StubEnrichedCallModule_ProvideEnrichedCallManagerFactory;
import com.fissy.dialer.enrichedcall.stub.StubEnrichedCallModule_ProvidesRcsVideoShareFactoryFactory;
import com.fissy.dialer.feedback.FeedbackComponent;
import com.fissy.dialer.feedback.FeedbackSender;
import com.fissy.dialer.feedback.stub.StubFeedbackModule;
import com.fissy.dialer.feedback.stub.StubFeedbackModule_ProvideCallFeedbackListenerFactory;
import com.fissy.dialer.feedback.stub.StubFeedbackModule_ProvideCallFeedbackSenderFactory;
import com.fissy.dialer.function.Supplier;
import com.fissy.dialer.glidephotomanager.GlidePhotoManager;
import com.fissy.dialer.glidephotomanager.GlidePhotoManagerComponent;
import com.fissy.dialer.glidephotomanager.impl.GlidePhotoManagerImpl;
import com.fissy.dialer.glidephotomanager.impl.GlidePhotoManagerImpl_Factory;
import com.fissy.dialer.inject.ContextModule;
import com.fissy.dialer.inject.ContextModule_ProvideContextFactory;
import com.fissy.dialer.metrics.FutureTimer;
import com.fissy.dialer.metrics.FutureTimer_Factory;
import com.fissy.dialer.metrics.Metrics;
import com.fissy.dialer.metrics.MetricsComponent;
import com.fissy.dialer.metrics.StubMetrics;
import com.fissy.dialer.metrics.StubMetricsInitializer_Factory;
import com.fissy.dialer.metrics.StubMetrics_Factory;
import com.fissy.dialer.phonelookup.PhoneLookup;
import com.fissy.dialer.phonelookup.PhoneLookupComponent;
import com.fissy.dialer.phonelookup.PhoneLookupModule_ProvidePhoneLookupListFactory;
import com.fissy.dialer.phonelookup.blockednumber.SystemBlockedNumberPhoneLookup;
import com.fissy.dialer.phonelookup.blockednumber.SystemBlockedNumberPhoneLookup_Factory;
import com.fissy.dialer.phonelookup.cequint.CequintPhoneLookup;
import com.fissy.dialer.phonelookup.cequint.CequintPhoneLookup_Factory;
import com.fissy.dialer.phonelookup.cnap.CnapPhoneLookup;
import com.fissy.dialer.phonelookup.cnap.CnapPhoneLookup_Factory;
import com.fissy.dialer.phonelookup.composite.CompositePhoneLookup;
import com.fissy.dialer.phonelookup.composite.CompositePhoneLookup_Factory;
import com.fissy.dialer.phonelookup.cp2.Cp2DefaultDirectoryPhoneLookup;
import com.fissy.dialer.phonelookup.cp2.Cp2DefaultDirectoryPhoneLookup_Factory;
import com.fissy.dialer.phonelookup.cp2.Cp2ExtendedDirectoryPhoneLookup;
import com.fissy.dialer.phonelookup.cp2.Cp2ExtendedDirectoryPhoneLookup_Factory;
import com.fissy.dialer.phonelookup.cp2.MissingPermissionsOperations_Factory;
import com.fissy.dialer.phonelookup.database.PhoneLookupDatabaseComponent;
import com.fissy.dialer.phonelookup.database.PhoneLookupHistoryDatabaseHelper;
import com.fissy.dialer.phonelookup.database.PhoneLookupHistoryDatabaseHelper_Factory;
import com.fissy.dialer.phonelookup.emergency.EmergencyPhoneLookup;
import com.fissy.dialer.phonelookup.emergency.EmergencyPhoneLookup_Factory;
import com.fissy.dialer.phonelookup.spam.SpamPhoneLookup;
import com.fissy.dialer.phonelookup.spam.SpamPhoneLookup_Factory;
import com.fissy.dialer.phonenumbergeoutil.PhoneNumberGeoUtil;
import com.fissy.dialer.phonenumbergeoutil.PhoneNumberGeoUtilComponent;
import com.fissy.dialer.phonenumbergeoutil.impl.PhoneNumberGeoUtilImpl_Factory;
import com.fissy.dialer.precall.PreCall;
import com.fissy.dialer.precall.PreCallAction;
import com.fissy.dialer.precall.PreCallComponent;
import com.fissy.dialer.precall.impl.CallingAccountSelector;
import com.fissy.dialer.precall.impl.CallingAccountSelector_Factory;
import com.fissy.dialer.precall.impl.DuoAction;
import com.fissy.dialer.precall.impl.DuoAction_Factory;
import com.fissy.dialer.precall.impl.PreCallImpl;
import com.fissy.dialer.precall.impl.PreCallImpl_Factory;
import com.fissy.dialer.precall.impl.PreCallModule_ProvideActionsFactory;
import com.fissy.dialer.preferredsim.PreferredAccountWorker;
import com.fissy.dialer.preferredsim.PreferredSimComponent;
import com.fissy.dialer.preferredsim.impl.PreferredAccountWorkerImpl;
import com.fissy.dialer.preferredsim.impl.PreferredAccountWorkerImpl_Factory;
import com.fissy.dialer.preferredsim.suggestion.SimSuggestionComponent;
import com.fissy.dialer.preferredsim.suggestion.SuggestionProvider;
import com.fissy.dialer.preferredsim.suggestion.stub.StubSuggestionProvider_Factory;
import com.fissy.dialer.promotion.Promotion;
import com.fissy.dialer.promotion.PromotionComponent;
import com.fissy.dialer.promotion.PromotionManager;
import com.fissy.dialer.promotion.PromotionManager_Factory;
import com.fissy.dialer.promotion.impl.DuoPromotion_Factory;
import com.fissy.dialer.promotion.impl.PromotionModule_ProvidePriorityPromotionListFactory;
import com.fissy.dialer.promotion.impl.RttPromotion;
import com.fissy.dialer.promotion.impl.RttPromotion_Factory;
import com.fissy.dialer.simulator.Simulator;
import com.fissy.dialer.simulator.SimulatorComponent;
import com.fissy.dialer.simulator.SimulatorConnectionsBank;
import com.fissy.dialer.simulator.SimulatorEnrichedCall;
import com.fissy.dialer.simulator.impl.SimulatorConnectionsBankImpl_Factory;
import com.fissy.dialer.simulator.impl.SimulatorImpl_Factory;
import com.fissy.dialer.simulator.stub.SimulatorEnrichedCallStub_Factory;
import com.fissy.dialer.spam.Spam;
import com.fissy.dialer.spam.SpamComponent;
import com.fissy.dialer.spam.SpamSettings;
import com.fissy.dialer.spam.stub.SpamSettingsStub_Factory;
import com.fissy.dialer.spam.stub.SpamStub;
import com.fissy.dialer.spam.stub.SpamStub_Factory;
import com.fissy.dialer.speeddial.loader.SpeedDialUiItemMutator;
import com.fissy.dialer.speeddial.loader.SpeedDialUiItemMutator_Factory;
import com.fissy.dialer.speeddial.loader.UiItemLoaderComponent;
import com.fissy.dialer.storage.StorageComponent;
import com.fissy.dialer.storage.StorageModule;
import com.fissy.dialer.storage.StorageModule_ProvideUnencryptedSharedPrefsFactory;
import com.fissy.dialer.strictmode.DialerStrictMode;
import com.fissy.dialer.strictmode.StrictModeComponent;
import com.fissy.dialer.strictmode.impl.SystemDialerStrictMode_Factory;
import com.fissy.dialer.theme.base.Theme;
import com.fissy.dialer.theme.base.ThemeComponent;
import com.fissy.dialer.theme.base.impl.AospThemeModule;
import com.fissy.dialer.theme.base.impl.AospThemeModule_ProvideThemeModuleFactory;
import com.android.incallui.call.CallList;
import com.android.incallui.calllocation.CallLocation;
import com.android.incallui.calllocation.CallLocationComponent;
import com.android.incallui.calllocation.stub.StubCallLocationModule_StubCallLocation_Factory;
import com.android.incallui.maps.Maps;
import com.android.incallui.maps.MapsComponent;
import com.android.incallui.maps.stub.StubMapsModule_StubMaps_Factory;
import com.android.incallui.speakeasy.SpeakEasyCallManager;
import com.android.incallui.speakeasy.SpeakEasyCallManagerStub_Factory;
import com.android.incallui.speakeasy.SpeakEasyComponent;
import com.android.incallui.speakeasy.StubSpeakEasyModule_ProvideSpeakEasyChipFactory;
import com.android.incallui.speakeasy.StubSpeakEasyModule_ProvideSpeakEasySettingsActivityFactory;
import com.android.incallui.speakeasy.StubSpeakEasyModule_ProvideSpeakEasySettingsObjectFactory;
import com.android.incallui.speakeasy.StubSpeakEasyModule_ProvideSpeakEasyTextResourceFactory;
import com.android.voicemail.VoicemailClient;
import com.android.voicemail.VoicemailComponent;
import com.android.voicemail.impl.VoicemailModule;
import com.android.voicemail.impl.VoicemailModule_ProvideVoicemailClientFactory;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListeningExecutorService;
import dagger.internal.DoubleCheck;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAospDialerRootComponent implements AospDialerRootComponent {
  private Provider<ActiveCalls> toProvider;

  private Provider<Bubble> bindsBubbleProvider;

  private Provider<Context> provideContextProvider;

  private Provider<ExecutorService> provideNonUiThreadPoolProvider;

  private Provider<ListeningExecutorService> provideBackgroundExecutorProvider;

  private Provider<SharedPreferences> provideUnencryptedSharedPrefsProvider;

  private Provider<RefreshAnnotatedCallLogNotifier> refreshAnnotatedCallLogNotifierProvider;

  private Provider<MarkDirtyObserver> markDirtyObserverProvider;

  private Provider<AnnotatedCallLogDatabaseHelper> annotatedCallLogDatabaseHelperProvider;

  private Provider<Duo> bindsDuoProvider;

  private Provider<SystemCallLogDataSource> systemCallLogDataSourceProvider;

  private Provider<ListeningExecutorService> provideLightweightExecutorProvider;

  private Provider<CequintPhoneLookup> cequintPhoneLookupProvider;

  private Provider<CnapPhoneLookup> cnapPhoneLookupProvider;

  private Provider<SharedPrefConfigProvider> sharedPrefConfigProvider;

  private Provider<ConfigProvider> toProvider2;

  @SuppressWarnings("rawtypes")
  private Provider missingPermissionsOperationsProvider;

  private Provider<Cp2DefaultDirectoryPhoneLookup> cp2DefaultDirectoryPhoneLookupProvider;

  private Provider<ScheduledExecutorService> provideNonUiSerialExecutorServiceProvider;

  private Provider<Cp2ExtendedDirectoryPhoneLookup> cp2ExtendedDirectoryPhoneLookupProvider;

  private Provider<EmergencyPhoneLookup> emergencyPhoneLookupProvider;

  private Provider<SystemBlockedNumberPhoneLookup> systemBlockedNumberPhoneLookupProvider;

  private Provider<SpamStub> spamStubProvider;

  private Provider<Spam> bindSpamProvider;

  private Provider<SpamPhoneLookup> spamPhoneLookupProvider;

  private Provider<ImmutableList<PhoneLookup>> providePhoneLookupListProvider;

  private Provider<StubMetrics> stubMetricsProvider;

  private Provider<Metrics> bindMetricsProvider;

  private Provider<FutureTimer> futureTimerProvider;

  private Provider<CallLogState> callLogStateProvider;

  private Provider<CompositePhoneLookup> compositePhoneLookupProvider;

  private Provider<PhoneLookupHistoryDatabaseHelper> phoneLookupHistoryDatabaseHelperProvider;

  private Provider<PhoneLookupDataSource> phoneLookupDataSourceProvider;

  private Provider<VoicemailDataSource> voicemailDataSourceProvider;

  private Provider<DataSources> provideCallLogDataSourcesProvider;

  private Provider<MutationApplier> mutationApplierProvider;

  private Provider<CallLogCacheUpdater> callLogCacheUpdaterProvider;

  private Provider<RefreshAnnotatedCallLogWorker> refreshAnnotatedCallLogWorkerProvider;

  private Provider<AnnotatedCallLogMigrator> annotatedCallLogMigratorProvider;

  private Provider<ListeningExecutorService> provideUiThreadExecutorServiceProvider;

  private Provider<CallLogFramework> callLogFrameworkProvider;

  private Provider<Help> helpProvider;

  private Provider<Version> versionProvider;

  private Provider<BlockingCommand> blockingCommandProvider;

  private Provider<CallCommand> callCommandProvider;

  private Provider<ActiveCallsCommand> activeCallsCommandProvider;

  private Provider<CommandLineModule.AospCommandInjector> aospCommandInjectorProvider;

  private Provider<Supplier<ImmutableMap<String, Command>>> provideCommandSupplierProvider;

  private Provider<ContactDisplayPreferencesImpl> contactDisplayPreferencesImplProvider;

  private Provider<ContactDisplayPreferences> provideContactDisplayPreferencesProvider;

  private Provider<ScheduledExecutorService> provideUiSerialExecutorServiceProvider;

  private Provider<EnrichedCallManager> provideEnrichedCallManagerProvider;

  private Provider<RcsVideoShareFactory> providesRcsVideoShareFactoryProvider;

  private Provider<CallList.Listener> provideCallFeedbackListenerProvider;

  private Provider<GlidePhotoManagerImpl> glidePhotoManagerImplProvider;

  private Provider<GlidePhotoManager> bindGlidePhotoManagerProvider;

  private Provider<Maps> bindMapsProvider;

  private Provider<PhoneNumberGeoUtil> bindPhoneNumberGeoUtilProvider;

  private Provider<DuoAction> duoActionProvider;

  private Provider<PreferredAccountWorkerImpl> preferredAccountWorkerImplProvider;

  private Provider<PreferredAccountWorker> toProvider3;

  private Provider<CallingAccountSelector> callingAccountSelectorProvider;

  private Provider<ImmutableList<PreCallAction>> provideActionsProvider;

  private Provider<PreCallImpl> preCallImplProvider;

  private Provider<PreCall> toProvider4;

  private Provider<RttPromotion> rttPromotionProvider;

  @SuppressWarnings("rawtypes")
  private Provider duoPromotionProvider;

  private Provider<ImmutableList<Promotion>> providePriorityPromotionListProvider;

  private Provider<HighResolutionPhotoRequesterImpl> highResolutionPhotoRequesterImplProvider;

  private Provider<HighResolutionPhotoRequester> toHighResolutionPhotoRequesterImplProvider;

  private Provider<SpeedDialUiItemMutator> speedDialUiItemMutatorProvider;

  private Provider<SuggestionProvider> bindSuggestionProvider;

  private Provider<Simulator> bindsSimulatorProvider;

  private Provider<SimulatorEnrichedCall> bindsSimulatorEnrichedCallProvider;

  private Provider<SimulatorConnectionsBank> bindsSimulatorConnectionsBankProvider;

  private Provider<DialerStrictMode> bindDialerStrictModeProvider;

  private Provider<Theme> provideThemeModuleProvider;

  private Provider<VoicemailClient> provideVoicemailClientProvider;

  private DaggerAospDialerRootComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.toProvider = DoubleCheck.provider((Provider) ActiveCallsImpl_Factory.create());

    this.bindsBubbleProvider = DoubleCheck.provider((Provider) BubbleStub_Factory.create());

    this.provideContextProvider = ContextModule_ProvideContextFactory.create(builder.contextModule);

    this.provideNonUiThreadPoolProvider =
        DoubleCheck.provider(DialerExecutorModule_ProvideNonUiThreadPoolFactory.create());

    this.provideBackgroundExecutorProvider =
        DoubleCheck.provider(
            DialerExecutorModule_ProvideBackgroundExecutorFactory.create(
                provideNonUiThreadPoolProvider));

    this.provideUnencryptedSharedPrefsProvider =
        DoubleCheck.provider(
            StorageModule_ProvideUnencryptedSharedPrefsFactory.create(provideContextProvider));

    this.refreshAnnotatedCallLogNotifierProvider =
        DoubleCheck.provider(
            RefreshAnnotatedCallLogNotifier_Factory.create(
                provideContextProvider, provideUnencryptedSharedPrefsProvider));

    this.markDirtyObserverProvider =
        MarkDirtyObserver_Factory.create(
            MembersInjectors.<MarkDirtyObserver>noOp(), refreshAnnotatedCallLogNotifierProvider);

    this.annotatedCallLogDatabaseHelperProvider =
        DoubleCheck.provider(
            AnnotatedCallLogDatabaseHelper_Factory.create(
                MembersInjectors.<AnnotatedCallLogDatabaseHelper>noOp(),
                provideContextProvider,
                CallLogDatabaseModule_ProvideMaxRowsFactory.create(),
                provideBackgroundExecutorProvider));

    this.bindsDuoProvider = DoubleCheck.provider((Provider) DuoStub_Factory.create());

    this.systemCallLogDataSourceProvider =
        DoubleCheck.provider(
            SystemCallLogDataSource_Factory.create(
                provideContextProvider,
                provideBackgroundExecutorProvider,
                markDirtyObserverProvider,
                provideUnencryptedSharedPrefsProvider,
                annotatedCallLogDatabaseHelperProvider,
                bindsDuoProvider));

    this.provideLightweightExecutorProvider =
        DoubleCheck.provider(
            DialerExecutorModule_ProvideLightweightExecutorFactory.create(
                DialerExecutorModule_ProvideUiThreadPoolFactory.create()));

    this.cequintPhoneLookupProvider =
        CequintPhoneLookup_Factory.create(
            provideContextProvider,
            provideBackgroundExecutorProvider,
            provideLightweightExecutorProvider);

    this.cnapPhoneLookupProvider =
        CnapPhoneLookup_Factory.create(provideContextProvider, provideBackgroundExecutorProvider);

    this.sharedPrefConfigProvider =
        SharedPrefConfigProvider_Factory.create(provideUnencryptedSharedPrefsProvider);

    this.toProvider2 = DoubleCheck.provider((Provider) sharedPrefConfigProvider);

    this.missingPermissionsOperationsProvider =
        MissingPermissionsOperations_Factory.create(
            provideContextProvider,
            provideBackgroundExecutorProvider,
            provideLightweightExecutorProvider);

    this.cp2DefaultDirectoryPhoneLookupProvider =
        Cp2DefaultDirectoryPhoneLookup_Factory.create(
            provideContextProvider,
            provideUnencryptedSharedPrefsProvider,
            provideBackgroundExecutorProvider,
            provideLightweightExecutorProvider,
            toProvider2,
            missingPermissionsOperationsProvider);

    this.provideNonUiSerialExecutorServiceProvider =
        DoubleCheck.provider(
            DialerExecutorModule_ProvideNonUiSerialExecutorServiceFactory.create());

    this.cp2ExtendedDirectoryPhoneLookupProvider =
        Cp2ExtendedDirectoryPhoneLookup_Factory.create(
            provideContextProvider,
            provideBackgroundExecutorProvider,
            provideLightweightExecutorProvider,
            provideNonUiSerialExecutorServiceProvider,
            toProvider2,
            missingPermissionsOperationsProvider);

    this.emergencyPhoneLookupProvider =
        EmergencyPhoneLookup_Factory.create(
            provideContextProvider, provideBackgroundExecutorProvider);

    this.systemBlockedNumberPhoneLookupProvider =
        SystemBlockedNumberPhoneLookup_Factory.create(
            provideContextProvider, provideBackgroundExecutorProvider, markDirtyObserverProvider);

    this.spamStubProvider = SpamStub_Factory.create(provideBackgroundExecutorProvider);

    this.bindSpamProvider = (Provider) spamStubProvider;

    this.spamPhoneLookupProvider =
        SpamPhoneLookup_Factory.create(
            provideBackgroundExecutorProvider,
            provideLightweightExecutorProvider,
            provideUnencryptedSharedPrefsProvider,
            bindSpamProvider);

    this.providePhoneLookupListProvider =
        PhoneLookupModule_ProvidePhoneLookupListFactory.create(
            cequintPhoneLookupProvider,
            cnapPhoneLookupProvider,
            cp2DefaultDirectoryPhoneLookupProvider,
            cp2ExtendedDirectoryPhoneLookupProvider,
            emergencyPhoneLookupProvider,
            systemBlockedNumberPhoneLookupProvider,
            spamPhoneLookupProvider);

    this.stubMetricsProvider = DoubleCheck.provider(StubMetrics_Factory.create());

    this.bindMetricsProvider = (Provider) stubMetricsProvider;

    this.futureTimerProvider =
        FutureTimer_Factory.create(bindMetricsProvider, provideLightweightExecutorProvider);

    this.callLogStateProvider =
        CallLogState_Factory.create(
            provideUnencryptedSharedPrefsProvider, provideBackgroundExecutorProvider);

    this.compositePhoneLookupProvider =
        CompositePhoneLookup_Factory.create(
            provideContextProvider,
            providePhoneLookupListProvider,
            futureTimerProvider,
            callLogStateProvider,
            provideLightweightExecutorProvider);

    this.phoneLookupHistoryDatabaseHelperProvider =
        DoubleCheck.provider(
            PhoneLookupHistoryDatabaseHelper_Factory.create(
                MembersInjectors.<PhoneLookupHistoryDatabaseHelper>noOp(),
                provideContextProvider,
                provideBackgroundExecutorProvider));

    this.phoneLookupDataSourceProvider =
        PhoneLookupDataSource_Factory.create(
            provideContextProvider,
            compositePhoneLookupProvider,
            provideBackgroundExecutorProvider,
            provideLightweightExecutorProvider,
            phoneLookupHistoryDatabaseHelperProvider);

    this.voicemailDataSourceProvider =
        VoicemailDataSource_Factory.create(
            provideContextProvider, provideBackgroundExecutorProvider);

    this.provideCallLogDataSourcesProvider =
        CallLogModule_ProvideCallLogDataSourcesFactory.create(
            systemCallLogDataSourceProvider,
            phoneLookupDataSourceProvider,
            voicemailDataSourceProvider);

    this.mutationApplierProvider =
        MutationApplier_Factory.create(provideBackgroundExecutorProvider);

    this.callLogCacheUpdaterProvider =
        CallLogCacheUpdater_Factory.create(
            provideContextProvider, provideBackgroundExecutorProvider, callLogStateProvider);

    this.refreshAnnotatedCallLogWorkerProvider =
        DoubleCheck.provider(
            RefreshAnnotatedCallLogWorker_Factory.create(
                provideContextProvider,
                provideCallLogDataSourcesProvider,
                provideUnencryptedSharedPrefsProvider,
                mutationApplierProvider,
                futureTimerProvider,
                callLogStateProvider,
                callLogCacheUpdaterProvider,
                provideBackgroundExecutorProvider,
                provideLightweightExecutorProvider));

    this.annotatedCallLogMigratorProvider =
        AnnotatedCallLogMigrator_Factory.create(
            provideUnencryptedSharedPrefsProvider,
            provideBackgroundExecutorProvider,
            refreshAnnotatedCallLogWorkerProvider);

    this.provideUiThreadExecutorServiceProvider =
        DoubleCheck.provider(DialerExecutorModule_ProvideUiThreadExecutorServiceFactory.create());

    this.callLogFrameworkProvider =
        DoubleCheck.provider(
            CallLogFramework_Factory.create(
                provideContextProvider,
                provideCallLogDataSourcesProvider,
                annotatedCallLogMigratorProvider,
                provideUiThreadExecutorServiceProvider,
                callLogStateProvider));

    this.helpProvider = Help_Factory.create(provideContextProvider);

    this.versionProvider = Version_Factory.create(provideContextProvider);

    this.blockingCommandProvider =
        BlockingCommand_Factory.create(provideContextProvider, provideBackgroundExecutorProvider);

    this.callCommandProvider = CallCommand_Factory.create(provideContextProvider);

    this.activeCallsCommandProvider = ActiveCallsCommand_Factory.create(provideContextProvider);

    this.aospCommandInjectorProvider =
        CommandLineModule_AospCommandInjector_Factory.create(
            helpProvider,
            versionProvider,
            Echo_Factory.create(),
            blockingCommandProvider,
            callCommandProvider,
            activeCallsCommandProvider);

    this.provideCommandSupplierProvider =
        CommandLineModule_ProvideCommandSupplierFactory.create(aospCommandInjectorProvider);

    this.contactDisplayPreferencesImplProvider =
        ContactDisplayPreferencesImpl_Factory.create(provideContextProvider);

    this.provideContactDisplayPreferencesProvider =
        ContactsModule_ProvideContactDisplayPreferencesFactory.create(
            provideContextProvider,
            contactDisplayPreferencesImplProvider,
            ContactDisplayPreferencesStub_Factory.create());

    this.provideUiSerialExecutorServiceProvider =
        DoubleCheck.provider(DialerExecutorModule_ProvideUiSerialExecutorServiceFactory.create());

    this.provideEnrichedCallManagerProvider =
        DoubleCheck.provider(StubEnrichedCallModule_ProvideEnrichedCallManagerFactory.create());

    this.providesRcsVideoShareFactoryProvider =
        DoubleCheck.provider(StubEnrichedCallModule_ProvidesRcsVideoShareFactoryFactory.create());

    this.provideCallFeedbackListenerProvider =
        StubFeedbackModule_ProvideCallFeedbackListenerFactory.create(provideContextProvider);

    this.glidePhotoManagerImplProvider =
        GlidePhotoManagerImpl_Factory.create(provideContextProvider);

    this.bindGlidePhotoManagerProvider =
        DoubleCheck.provider((Provider) glidePhotoManagerImplProvider);

    this.bindMapsProvider =
        DoubleCheck.provider((Provider) StubMapsModule_StubMaps_Factory.create());

    this.bindPhoneNumberGeoUtilProvider =
        DoubleCheck.provider((Provider) PhoneNumberGeoUtilImpl_Factory.create());

    this.duoActionProvider = DuoAction_Factory.create(provideUiThreadExecutorServiceProvider);

    this.preferredAccountWorkerImplProvider =
        PreferredAccountWorkerImpl_Factory.create(
            provideContextProvider, provideBackgroundExecutorProvider);

    this.toProvider3 = (Provider) preferredAccountWorkerImplProvider;

    this.callingAccountSelectorProvider = CallingAccountSelector_Factory.create(toProvider3);

    this.provideActionsProvider =
        PreCallModule_ProvideActionsFactory.create(
            duoActionProvider, callingAccountSelectorProvider);

    this.preCallImplProvider = PreCallImpl_Factory.create(provideActionsProvider);

    this.toProvider4 = DoubleCheck.provider((Provider) preCallImplProvider);

    this.rttPromotionProvider =
        RttPromotion_Factory.create(
            provideContextProvider, provideUnencryptedSharedPrefsProvider, toProvider2);

    this.duoPromotionProvider =
        DuoPromotion_Factory.create(
            provideContextProvider,
            toProvider2,
            bindsDuoProvider,
            provideUnencryptedSharedPrefsProvider);

    this.providePriorityPromotionListProvider =
        PromotionModule_ProvidePriorityPromotionListFactory.create(
            rttPromotionProvider, duoPromotionProvider);

    this.highResolutionPhotoRequesterImplProvider =
        HighResolutionPhotoRequesterImpl_Factory.create(
            provideContextProvider, provideBackgroundExecutorProvider);

    this.toHighResolutionPhotoRequesterImplProvider =
        (Provider) highResolutionPhotoRequesterImplProvider;

    this.speedDialUiItemMutatorProvider =
        DoubleCheck.provider(
            SpeedDialUiItemMutator_Factory.create(
                provideContextProvider,
                provideBackgroundExecutorProvider,
                provideContactDisplayPreferencesProvider,
                toHighResolutionPhotoRequesterImplProvider));

    this.bindSuggestionProvider =
        DoubleCheck.provider((Provider) StubSuggestionProvider_Factory.create());

    this.bindsSimulatorProvider = DoubleCheck.provider((Provider) SimulatorImpl_Factory.create());

    this.bindsSimulatorEnrichedCallProvider =
        DoubleCheck.provider((Provider) SimulatorEnrichedCallStub_Factory.create());

    this.bindsSimulatorConnectionsBankProvider =
        DoubleCheck.provider((Provider) SimulatorConnectionsBankImpl_Factory.create());

    this.bindDialerStrictModeProvider =
        DoubleCheck.provider((Provider) SystemDialerStrictMode_Factory.create());

    this.provideThemeModuleProvider =
        AospThemeModule_ProvideThemeModuleFactory.create(provideContextProvider);

    this.provideVoicemailClientProvider =
        DoubleCheck.provider(
            VoicemailModule_ProvideVoicemailClientFactory.create(provideContextProvider));
  }

  @Override
  public ActiveCallsComponent activeCallsComponent() {
    return new ActiveCallsComponentImpl();
  }

  @Override
  public BubbleComponent bubbleComponent() {
    return new BubbleComponentImpl();
  }

  @Override
  public CallLocationComponent callLocationComponent() {
    return new CallLocationComponentImpl();
  }

  @Override
  public CallLogComponent callLogComponent() {
    return new CallLogComponentImpl();
  }

  @Override
  public CallLogConfigComponent callLogConfigComponent() {
    return new CallLogConfigComponentImpl();
  }

  @Override
  public CallLogDatabaseComponent callLogDatabaseComponent() {
    return new CallLogDatabaseComponentImpl();
  }

  @Override
  public CallLogUiComponent callLogUiComponent() {
    return new CallLogUiComponentImpl();
  }

  @Override
  public ConfigProviderComponent configProviderComponent() {
    return new ConfigProviderComponentImpl();
  }

  @Override
  public CommandLineComponent commandLineComponent() {
    return new CommandLineComponentImpl();
  }

  @Override
  public ContactsComponent contactsComponent() {
    return new ContactsComponentImpl();
  }

  @Override
  public DialerExecutorComponent dialerExecutorComponent() {
    return new DialerExecutorComponentImpl();
  }

  @Override
  public DuoComponent duoComponent() {
    return new DuoComponentImpl();
  }

  @Override
  public EnrichedCallComponent enrichedCallComponent() {
    return new EnrichedCallComponentImpl();
  }

  @Override
  public FeedbackComponent feedbackComponent() {
    return new FeedbackComponentImpl();
  }

  @Override
  public GlidePhotoManagerComponent glidePhotoManagerComponent() {
    return new GlidePhotoManagerComponentImpl();
  }

  @Override
  public MapsComponent mapsComponent() {
    return new MapsComponentImpl();
  }

  @Override
  public MetricsComponent metricsComponent() {
    return new MetricsComponentImpl();
  }

  @Override
  public PhoneLookupComponent phoneLookupComponent() {
    return new PhoneLookupComponentImpl();
  }

  @Override
  public PhoneLookupDatabaseComponent phoneLookupDatabaseComponent() {
    return new PhoneLookupDatabaseComponentImpl();
  }

  @Override
  public PhoneNumberGeoUtilComponent phoneNumberGeoUtilComponent() {
    return new PhoneNumberGeoUtilComponentImpl();
  }

  @Override
  public PreCallComponent preCallActionsComponent() {
    return new PreCallComponentImpl();
  }

  @Override
  public PreferredSimComponent preferredSimComponent() {
    return new PreferredSimComponentImpl();
  }

  @Override
  public PromotionComponent promotionComponent() {
    return new PromotionComponentImpl();
  }

  @Override
  public UiItemLoaderComponent uiItemLoaderComponent() {
    return new UiItemLoaderComponentImpl();
  }

  @Override
  public SimSuggestionComponent simSuggestionComponent() {
    return new SimSuggestionComponentImpl();
  }

  @Override
  public SimulatorComponent simulatorComponent() {
    return new SimulatorComponentImpl();
  }

  @Override
  public SpamComponent spamComponent() {
    return new SpamComponentImpl();
  }

  @Override
  public SpeakEasyComponent speakEasyComponent() {
    return new SpeakEasyComponentImpl();
  }

  @Override
  public StorageComponent storageComponent() {
    return new StorageComponentImpl();
  }

  @Override
  public StrictModeComponent strictModeComponent() {
    return new StrictModeComponentImpl();
  }

  @Override
  public ThemeComponent themeComponent() {
    return new ThemeComponentImpl();
  }

  @Override
  public VoicemailComponent voicemailComponent() {
    return new VoicemailComponentImpl();
  }

  public static final class Builder {
    private ContextModule contextModule;

    private Builder() {}

    public AospDialerRootComponent build() {
      if (contextModule == null) {
        throw new IllegalStateException(ContextModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerAospDialerRootComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder callLogDatabaseModule(CallLogDatabaseModule callLogDatabaseModule) {
      Preconditions.checkNotNull(callLogDatabaseModule);
      return this;
    }

    public Builder contextModule(ContextModule contextModule) {
      this.contextModule = Preconditions.checkNotNull(contextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder storageModule(StorageModule storageModule) {
      Preconditions.checkNotNull(storageModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder stubEnrichedCallModule(StubEnrichedCallModule stubEnrichedCallModule) {
      Preconditions.checkNotNull(stubEnrichedCallModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder stubFeedbackModule(StubFeedbackModule stubFeedbackModule) {
      Preconditions.checkNotNull(stubFeedbackModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder aospThemeModule(AospThemeModule aospThemeModule) {
      Preconditions.checkNotNull(aospThemeModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder voicemailModule(VoicemailModule voicemailModule) {
      Preconditions.checkNotNull(voicemailModule);
      return this;
    }
  }

  private final class ActiveCallsComponentImpl extends ActiveCallsComponent {
    private ActiveCallsComponentImpl() {}

    @Override
    public ActiveCalls activeCalls() {
      return DaggerAospDialerRootComponent.this.toProvider.get();
    }
  }

  private final class BubbleComponentImpl extends BubbleComponent {
    private BubbleComponentImpl() {}

    @Override
    public Bubble getBubble() {
      return DaggerAospDialerRootComponent.this.bindsBubbleProvider.get();
    }
  }

  private final class CallLocationComponentImpl extends CallLocationComponent {
    private Provider<CallLocation> bindCallLocationProvider;

    private CallLocationComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.bindCallLocationProvider =
          (Provider) StubCallLocationModule_StubCallLocation_Factory.create();
    }

    @Override
    public CallLocation getCallLocation() {
      return bindCallLocationProvider.get();
    }
  }

  private final class CallLogComponentImpl extends CallLogComponent {
    private Provider<ClearMissedCalls> clearMissedCallsProvider;

    private CallLogComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.clearMissedCallsProvider =
          ClearMissedCalls_Factory.create(
              DaggerAospDialerRootComponent.this.provideContextProvider,
              DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider,
              DaggerAospDialerRootComponent.this.provideUiThreadExecutorServiceProvider);
    }

    @Override
    public CallLogFramework callLogFramework() {
      return DaggerAospDialerRootComponent.this.callLogFrameworkProvider.get();
    }

    @Override
    public RefreshAnnotatedCallLogNotifier getRefreshAnnotatedCallLogNotifier() {
      return DaggerAospDialerRootComponent.this.refreshAnnotatedCallLogNotifierProvider.get();
    }

    @Override
    public RefreshAnnotatedCallLogWorker getRefreshAnnotatedCallLogWorker() {
      return DaggerAospDialerRootComponent.this.refreshAnnotatedCallLogWorkerProvider.get();
    }

    @Override
    public ClearMissedCalls getClearMissedCalls() {
      return clearMissedCallsProvider.get();
    }
  }

  private final class CallLogConfigComponentImpl extends CallLogConfigComponent {
    private Provider<CallLogConfigImpl> callLogConfigImplProvider;

    private Provider<CallLogConfig> toProvider;

    private CallLogConfigComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.callLogConfigImplProvider =
          CallLogConfigImpl_Factory.create(
              DaggerAospDialerRootComponent.this.provideContextProvider,
              DaggerAospDialerRootComponent.this.callLogFrameworkProvider,
              DaggerAospDialerRootComponent.this.provideUnencryptedSharedPrefsProvider,
              DaggerAospDialerRootComponent.this.toProvider2,
              DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider);

      this.toProvider = (Provider) callLogConfigImplProvider;
    }

    @Override
    public CallLogConfig callLogConfig() {
      return toProvider.get();
    }
  }

  private final class CallLogDatabaseComponentImpl extends CallLogDatabaseComponent {
    private Provider<Coalescer> coalescerProvider;

    private CallLogDatabaseComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.coalescerProvider =
          Coalescer_Factory.create(
              DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider,
              DaggerAospDialerRootComponent.this.futureTimerProvider);
    }

    @Override
    public Coalescer coalescer() {
      return coalescerProvider.get();
    }

    @Override
    public AnnotatedCallLogDatabaseHelper annotatedCallLogDatabaseHelper() {
      return DaggerAospDialerRootComponent.this.annotatedCallLogDatabaseHelperProvider.get();
    }
  }

  private final class CallLogUiComponentImpl extends CallLogUiComponent {
    private Provider<RealtimeRowProcessor> realtimeRowProcessorProvider;

    private CallLogUiComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.realtimeRowProcessorProvider =
          RealtimeRowProcessor_Factory.create(
              DaggerAospDialerRootComponent.this.provideContextProvider,
              DaggerAospDialerRootComponent.this.provideUiThreadExecutorServiceProvider,
              DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider,
              DaggerAospDialerRootComponent.this.compositePhoneLookupProvider);
    }

    @Override
    public RealtimeRowProcessor realtimeRowProcessor() {
      return realtimeRowProcessorProvider.get();
    }
  }

  private final class ConfigProviderComponentImpl extends ConfigProviderComponent {
    private ConfigProviderComponentImpl() {}

    @Override
    public ConfigProvider getConfigProvider() {
      return DaggerAospDialerRootComponent.this.toProvider2.get();
    }
  }

  private final class CommandLineComponentImpl extends CommandLineComponent {
    private CommandLineComponentImpl() {}

    @Override
    public Supplier<ImmutableMap<String, Command>> commandSupplier() {
      return DaggerAospDialerRootComponent.this.provideCommandSupplierProvider.get();
    }
  }

  private final class ContactsComponentImpl extends ContactsComponent {
    private Provider<HighResolutionPhotoRequesterImpl> highResolutionPhotoRequesterImplProvider;

    private Provider<HighResolutionPhotoRequester> toHighResolutionPhotoRequesterImplProvider;

    private ContactsComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.highResolutionPhotoRequesterImplProvider =
          HighResolutionPhotoRequesterImpl_Factory.create(
              DaggerAospDialerRootComponent.this.provideContextProvider,
              DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider);

      this.toHighResolutionPhotoRequesterImplProvider =
          (Provider) highResolutionPhotoRequesterImplProvider;
    }

    @Override
    public ContactDisplayPreferences contactDisplayPreferences() {
      return DaggerAospDialerRootComponent.this.provideContactDisplayPreferencesProvider.get();
    }

    @Override
    public HighResolutionPhotoRequester highResolutionPhotoLoader() {
      return toHighResolutionPhotoRequesterImplProvider.get();
    }
  }

  private final class DialerExecutorComponentImpl extends DialerExecutorComponent {
    private Provider<DefaultDialerExecutorFactory> defaultDialerExecutorFactoryProvider;

    private Provider<DialerExecutorFactory> bindDialerExecutorFactoryProvider;

    private DialerExecutorComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.defaultDialerExecutorFactoryProvider =
          DefaultDialerExecutorFactory_Factory.create(
              DaggerAospDialerRootComponent.this.provideNonUiThreadPoolProvider,
              DaggerAospDialerRootComponent.this.provideNonUiSerialExecutorServiceProvider,
              DialerExecutorModule_ProvideUiThreadPoolFactory.create(),
              DaggerAospDialerRootComponent.this.provideUiSerialExecutorServiceProvider);

      this.bindDialerExecutorFactoryProvider = (Provider) defaultDialerExecutorFactoryProvider;
    }

    @Override
    public DialerExecutorFactory dialerExecutorFactory() {
      return bindDialerExecutorFactoryProvider.get();
    }

    @Override
    public ExecutorService lowPriorityThreadPool() {
      return DaggerAospDialerRootComponent.this.provideNonUiThreadPoolProvider.get();
    }

    @Override
    public ListeningExecutorService uiExecutor() {
      return DaggerAospDialerRootComponent.this.provideUiThreadExecutorServiceProvider.get();
    }

    @Override
    public ListeningExecutorService backgroundExecutor() {
      return DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider.get();
    }

    @Override
    public ListeningExecutorService lightweightExecutor() {
      return DaggerAospDialerRootComponent.this.provideLightweightExecutorProvider.get();
    }
  }

  private final class DuoComponentImpl extends DuoComponent {
    private DuoComponentImpl() {}

    @Override
    public Duo getDuo() {
      return DaggerAospDialerRootComponent.this.bindsDuoProvider.get();
    }
  }

  private final class EnrichedCallComponentImpl extends EnrichedCallComponent {
    private EnrichedCallComponentImpl() {}

    @Override
    public EnrichedCallManager getEnrichedCallManager() {
      return DaggerAospDialerRootComponent.this.provideEnrichedCallManagerProvider.get();
    }

    @Override
    public RcsVideoShareFactory getRcsVideoShareFactory() {
      return DaggerAospDialerRootComponent.this.providesRcsVideoShareFactoryProvider.get();
    }
  }

  private final class FeedbackComponentImpl extends FeedbackComponent {
    private FeedbackComponentImpl() {}

    @Override
    public CallList.Listener getCallFeedbackListener() {
      return DaggerAospDialerRootComponent.this.provideCallFeedbackListenerProvider.get();
    }

    @Override
    public FeedbackSender getCallFeedbackSender() {
      return StubFeedbackModule_ProvideCallFeedbackSenderFactory.create().get();
    }
  }

  private final class GlidePhotoManagerComponentImpl extends GlidePhotoManagerComponent {
    private GlidePhotoManagerComponentImpl() {}

    @Override
    public GlidePhotoManager glidePhotoManager() {
      return DaggerAospDialerRootComponent.this.bindGlidePhotoManagerProvider.get();
    }
  }

  private final class MapsComponentImpl extends MapsComponent {
    private MapsComponentImpl() {}

    @Override
    public Maps getMaps() {
      return DaggerAospDialerRootComponent.this.bindMapsProvider.get();
    }
  }

  private final class MetricsComponentImpl extends MetricsComponent {
    private Provider<Metrics.Initializer> bindMetricsInitializerProvider;

    private MetricsComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.bindMetricsInitializerProvider = (Provider) StubMetricsInitializer_Factory.create();
    }

    @Override
    public Metrics metrics() {
      return DaggerAospDialerRootComponent.this.bindMetricsProvider.get();
    }

    @Override
    public Metrics.Initializer metricsInitializer() {
      return bindMetricsInitializerProvider.get();
    }

    @Override
    public FutureTimer futureTimer() {
      return DaggerAospDialerRootComponent.this.futureTimerProvider.get();
    }
  }

  private final class PhoneLookupComponentImpl extends PhoneLookupComponent {
    private PhoneLookupComponentImpl() {}

    @Override
    public CompositePhoneLookup compositePhoneLookup() {
      return DaggerAospDialerRootComponent.this.compositePhoneLookupProvider.get();
    }
  }

  private final class PhoneLookupDatabaseComponentImpl extends PhoneLookupDatabaseComponent {
    private PhoneLookupDatabaseComponentImpl() {}

    @Override
    public PhoneLookupHistoryDatabaseHelper phoneLookupHistoryDatabaseHelper() {
      return DaggerAospDialerRootComponent.this.phoneLookupHistoryDatabaseHelperProvider.get();
    }
  }

  private final class PhoneNumberGeoUtilComponentImpl extends PhoneNumberGeoUtilComponent {
    private PhoneNumberGeoUtilComponentImpl() {}

    @Override
    public PhoneNumberGeoUtil getPhoneNumberGeoUtil() {
      return DaggerAospDialerRootComponent.this.bindPhoneNumberGeoUtilProvider.get();
    }
  }

  private final class PreCallComponentImpl extends PreCallComponent {
    private PreCallComponentImpl() {}

    @Override
    public PreCall getPreCall() {
      return DaggerAospDialerRootComponent.this.toProvider4.get();
    }

    @Override
    public ImmutableList<PreCallAction> createActions() {
      return DaggerAospDialerRootComponent.this.provideActionsProvider.get();
    }
  }

  private final class PreferredSimComponentImpl extends PreferredSimComponent {
    private PreferredSimComponentImpl() {}

    @Override
    public PreferredAccountWorker preferredAccountWorker() {
      return DaggerAospDialerRootComponent.this.toProvider3.get();
    }
  }

  private final class PromotionComponentImpl extends PromotionComponent {
    private Provider<PromotionManager> promotionManagerProvider;

    private PromotionComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.promotionManagerProvider =
          PromotionManager_Factory.create(
              DaggerAospDialerRootComponent.this.providePriorityPromotionListProvider);
    }

    @Override
    public PromotionManager promotionManager() {
      return promotionManagerProvider.get();
    }

    @Override
    public ImmutableList<Promotion> priorityPromotionList() {
      return DaggerAospDialerRootComponent.this.providePriorityPromotionListProvider.get();
    }
  }

  private final class UiItemLoaderComponentImpl extends UiItemLoaderComponent {
    private UiItemLoaderComponentImpl() {}

    @Override
    public SpeedDialUiItemMutator speedDialUiItemMutator() {
      return DaggerAospDialerRootComponent.this.speedDialUiItemMutatorProvider.get();
    }
  }

  private final class SimSuggestionComponentImpl extends SimSuggestionComponent {
    private SimSuggestionComponentImpl() {}

    @Override
    public SuggestionProvider getSuggestionProvider() {
      return DaggerAospDialerRootComponent.this.bindSuggestionProvider.get();
    }
  }

  private final class SimulatorComponentImpl extends SimulatorComponent {
    private SimulatorComponentImpl() {}

    @Override
    public Simulator getSimulator() {
      return DaggerAospDialerRootComponent.this.bindsSimulatorProvider.get();
    }

    @Override
    public SimulatorEnrichedCall getSimulatorEnrichedCall() {
      return DaggerAospDialerRootComponent.this.bindsSimulatorEnrichedCallProvider.get();
    }

    @Override
    public SimulatorConnectionsBank getSimulatorConnectionsBank() {
      return DaggerAospDialerRootComponent.this.bindsSimulatorConnectionsBankProvider.get();
    }
  }

  private final class SpamComponentImpl extends SpamComponent {
    private Provider<SpamSettings> bindSpamSettingsProvider;

    private SpamComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.bindSpamSettingsProvider = (Provider) SpamSettingsStub_Factory.create();
    }

    @Override
    public Spam spam() {
      return DaggerAospDialerRootComponent.this.bindSpamProvider.get();
    }

    @Override
    public SpamSettings spamSettings() {
      return bindSpamSettingsProvider.get();
    }
  }

  private final class SpeakEasyComponentImpl extends SpeakEasyComponent {
    private Provider<SpeakEasyCallManager> bindsSpeakEasyProvider;

    private SpeakEasyComponentImpl() {
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.bindsSpeakEasyProvider = (Provider) SpeakEasyCallManagerStub_Factory.create();
    }

    @Override
    public SpeakEasyCallManager speakEasyCallManager() {
      return bindsSpeakEasyProvider.get();
    }

    @Override
    public Optional<PreferenceActivity> speakEasySettingsActivity() {
      return StubSpeakEasyModule_ProvideSpeakEasySettingsActivityFactory.create().get();
    }

    @Override
    public Optional<Object> speakEasySettingsObject() {
      return StubSpeakEasyModule_ProvideSpeakEasySettingsObjectFactory.create().get();
    }

    @Override
    public Optional<Integer> speakEasyChip() {
      return StubSpeakEasyModule_ProvideSpeakEasyChipFactory.create().get();
    }

    @Override
    public Optional<Integer> speakEasyTextResource() {
      return StubSpeakEasyModule_ProvideSpeakEasyTextResourceFactory.create().get();
    }
  }

  private final class StorageComponentImpl extends StorageComponent {
    private StorageComponentImpl() {}

    @Override
    public SharedPreferences unencryptedSharedPrefs() {
      return DaggerAospDialerRootComponent.this.provideUnencryptedSharedPrefsProvider.get();
    }
  }

  private final class StrictModeComponentImpl extends StrictModeComponent {
    private StrictModeComponentImpl() {}

    @Override
    public DialerStrictMode getDialerStrictMode() {
      return DaggerAospDialerRootComponent.this.bindDialerStrictModeProvider.get();
    }
  }

  private final class ThemeComponentImpl extends ThemeComponent {
    private ThemeComponentImpl() {}

    @Override
    public Theme theme() {
      return DaggerAospDialerRootComponent.this.provideThemeModuleProvider.get();
    }
  }

  private final class VoicemailComponentImpl extends VoicemailComponent {
    private VoicemailComponentImpl() {}

    @Override
    public VoicemailClient getVoicemailClient() {
      return DaggerAospDialerRootComponent.this.provideVoicemailClientProvider.get();
    }
  }
}
