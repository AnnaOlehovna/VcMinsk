package com.poddubnaya.domain.usecases;


import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.domain.executor.PostExecutionThread;
import com.poddubnaya.domain.repository.NewsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetNewsByIdUseCase extends BaseUseCase{

    private NewsRepository newsRepository;

    @Inject
    public GetNewsByIdUseCase(PostExecutionThread postExecutionThread, NewsRepository newsRepository) {
        super(postExecutionThread);
        this.newsRepository = newsRepository;
    }

    public Flowable<NewsDomain> getNewsById(String id){
        return newsRepository.getNewsById(id)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }

}
