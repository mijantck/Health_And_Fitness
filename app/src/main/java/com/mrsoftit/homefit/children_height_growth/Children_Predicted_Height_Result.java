package com.mrsoftit.homefit.children_height_growth;

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


public class Children_Predicted_Height_Result extends Activity {
    String TAG = getClass().getSimpleName();

    Bundle extras;
    GlobalFunction globalFunction;
    ImageView iv_close;
    Float predicted_height;
    SharedPreferenceManager sharedPreferenceManager;
    TextView tv_ans_child_predicted_Height;
    TypefaceManager typefaceManager;


    public void attachBaseContext(Context context) {
        super.attachBaseContext(uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper.wrap(context));
    }


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.popup_children_height_prediction);
        this.sharedPreferenceManager = new SharedPreferenceManager(this);
        this.globalFunction = new GlobalFunction(this);
        this.typefaceManager = new TypefaceManager(getAssets(), this);
        this.globalFunction.sendAnalyticsData(this.TAG, this.TAG);
        this.tv_ans_child_predicted_Height = (TextView) findViewById(R.id.tv_ans_child_predicted_Height);
        this.iv_close = (ImageView) findViewById(R.id.iv_close);
        this.tv_ans_child_predicted_Height.setTypeface(this.typefaceManager.getLight());

        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
        }
        if (this.sharedPreferenceManager.get_Remove_Ad().booleanValue()) {

        } else {
        }
        this.extras = getIntent().getExtras();
        this.predicted_height = Float.valueOf(this.extras.getFloat("child_predicted_height"));
        TextView textView = this.tv_ans_child_predicted_Height;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.Your_Childs_Predicted_Height));
        sb.append(" ");
        sb.append(String.format("%.02f", new Object[]{this.predicted_height}));
        sb.append(" ");
        sb.append(getString(R.string.Feet_At_21_Years));
        textView.setText(sb.toString());
        this.iv_close.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Children_Predicted_Height_Result.this.onBackPressed();
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
