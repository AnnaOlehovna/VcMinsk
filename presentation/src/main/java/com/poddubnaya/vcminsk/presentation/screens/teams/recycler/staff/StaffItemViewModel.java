package com.poddubnaya.vcminsk.presentation.screens.teams.recycler.staff;

import android.databinding.ObservableField;

import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.domain.entity.StaffDomain;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseItemViewModel;

public class StaffItemViewModel extends BaseItemViewModel<StaffDomain> {

    public ObservableField<String> middleName = new ObservableField<>();
    public ObservableField<String> surname = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> role = new ObservableField<>();




    @Override
    public void setItem(StaffDomain staffDomain, int position) {
        middleName.set(staffDomain.getMiddleName());
        surname.set(staffDomain.getSurname());
        name.set(staffDomain.getName());
        role.set(staffDomain.getRole());

    }
}
