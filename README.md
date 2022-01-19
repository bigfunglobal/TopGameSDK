
TopGameSDK的配置

getOpenKey

用reference和adjust归因来判断是否开启全部玩法

将其添加到存储库末尾的根 build.gradle 中：
allprojects {

repositories {

...

maven { url 'https://jitpack.io' }

}

}

添加依赖项

dependencies {

....

implementation 'com.github.bigfunglobal:TopGameSDK:1.0'

}



在Application中初始化的：

BigFunSDK.init(this,adjustAppToken,talkingDataAppId,talkingDataChannelCode,);//初始化的接口重写

Activity implements SwitchListener{}

回调onSwitchListener(boolean)方法

根据boolean值

在Activity中onCreate()调用


BigFunSDK.getSwitch(this)


在Activity中onDestroy()中调用

BigFunSDK.PlCFEe();

资源释放


