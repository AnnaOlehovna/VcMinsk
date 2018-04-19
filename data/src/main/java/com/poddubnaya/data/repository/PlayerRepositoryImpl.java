package com.poddubnaya.data.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.poddubnaya.data.database.AppDataBase;
import com.poddubnaya.data.database.PlayersDao;
import com.poddubnaya.data.database.databaseEntity.MinchankaPlayer;
import com.poddubnaya.data.entity.Player;
import com.poddubnaya.data.rest.RestService;
import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.domain.repository.PlayerRepository;

import java.util.ArrayList;

import com.poddubnaya.data.constants.Constants;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class PlayerRepositoryImpl implements PlayerRepository {

    private Context context;
    private RestService restService;
    private PlayersDao playersDao;


    public PlayerRepositoryImpl(RestService restService, Context context, AppDataBase appDataBase) {
        this.restService = restService;
        this.context = context;
        this.playersDao = appDataBase.getPlayersDao();
    }

    @Override
    public Flowable<List<PlayerDomain>> getPlayers(final String team) {

        Flowable<List<Player>> players;
        if (checkNetwork()) {
            players = restService.getPlayers(team)
                    .doAfterNext(new Consumer<List<Player>>() {
                        @Override
                        public void accept(List<Player> players) throws Exception {
                            switch (team) {
                                case Constants.MINCHANKA:
                                    List<MinchankaPlayer> list = new ArrayList<>();
                                    for (Player p : players) {
                                        list.add((MinchankaPlayer) p);
                                    }
                                    playersDao.insertMinchanka(list);
                                    break;

                            }
                        }
                    });
        } else {
            players = playersDao.getMinchankaPlayers()
                    .map(new Function<List<MinchankaPlayer>, List<Player>>() {
                        @Override
                        public List<Player> apply(List<MinchankaPlayer> minchankaPlayers) throws Exception {
                            List<Player> list = new ArrayList<>();
                            list.addAll(minchankaPlayers);
                            return list;
                        }
                    });
        }
        return players
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
