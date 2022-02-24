
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

implementation 'com.github.bigfunglobal:TopGameSDK:v1.0.2'

}



在Application中初始化的：

TopGameSDK.init(this,adjustAppToken,talkingDataAppId);//初始化的接口重写

在Activity中通过：

TopGameSDK.getSwitch(); 来获取开关值 

根据返回的boolean进行判断 值：True的时候打开真金模式，False的时候设置监听：

TopGameSDK.setListener(this);

实现TopGameListener 

1）监听 onTopGameListener(boolean b)根据boolean 进行逻辑判断

b值：True为打开；False为关闭


接口方法说明：TopGameSDK.getSwitch();方法没有获取到开关时，调用TopGameSDK。setListener(this)方法来获取开关


在Activity中onDestroy()中调用

TopGameSDK.onDestroy();

资源释放



