package com.mrsoftit.homefit.trademill;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
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


public class Trademill_Result extends Activity {
    String TAG = getClass().getSimpleName();
    Bundle extras;
    GlobalFunction globalFunction;
    ImageView iv_close;
    SharedPreferenceManager sharedPreferenceManager;
    Double trademill;
    TextView tv_trademill_result;
    TypefaceManager typefaceManager;


    public void attachBaseContext(Context context) {
        super.attachBaseContext(uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper.wrap(context));
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_trademill);
        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        this.globalFunction = new GlobalFunction(this);
        this.typefaceManager = new TypefaceManager(getAssets(), this);
        this.globalFunction.sendAnalyticsData(this.TAG, this.TAG);
        this.tv_trademill_result = (TextView) findViewById(R.id.tv_trademill_result);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);

        this.tv_trademill_result.setTypeface(this.typefaceManager.getLight());
        this.extras = getIntent().getExtras();
        this.trademill = Double.valueOf(this.extras.getDouble("trademill"));
        TextView textView = this.tv_trademill_result;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.Bruce_trade_mill));
        sb.append("%.2f");
        textView.setText(String.format(sb.toString(), new Object[]{this.trademill}));
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        if (this.sharedPreferenceManager.get_Remove_Ad().booleanValue()) {

        } else {

        }
        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Trademill_Result.this.onBackPressed();
            }
        });
    }


    public void onResume() {
        super.onResume();
        if (!this.sharedPreferenceManager.get_Remove_Ad().booleanValue()) {

        } else {

        }
    }
}
