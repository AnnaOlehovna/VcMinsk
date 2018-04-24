package com.poddubnaya.data.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.poddubnaya.data.database.AppDataBase;
import com.poddubnaya.data.database.NewsDao;
import com.poddubnaya.data.database.StaffDao;
import com.poddubnaya.data.entity.News;
import com.poddubnaya.data.rest.RestService;
import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.domain.repository.NewsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class NewsRepositoryImpl implements NewsRepository {


    private Context context;
    private RestService restService;
    private NewsDao newsDao;

    public NewsRepositoryImpl(RestService restService, Context context, AppDataBase appDataBase) {
        this.context = context;
        this.restService = restService;
        this.newsDao = appDataBase.getNewsDao();
    }

    @Override
    public Flowable<List<NewsDomain>> getNews(String[] team) {
        Flowable<List<News>> newsList;
        if (checkNetwork()) {
            newsList = restService.getNews(team)
                    .doOnNext(new Consumer<List<News>>() {
                        @Override
                        public void accept(List<News> news) throws Exception {
                            newsDao.deleteNews();
                            newsDao.insertNews(news);
                        }
                    });

        } else {
            newsList = newsDao.getByTeams(team);
        }
        return newsList.map(new Function<List<News>, List<NewsDomain>>() {
            @Override
            public List<NewsDomain> apply(List<News> news) throws Exception {
                List<NewsDomain> newsDomainList = new ArrayList<>();
                for (News n : news) {
                    newsDomainList.add(new NewsDomain(
                            n.getCreated(),
                            n.getText(),
                            n.getTeam(),
                            n.getTitle(),
                            n.getObjectId()
                    ));
                }
                Collections.sort(newsDomainList);
                return newsDomainList;
            }
        });
    }

    @Override
    public Flowable<NewsDomain> getNewsById(String id) {
        return newsDao.getById(id).take(1)
                .map(new Function<List<News>, News>() {
                    @Override
                    public News apply(List<News> news) throws Exception {
                        return news.get(0);
                    }
                })
                .map(new Function<News, NewsDomain>() {
                    @Override
                    public NewsDomain apply(News news) throws Exception {
                        return new NewsDomain(
                                news.getCreated(),
                                news.getText(),
                                news.getTeam(),
                                news.getTitle(),
                                news.getObjectId()
                        );
                    }
                });
    }

    private boolean checkNetwork() {
        boolean isConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                isConnected = true;
            }
        }
        return isConnected;
    }
}
