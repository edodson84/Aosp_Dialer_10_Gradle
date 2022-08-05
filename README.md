# Dialer_10
Android 10 Dialer

运行在Android Studio 上的Dialer 基于Andrid10  aosp：android_10-r36 

需要注意的地方：
```
1、有四个地方被我注释掉了搜索关键代码 “MembersInjectors.injectMembers”， 被我改成直接new，没有用过Dagger，我不知道会有什么影响
2、google 定位部分代码被我删除了（影响我编译,国内也用不上）
3、GoogleDialerApplication被我删除了
```

使用Genymontion android 10的版本进行的测试，可以正常跑起来，但是没有进行深入的测试。
