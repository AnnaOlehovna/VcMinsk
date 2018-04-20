package com.poddubnaya.vcminsk.presentation.screens.teams.fragment;


import android.arch.lifecycle.ViewModel;

import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.domain.entity.StaffDomain;
import com.poddubnaya.domain.usecases.GetPlayerListUseCase;
import com.poddubnaya.domain.usecases.GetStaffListUseCase;
import com.poddubnaya.vcminsk.app.App;
import com.poddubnaya.vcminsk.presentation.screens.teams.recycler.players.PlayerRecyclerAdapter;
import com.poddubnaya.vcminsk.presentation.screens.teams.recycler.staff.StaffRecyclerAdapter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class TeamViewModel extends ViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    private String teamName;

    protected PlayerRecyclerAdapter playerAdapter = new PlayerRecyclerAdapter();

    protected StaffRecyclerAdapter staffAdapter = new StaffRecyclerAdapter();

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Inject
    public GetPlayerListUseCase getPlayerListUseCase;

    @Inject
    public GetStaffListUseCase getStaffListUseCase;

    public TeamViewModel() {
        App.getAppComponent().inject(this);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null)
            compositeDisposable.dispose();
    }

    public void onResume() {

        getPlayerListUseCase
                .getPlayers(teamName)
                .subscribe(new Consumer<List<PlayerDomain>>() {
                    @Override
                    public void accept(List<PlayerDomain> playerDomains) throws Exception {
                        playerAdapter.setItemList(playerDomains);
                    }
                });

        getStaffListUseCase
                .getStaff(teamName)
                .subscribe(new Consumer<List<StaffDomain>>() {
                    @Override
                    public void accept(List<StaffDomain> staffDomains) throws Exception {
                        staffAdapter.setItemList(staffDomains);
                    }
                });




    }


}
