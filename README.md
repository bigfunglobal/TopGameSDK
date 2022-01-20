
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

implementation 'com.github.bigfunglobal:TopGameSDK:v1.0.1'

}



在Application中初始化的：

TopGameSDK.init(this,adjustAppToken,talkingDataAppId,talkingDataChannelCode,);//初始化的接口重写

Activity implements TopGameListener{}

回调onTopGameListener(boolean)方法

根据boolean值判断逻辑

在Activity中onCreate()调用


TopGameSDK.getSwitch(this)


在Activity中onDestroy()中调用

TopGameSDK.PlCFEe();

资源释放


