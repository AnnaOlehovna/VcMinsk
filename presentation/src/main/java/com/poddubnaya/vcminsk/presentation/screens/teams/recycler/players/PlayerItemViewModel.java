package com.poddubnaya.vcminsk.presentation.screens.teams.recycler.players;

import android.databinding.ObservableField;

import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseItemViewModel;

public class PlayerItemViewModel extends BaseItemViewModel<PlayerDomain> {

    public ObservableField<String> number = new ObservableField<>();
    public ObservableField<String> surname = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> role = new ObservableField<>();
    public ObservableField<String> year = new ObservableField<>();
    public ObservableField<String> height = new ObservableField<>();
    public ObservableField<String> nationality = new ObservableField<>();


    @Override
    public void setItem(PlayerDomain playerDomain, int position) {
        number.set(String.valueOf(playerDomain.getPlayerNumber()));
        surname.set(playerDomain.getSurname());
        name.set(playerDomain.getName());
        role.set(playerDomain.getRole());
        year.set(String.valueOf(playerDomain.getYear()));
        height.set(String.valueOf(playerDomain.getHeight()));
        nationality.set(playerDomain.getNationality());
    }
}
