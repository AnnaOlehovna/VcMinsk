package com.poddubnaya.vcminsk.injection;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.poddubnaya.data.repository.PlayerRepositoryImpl;
import com.poddubnaya.data.repository.StaffRepositoryImpl;
import com.poddubnaya.data.rest.RestApi;
import com.poddubnaya.data.rest.RestService;
import com.poddubnaya.domain.executor.PostExecutionThread;
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
    public PlayerRepository getPlayerRepository(RestService restService) {
        return new PlayerRepositoryImpl(restService);

    }

    @Provides
    @Singleton
    public StaffRepository getStaffRepository(RestService restService) {
        return new StaffRepositoryImpl(restService);

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
                .baseUrl("https://api.backendless.com/211E03F7-45E3-C81A-FF0D-C31C3EB07C00/9D4E87D9-BC56-9CDA-FF2F-16247CFF6300/")
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

}
