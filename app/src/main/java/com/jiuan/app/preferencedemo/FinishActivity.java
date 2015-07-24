package com.jiuan.app.preferencedemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by ZhangKong on 2015/7/24.
 */

public class FinishActivity extends ActionBarActivity {

    private static final String TAG = "FinishActivity";
    public void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_finish);

        log("onCreate");
        Button button = (Button)findViewById(R.id.back_main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button test_button = (Button)findViewById(R.id.finish_test);
        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(FinishActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onRestart(){
        super.onRestart();

        log("onRestart");


    }

    @Override
    protected void onResume(){
        super.onResume();
        log("onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        log("onSaveInstanceState");
    }
    @Override
    protected void onRestoreInstanceState(Bundle onSavedInstanceState){
        super.onRestoreInstanceState(onSavedInstanceState);
        log("onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        log("onConfigurationChanged");

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        log("onPostCreate");
    }

    @Override
    public void onPostResume(){
        super.onPostResume();
        log("onPostResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        log("onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        log("onDestroy");
    }

    private void log(String msg){
        Log.d(TAG, msg);
    }

}
