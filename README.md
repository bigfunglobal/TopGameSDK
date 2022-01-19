# adjustsdk
bigfunglobalsdk的配置

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

implementation 'com.github.bigfunglobal:adjustsdk:v1.0'

}



初始化的：

Application extends GlobalApplication{}

重写GlobalApplication()的无参方法调用：super()


代码如下：

Public class Application extends GlobalApplication{

/**
*appToken,TalkingDatId,TalkingDatName,SPName,SPModel
*这些变量自己定义
*/

/**
*appToken是adjust的appToken
*
*TalkingDatId是TalkingDataGA的app ID
*
*TalkingDatName是TalkingDataGA的渠道
*
*SPName是SharedPreferences的存储名称
*
*SPModel是SharedPreferences的打开的方式
*/


public Application() {

    super(appToken,TalkingDatId,TalkingDatName,SPName,SPModel);
    
}

@Override

public void onCreate() {

    super.onCreate();
    
}

}


Activity implements GetIntoNoodlesA，GetIntoNoodlesB{}

2个接口回调 gotA(),gotB()方法

onCreate()中调用

JudgeSpAB.getInstance().setCallBack(this, this);


gotA():跳转A面

gotB():跳转B面

aBoolean：判断是否是一次打开应用

调用：

aBoolean=JudgeSpAB.getInstance().naciulmlkn(sp);

SharedPreferences：获取缓存数据

调用：

sp=AdjustUtils.getInstance().getSharedPreferences(getInstance(),SPName,SPModel);


installReferrer：进入B面快关  为””时为获取的数据，不为空根据installReferrer的赋值判断

if (!aBoolean)

    InstallReferrer.getInstance().init(sp,10000,getInstance(),installReferrer);

在onDestroy()中调用

InstallReferrer.getInstance().PlCFEe();

代码如下：

public class MainActivity extends AppCompatActivity implements GetIntoNoodlesA, GetIntoNoodlesB {

static MainActivity tnnpvanb;

public static MainActivity getInstance() {

    return tnnpvanb;
    
}

public static String SPName() {

    return "profile";
    
}

public static int SPModel() {

    return Context.MODE_PRIVATE;
    
}

static SharedPreferences sp;

static boolean aBoolean;

private static String installReferrer="";

@Override

protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);   

setContentView(R.layout.activity_main);  

JudgeSpAB.getInstance().setCallBack(this, this);

tnnpvanb = this;

//第二次进入时候判断数据获取判断

sp=AdjustUtils.getInstance().getSharedPreferences(getInstance(),SPName,SPModel);

//aBoolean：判断是否是一次打开应用

aBoolean = JudgeSpAB.getInstance().init(sp);

//installReferrer = "。。。。。。";
          
//判断是否进入

 if (!aBoolean)
 
   InstallReferrer.getInstance().init(getInstance(), installReferrer);
   
}

@Override

protected void onDestroy() {

    super.onDestroy();
    
    InstallReferrer.getInstance().PlCFEe();
    
}

@Override

public void gtoA() {

//跳转A的方法

    jfbFNi();
    
}

@Override

public void gtoB() {

//跳转B的方法

    XraFNz();
    
}

}
