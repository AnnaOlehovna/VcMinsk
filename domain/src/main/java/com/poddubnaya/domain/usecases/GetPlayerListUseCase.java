package com.poddubnaya.domain.usecases;

import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.domain.executor.PostExecutionThread;
import com.poddubnaya.domain.repository.PlayerRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetPlayerListUseCase extends BaseUseCase{

    private PlayerRepository playerRepository;

    @Inject
    public GetPlayerListUseCase(PostExecutionThread postExecutionThread, PlayerRepository playerRepository) {
        super(postExecutionThread);
        this.playerRepository = playerRepository;
    }


  public Flowable<List<PlayerDomain>> getPlayers(String team){
        return playerRepository.getPlayers(team)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
