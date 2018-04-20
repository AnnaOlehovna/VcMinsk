package com.poddubnaya.vcminsk.presentation.screens.teams.recycler.staff;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.domain.entity.StaffDomain;
import com.poddubnaya.vcminsk.databinding.PlayerItemBinding;
import com.poddubnaya.vcminsk.databinding.StaffItemBinding;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseAdapter;
import com.poddubnaya.vcminsk.presentation.screens.teams.recycler.players.PlayerItemViewModel;
import com.poddubnaya.vcminsk.presentation.screens.teams.recycler.players.PlayerViewHolder;

public class StaffRecyclerAdapter extends BaseAdapter<StaffDomain,StaffItemViewModel>{

    @Override
    public StaffViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        StaffItemBinding binding = StaffItemBinding.inflate(inflater,parent,false);
        return new StaffViewHolder(binding,new StaffItemViewModel());
    }
}
