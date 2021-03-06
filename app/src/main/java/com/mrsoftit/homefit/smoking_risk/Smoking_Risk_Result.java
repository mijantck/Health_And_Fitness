package com.mrsoftit.homefit.smoking_risk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.mrsoftit.homefit.R;
import com.mrsoftit.homefit.utils.GlobalFunction;
import com.mrsoftit.homefit.utils.SharedPreferenceManager;
import com.mrsoftit.homefit.utils.TypefaceManager;


public class Smoking_Risk_Result extends Activity {
    String TAG = getClass().getSimpleName();

    Bundle extras;
    GlobalFunction globalFunction;
    ImageView iv_close;
    SharedPreferenceManager sharedPreferenceManager;
    String smoking_risk_msg;
    TextView tv_smoking_risk_result;
    TypefaceManager typefaceManager;


    public void attachBaseContext(Context context) {
        super.attachBaseContext(uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper.wrap(context));
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_smoking_risk);
        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        this.globalFunction = new GlobalFunction(this);
        this.typefaceManager = new TypefaceManager(getAssets(), this);
        this.globalFunction.sendAnalyticsData(this.TAG, this.TAG);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.tv_smoking_risk_result = (TextView) findViewById(R.id.tv_smoking_risk_result);

        this.tv_smoking_risk_result.setTypeface(this.typefaceManager.getLight());
        this.extras = getIntent().getExtras();
        this.smoking_risk_msg = this.extras.getString("smoking_risk_msg");
        this.tv_smoking_risk_result.setText(this.smoking_risk_msg);
        if (this.sharedPreferenceManager.get_Remove_Ad().booleanValue()) {

        } else {

        }
        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Smoking_Risk_Result.this.onBackPressed();
            }
        });
    }
}
