package com.miraz.tvmaze.model.database;
import android.content.Context;
import android.content.SharedPreferences;

import com.miraz.tvmaze.R;

public class SharedPrefConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefConfig(Context context){
        this.context=context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference),
                Context.MODE_PRIVATE);
    }
    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference),status);
        editor.commit();
    }
    public boolean readLoginStatus(){
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference),
                false);
        return status;
    }
}
