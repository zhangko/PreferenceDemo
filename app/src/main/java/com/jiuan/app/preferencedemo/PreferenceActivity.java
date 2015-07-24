package com.jiuan.app.preferencedemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Created by ZhangKong on 2015/7/7.
 */
public class PreferenceActivity extends ActionBarActivity {

    private final static String TAG = "PreferenceActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        log("onCreate");
        setContentView(R.layout.activity_main_preference);
        getFragmentManager().beginTransaction().replace(R.id.content, new SettingsFragment()).commit();
    }

    @Override
    protected void onStart(){
        super.onStart();

        log("onStart");
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(this,"点击了back键",Toast.LENGTH_SHORT);
        log("点击了back键");
        return super.onKeyDown(keyCode,event);
    }

    private void log(String msg){
        Log.d(TAG,msg);
    }


}
