package com.talking.adjustsdk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
;import com.talking.bigfunglobal.interfa.GetIntoNoodlesA;
import com.talking.bigfunglobal.interfa.GetIntoNoodlesB;
import com.talking.bigfunglobal.utils.AdjustUtils;
import com.talking.bigfunglobal.utils.InstallReferrer;
import com.talking.bigfunglobal.utils.JudgeSpAB;


public class MainActivity extends AppCompatActivity implements GetIntoNoodlesA, GetIntoNoodlesB {


    private static MainActivity tnnpvanb;

    public static MainActivity getInstance() {
        return tnnpvanb;
    }

    static SharedPreferences sp;
    static String _FINgame = "";
    static boolean aBoolean;
    private static String installReferrer="";
    public static String uqVyqg() {
        return "Spider3APatti";
    }
    public static String SPName() {
        return "profile";
    }
    public static int SPModel() {
        return Context.MODE_PRIVATE;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JudgeSpAB.getInstance().setCallBack(this, this);
        tnnpvanb = this;
        //第二次进入时候判断数据获取判断
        sp = AdjustUtils.getInstance().getSharedPreferences(getInstance(), SPName(), SPModel());

        aBoolean = JudgeSpAB.getInstance().init(sp);
//        installReferrer = "utm_source=(not%20set)&utm_medium=(not%20set)";
//                    installReferrer = "gclid=CjwKCAiAh_GNBhAHEiwAjOh3ZPdyYev5W2u0qaaLUIZdtHyEqQE_FffRJKkYM-E7xJvFVo-aGsCS7BoC_0cQAvD_BwE";
//                    installReferrer = "pcampaignid=inline|youtubeads|9416164";
//                    installReferrer = "utm_content=%7B%22source%22%3A%7B%22data%22%3A%2200d6e5fe5d662f5e9306d51c19761418d466185fe4d661a1d98a43ad974e8d7e2f97e1e71946a3d1b0b08237b1681f9a275ee18c3b062696d51a021304d4ff49c1f35c1c2527a30dbbcdb0be001f3419a1078ab23d801a2cce0b7c673746c185f07be35529be4fa";

        if (!aBoolean)
            InstallReferrer.getInstance().init(sp,10000,getInstance(), installReferrer);

    }


    //进入A面
    public static void jfbFNi() {
        if (_FINgame.equals("ma")) {
            return;
        }
        _FINgame = "ma";
        Intent intent = new Intent(MainActivity.getInstance().getApplicationContext(), StartActivity.class);
        sp =  AdjustUtils.getInstance().getSharedPreferences(getInstance(), SPName(), SPModel());
        Log.d("wetw", "jfbFNi: " + sp.getString("wbAdr", ""));
        intent.putExtra("url", sp.getString("wbAdr", ""));
        MainActivity.getInstance().startActivity(intent);
        MainActivity.getInstance().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        MainActivity.getInstance().finish();
    }

    //进入B面
    public static void XraFNz() {
        _FINgame = "mbr";
        sp =  AdjustUtils.getInstance().getSharedPreferences(getInstance(), SPName(), SPModel());
        long hars = 2000l;
        Log.d("wae4gte", "mnsie: " + hars);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("wae4gte", "mnsie2: ");
                Intent intent = new Intent(MainActivity.getInstance().getApplicationContext(), HomeActivity.class);
                MainActivity.getInstance().startActivity(intent);
                MainActivity.getInstance().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                MainActivity.getInstance().finish();
            }
        }, hars);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        InstallReferrer.getInstance().PlCFEe();
    }

    @Override
    public void gtoA() {
        jfbFNi();
    }

    @Override
    public void gtoB() {
        XraFNz();
    }
}