package com.poddubnaya.data.constants;


import android.content.Context;
import android.content.SharedPreferences;

import com.poddubnaya.data.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static android.content.Context.MODE_PRIVATE;

public class MySharedPref {

    private Context context;

   @Inject
    public MySharedPref(Context context) {
        this.context = context;
    }

    public String[] getSharedPref(){
        SharedPreferences sharedPreferences = context.getSharedPreferences(
                context.getString(R.string.My_shared_pref),MODE_PRIVATE);
        boolean minchanka = sharedPreferences.getBoolean(Constants.MINCHANKA, false);
        boolean stroitel = sharedPreferences.getBoolean(Constants.STROITEL, true);
        List<String> teams = new ArrayList<>();
        if (minchanka && stroitel) {
            teams.add(Constants.MINCHANKA);
            teams.add(Constants.STROITEL);
        } else if (minchanka) {
            teams.add(Constants.MINCHANKA);
        } else if (stroitel) {
            teams.add(Constants.STROITEL);
        }
        String[] tmp = new String[teams.size()];
        tmp = teams.toArray(tmp);
        return tmp;
    }

    public void saveSharedPref(boolean minchanka, boolean stroitel){
        SharedPreferences sharedPreferences =  context.getSharedPreferences(
                context.getString(R.string.My_shared_pref),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(Constants.MINCHANKA, minchanka);
        editor.putBoolean(Constants.STROITEL,stroitel);
        editor.apply();
    }
}
