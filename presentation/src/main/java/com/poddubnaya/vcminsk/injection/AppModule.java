package com.poddubnaya.vcminsk.injection;


import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.poddubnaya.data.database.AppDataBase;
import com.poddubnaya.data.repository.NewsRepositoryImpl;
import com.poddubnaya.data.repository.PlayerRepositoryImpl;
import com.poddubnaya.data.repository.StaffRepositoryImpl;
import com.poddubnaya.data.rest.RestApi;
import com.poddubnaya.data.rest.RestService;
import com.poddubnaya.domain.executor.PostExecutionThread;
import com.poddubnaya.domain.repository.NewsRepository;
import com.poddubnaya.domain.repository.PlayerRepository;
import com.poddubnaya.domain.repository.StaffRepository;
import com.poddubnaya.vcminsk.domain.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {


    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUIThread() {
        return new UIThread();
    }

    @Provides
    @Singleton
    public PlayerRepository getPlayerRepository(RestService restService, Context context,AppDataBase appDataBase) {
        return new PlayerRepositoryImpl(restService,context,appDataBase);

    }

    @Provides
    @Singleton
    public StaffRepository getStaffRepository(RestService restService,Context context, AppDataBase appDataBase) {
        return new StaffRepositoryImpl(restService,context,appDataBase);

    }

    @Provides
    @Singleton
    public NewsRepository getNewsRepository( RestService restService, Context context, AppDataBase appDataBase) {
        return new NewsRepositoryImpl(restService,context,appDataBase);

    }


    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }


    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.backendless.com/011377EA-79CF-5078-FFEC-750AF685BE00/FD5C4876-8678-6191-FF14-124DA1260B00/")
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient getOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(httpLoggingInterceptor);

        return builder.build();
    }


    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder().create();
    }


    @Provides
    @Singleton
    public AppDataBase getAppDatabase(Context context){
        AppDataBase appDatabase = Room.databaseBuilder(context,
                AppDataBase.class,
                "database")
                .fallbackToDestructiveMigration()
                .build();
        return appDatabase;
    }

}
