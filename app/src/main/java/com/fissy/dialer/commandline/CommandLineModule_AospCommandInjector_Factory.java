package com.fissy.dialer.commandline;

import com.fissy.dialer.commandline.impl.ActiveCallsCommand;
import com.fissy.dialer.commandline.impl.BlockingCommand;
import com.fissy.dialer.commandline.impl.CallCommand;
import com.fissy.dialer.commandline.impl.Echo;
import com.fissy.dialer.commandline.impl.Help;
import com.fissy.dialer.commandline.impl.Version;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class CommandLineModule_AospCommandInjector_Factory
        implements Factory<CommandLineModule.AospCommandInjector> {
    private final Provider<Help> helpProvider;

    private final Provider<Version> versionProvider;

    private final Provider<Echo> echoProvider;

    private final Provider<BlockingCommand> blockingCommandProvider;

    private final Provider<CallCommand> callCommandProvider;

    private final Provider<ActiveCallsCommand> activeCallsCommandProvider;

    public CommandLineModule_AospCommandInjector_Factory(
            Provider<Help> helpProvider,
            Provider<Version> versionProvider,
            Provider<Echo> echoProvider,
            Provider<BlockingCommand> blockingCommandProvider,
            Provider<CallCommand> callCommandProvider,
            Provider<ActiveCallsCommand> activeCallsCommandProvider) {
        assert helpProvider != null;
        this.helpProvider = helpProvider;
        assert versionProvider != null;
        this.versionProvider = versionProvider;
        assert echoProvider != null;
        this.echoProvider = echoProvider;
        assert blockingCommandProvider != null;
        this.blockingCommandProvider = blockingCommandProvider;
        assert callCommandProvider != null;
        this.callCommandProvider = callCommandProvider;
        assert activeCallsCommandProvider != null;
        this.activeCallsCommandProvider = activeCallsCommandProvider;
    }

    public static Factory<CommandLineModule.AospCommandInjector> create(
            Provider<Help> helpProvider,
            Provider<Version> versionProvider,
            Provider<Echo> echoProvider,
            Provider<BlockingCommand> blockingCommandProvider,
            Provider<CallCommand> callCommandProvider,
            Provider<ActiveCallsCommand> activeCallsCommandProvider) {
        return new CommandLineModule_AospCommandInjector_Factory(
                helpProvider,
                versionProvider,
                echoProvider,
                blockingCommandProvider,
                callCommandProvider,
                activeCallsCommandProvider);
    }

    @Override
    public CommandLineModule.AospCommandInjector get() {
        return new CommandLineModule.AospCommandInjector(
                helpProvider.get(),
                versionProvider.get(),
                echoProvider.get(),
                blockingCommandProvider.get(),
                callCommandProvider.get(),
                activeCallsCommandProvider.get());
    }
}
