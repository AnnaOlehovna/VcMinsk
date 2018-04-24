package com.poddubnaya.domain.usecases;


import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.domain.executor.PostExecutionThread;
import com.poddubnaya.domain.repository.NewsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetNewsUseCase extends BaseUseCase{

    private NewsRepository newsRepository;

    @Inject
    public GetNewsUseCase(PostExecutionThread postExecutionThread, NewsRepository newsRepository) {
        super(postExecutionThread);
        this.newsRepository = newsRepository;
    }

    public Flowable<List<NewsDomain>> getNews(String[] team){
        return newsRepository.getNews(team)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}
