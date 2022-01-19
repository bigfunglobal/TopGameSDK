# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.adjust.sdk.**{ *; }
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
    com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId();
    boolean isLimitAdTrackingEnabled();
}
-keep public class com.android.installreferrer.** { *; }

#<基础>
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.support.multidex.MultiDexApplication
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
-keep class android.support.** {*;}


-keep class com.topgame.sdk.**{ *; }

-keepclassmembers class com.topgame.sdk.BigFunSDK{
public static void init(*);
public static void getSwitch(*);
public static void PlCFEe(*);
}
-keepclassmembers class com.topgame.sdk.TopGameListener{
 void onSwitchListener(boolean val);
 }

##指定代码的压缩级别
-optimizationpasses 5
#
#包名不混合大小写
-dontusemixedcaseclassnames
#
##不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
#
# #优化 不优化输入的类文件
-dontoptimize
#
# #预校验
-dontpreverify
#
# #混淆时是否记录日志
-verbose
#
##忽略警告
##-ignorewarning
#
##保护注解
-keepattributes *Annotation*

