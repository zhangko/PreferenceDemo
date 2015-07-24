package com.jiuan.app.preferencedemo;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by ZhangKong on 2015/7/8.
 */
public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
        findPreference("logout").setOnPreferenceClickListener(this);
        log("onCreate");
    }


    @Override
    public boolean onPreferenceClick(Preference preference) {
        Log.d("onPreferenceClick"," " + preference.getKey());
        if(preference.getKey().equals("logout")){
            Toast.makeText(getActivity(),"点击了注销按钮！",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        log("onAttach");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        log("onCreateView");
        return super.onCreateView(inflater,container,savedInstanceState);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        log("onActivityCreated");

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        log("onViewCreated");

    }

    @Override
    public void onResume(){
        super.onResume();
        log("onResume");

    }

    @Override
    public void onStart(){
        super.onStart();
        log("onStart");
    }

    @Override
    public void onStop(){
        super.onStop();
        log("onStop");
    }

    @Override
    public void onPause(){
        super.onPause();
        log("onPause");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        log("onDestroy");
    }

    public void onDestroyView(){
        super.onDestroyView();
        log("onDestroyView");
    }

    @Override
    public void onDetach(){
        super.onDetach();
        log("onDetach");
    }

    private void log(String msg){
        Log.d("Fragment Lifecycle",msg);
    }
}
