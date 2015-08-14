package com.jiuan.app.preferencedemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{


    @Bind(R.id.config)
    Button configbutton;

    @Bind(R.id.content)
    TextView content;

    @Bind(R.id.database)
    Button database;

    @Bind(R.id.finish_button)
    Button button_finish;

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log("onCreate");

        ButterKnife.bind(this);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @OnClick({R.id.config,R.id.database,R.id.finish_button})
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.config:
                Intent intent = new  Intent(MainActivity.this,PreferenceActivity.class);
                startActivity(intent);
                log("已经进入了设置界面！！！！！");
                break;
            case R.id.database:
                Intent databaseintent = new Intent(MainActivity.this,DataBaseActivity.class);
                startActivity(databaseintent);
                break;
            case R.id.finish_button:
                Intent finish_intent = new Intent(MainActivity.this,FinishActivity.class);
                startActivity(finish_intent);
                break;



        }
        log("进行完了switch选择进入新的界面！！！！！");
       try{
           Thread.sleep(3000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }

    }

    private String replacechar(String str,char dst,char src){
        String replacestring = str;
        int length = replacestring.length();
        for(int i = 0 ; i < length ; i++){
            char s = replacestring.charAt(i);
            if(s == dst){
                s = src;

            }
        }
        return replacestring;
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
        for(int i = 0; i < 100; i++){
            log("onPause:" + i);
        }
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
    public void onStart(){
        super.onStart();
        log("onStart");
    }

    private void log(String msg){
        Log.d(TAG,msg);
    }
}
