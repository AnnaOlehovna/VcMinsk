package com.poddubnaya.vcminsk.presentation.screens.teams.recycler.players;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.vcminsk.databinding.PlayerItemBinding;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseAdapter;

public class PlayerRecyclerAdapter  extends BaseAdapter<PlayerDomain,PlayerItemViewModel>{

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PlayerItemBinding binding = PlayerItemBinding.inflate(inflater,parent,false);
        return new PlayerViewHolder(binding,new PlayerItemViewModel());
    }
}
