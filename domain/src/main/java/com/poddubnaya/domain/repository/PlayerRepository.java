package com.poddubnaya.domain.repository;


import com.poddubnaya.domain.entity.PlayerDomain;

import java.util.List;

import io.reactivex.Flowable;

public interface PlayerRepository {

    Flowable<List<PlayerDomain>> getPlayers(String team);


}
