package com.poddubnaya.data.repository;

import com.poddubnaya.data.entity.Player;
import com.poddubnaya.data.rest.RestService;
import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.domain.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;


public class PlayerRepositoryImpl implements PlayerRepository {

    private RestService restService;

    public PlayerRepositoryImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Flowable<List<PlayerDomain>> getPlayers(String team) {
        return restService.getPlayers(team)
                .map(new Function<List<Player>, List<PlayerDomain>>() {
                    @Override
                    public List<PlayerDomain> apply(List<Player> players) throws Exception {
                        List<PlayerDomain> playerDomainList = new ArrayList<>();
                        for (Player player : players
                                ) {
                            playerDomainList.add(
                                    new PlayerDomain(player.getPlayerNumber(),
                                            player.getSurname(),
                                            player.getName(),
                                            player.getRole(),
                                            player.getYear(),
                                            player.getHeight(),
                                            player.getNationality()));

                        }
                        return playerDomainList;
                    }
                });
    }
}
