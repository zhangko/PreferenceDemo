package com.jiuan.app.preferencedemo;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    @OnClick({R.id.config,R.id.database})
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.config:
                Intent intent = new  Intent(MainActivity.this,PreferenceActivity.class);
                startActivity(intent);
                break;
            case R.id.database:
                Intent databaseintent = new Intent(MainActivity.this,DataBaseActivity.class);
                startActivity(databaseintent);
                break;
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
}
