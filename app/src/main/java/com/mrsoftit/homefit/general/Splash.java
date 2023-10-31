package com.mrsoftit.homefit.general;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.ads.MobileAds;
import com.mrsoftit.homefit.MainActivity;
import com.mrsoftit.homefit.R;
import com.mrsoftit.homefit.utils.GlobalFunction;
import com.mrsoftit.homefit.utils.SharedPreferenceManager;

public class Splash extends Activity {
    String TAG = getClass().getSimpleName();

    GlobalFunction globalFunction;
    SharedPreferenceManager sharedPreferenceManager;




    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.globalFunction = new GlobalFunction(this);
        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        setContentView(R.layout.splash);

        this.globalFunction.set_locale_language();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Splash.this.startActivity(new Intent(Splash.this.getApplicationContext(), MainActivity.class));
                Splash.this.finish();
            }
        }, (long)2000);
    }


}
