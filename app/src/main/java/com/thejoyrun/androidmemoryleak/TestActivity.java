package com.thejoyrun.androidmemoryleak;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//public class TestActivity extends AppCompatActivity {
//    private TextView textView;
//    private int timer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
//        textView = (TextView) findViewById(R.id.text);
//        final Handler handler = new Handler();
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                textView.setText(String.valueOf(timer++));
//                handler.postDelayed(this, 1000);
//            }
//        });
//    }
//}
// TODO 修正后的代码
public class TestActivity extends AppCompatActivity {
    private TextView textView;
    private int timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.text);
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(String.valueOf(timer++));
                if (handler != null) {
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }
    private Handler handler = new Handler();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }
}