package com.jiuan.app.preferencedemo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import greendao.DaoMaster;
import greendao.DaoSession;
import greendao.Staff;
import greendao.StaffDao;

/**
 * Created by ZhangKong on 2015/7/13.
 */
public class TestActivity extends ActionBarActivity {
    private SQLiteDatabase db;

    private DaoSession daoSession;

    private StaffDao staffDao;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_greendao_linear);

        DaoMaster.DevOpenHelper myhelper = new DaoMaster.DevOpenHelper(this,"adress.db",null);
        db = myhelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        staffDao = daoSession.getStaffDao();

        listView = (ListView)findViewById(R.id.name_list);


        Button button = (Button)findViewById(R.id.query);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryBuilder qb = staffDao.queryBuilder().where(StaffDao.Properties.Gender.eq(1));
                List<Staff> list = qb.list();
                List<String> name_list = new ArrayList<String>();

                Log.d("List<Staff>", "  " + list.size());
                for(int i = 0; i < list.size(); i++){
                    name_list.add(list.get(i).getName());
                    Log.d("   ","  " + list.get(i).getName());
                }
                ArrayAdapter adapter = new ArrayAdapter(TestActivity.this,android.R.layout.simple_list_item_1,name_list);
                listView.setAdapter(adapter);

            }
        });


    }
}
