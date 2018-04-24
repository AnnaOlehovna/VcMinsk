package com.poddubnaya.domain.repository;


import com.poddubnaya.domain.entity.NewsDomain;

import java.util.List;

import io.reactivex.Flowable;

public interface NewsRepository {

    Flowable<List<NewsDomain>> getNews(String[] team);
    Flowable<NewsDomain> getNewsById(String id);
}
