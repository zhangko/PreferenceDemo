package com.jiuan.app.preferencedemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiuan.oa.android.library.http.login.OALoginResponse;

import java.util.ArrayList;
import java.util.List;

import contacthttp.ContactClient;
import contacthttp.ContactResponseHandler;
import contacthttp.EmployResponse;
import de.greenrobot.dao.query.QueryBuilder;
import greendao.DaoMaster;
import greendao.DaoSession;
import greendao.Staff;
import greendao.StaffDao;

/**
 * Created by ZhangKong on 2015/7/10.
 */
public class GreenDaoActivity extends ActionBarActivity {


    private SQLiteDatabase db;

    private DaoSession daoSession;

    private StaffDao staffDao;

    private ListView listView;
    @Override
    protected void onCreate(Bundle onsavedinstance){
        super.onCreate(onsavedinstance);
        setContentView(R.layout.layout_greendao_linear);
        OALoginResponse oaLoginResponse = getIntent().getParcelableExtra("oaLoginResponse");

        listView = (ListView)findViewById(R.id.name_list);


        Button button = (Button)findViewById(R.id.query);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryBuilder qb = staffDao.queryBuilder().where(StaffDao.Properties.Gender.eq(1));
                List<Staff> list = qb.list();
                List<String> name_list = new ArrayList<String>();

                Log.d("List<Staff>","  " + list.size());
                for(int i = 0; i < list.size(); i++){
                    name_list.add(list.get(i).getName());
                    Log.d("   ","  " + list.get(i).getName());
                }
                ArrayAdapter adapter = new ArrayAdapter(GreenDaoActivity.this,android.R.layout.simple_list_item_1,name_list);
                listView.setAdapter(adapter);

            }
        });

        Log.d("accessKey", oaLoginResponse.getAccessKey());
        DaoMaster.DevOpenHelper myhelper = new DaoMaster.DevOpenHelper(this,"adress.db",null);
        db = myhelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        staffDao = daoSession.getStaffDao();
        ContactClient.requestEmployee(this,oaLoginResponse.getAccount(),oaLoginResponse.getUserID(),oaLoginResponse.getAccessKey(),new ContactResponseHandler(this){

            @Override
           public void onOASuccess(String value){
                Log.d("onOASuccess"," " + value);
                Gson gson = new Gson();
                List<EmployResponse> EmployList = gson.fromJson(value, new TypeToken<List<EmployResponse>>() {
                }.getType());
                Log.d("员工人数"," " + EmployList.size());
                long number = EmployList.size();
                List<Staff> listStaff = new ArrayList<Staff>();

                for( int i = 0; i < number; i++){
                    EmployResponse  employResponse = EmployList.get(i);
                    Long l = new Long((long)i);
                    Staff staff = new Staff(l);
                    staff.setName(employResponse.getName());
                    staff.setCode(employResponse.getCode());
                    staff.setDepartmentCode(employResponse.getDepartmentcode());
                    staff.setDepartmentID(employResponse.getDepartmentid());
                    staff.setEmail(employResponse.getEmail());
                    staff.setMobile(employResponse.getMobile());
                    staff.setTelephone(employResponse.getTelephone());
                    staff.setIsMainDepartment(employResponse.getIsmaindepartment());
                    staff.setGender(employResponse.getSex());
                    listStaff.add(staff);

                }

                long begintime = System.currentTimeMillis();
                staffDao.insertInTx(listStaff);
                long endtime = System.currentTimeMillis();
                Log.d("存储时间为"," " + (begintime - endtime) + "毫秒");
                Intent intent = new Intent(GreenDaoActivity.this,TestActivity.class);
                startActivity(intent);
            }

        });

    }
}
