package com.poddubnaya.vcminsk.app;


import android.app.Application;

import com.poddubnaya.vcminsk.injection.AppComponent;
import com.poddubnaya.vcminsk.injection.AppModule;
import com.poddubnaya.vcminsk.injection.DaggerAppComponent;

public class App extends Application{
    private static AppComponent appComponent;
     public static AppComponent getAppComponent(){
         return appComponent;
     }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
