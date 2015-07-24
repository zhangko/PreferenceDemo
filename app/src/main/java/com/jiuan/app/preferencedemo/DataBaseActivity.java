package com.jiuan.app.preferencedemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.jiuan.oa.android.library.http.login.OALoginClient;
import com.jiuan.oa.android.library.http.login.OALoginHttpResponseHandler;
import com.jiuan.oa.android.library.http.login.OALoginResponse;
import com.jiuan.oa.android.library.util.MD5Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import contacthttp.ContactClient;
import contacthttp.ContactResponseHandler;
import greendao.DaoMaster;
import greendao.DaoSession;
import greendao.StaffDao;

/**
 * Created by ZhangKong on 2015/7/10.
 */
public class DataBaseActivity extends ActionBarActivity implements View.OnClickListener {
    private SQLiteDatabase db;

    private DaoSession daoSession;

    private StaffDao staffDao;


    @Bind(R.id.greendao)
    Button  greendao;
    protected void onCreate(Bundle savedinstance){
        super.onCreate(savedinstance);
        setContentView(R.layout.layout_database_linear);
        ButterKnife.bind(this);
        DaoMaster.DevOpenHelper myhelper = new DaoMaster.DevOpenHelper(this,"adress.db",null);
        db = myhelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        staffDao = daoSession.getStaffDao();



    }
    @OnClick(R.id.greendao)
    @Override
    public void onClick(View v) {

        String username = "12915";
        String password =   MD5Util.get32MD5Capital("000000", MD5Util.UTF_16LE);
        OALoginClient.requestLogin(this,username,password,new OALoginHttpResponseHandler(){

            @Override
        public void onOASuccess(String value){
                Log.d("onOASuccess", value);
                Gson gson = new Gson();
                OALoginResponse oaLoginResponse = gson.fromJson(value,OALoginResponse.class);
                String accessKey = oaLoginResponse.getAccessKey();
                Log.d("accessKey"," " + accessKey);
                Intent intent = new Intent(DataBaseActivity.this,GreenDaoActivity.class);

                intent.putExtra("oaLoginResponse",oaLoginResponse);
                startActivity(intent);
            }



        },0);




    }
}
