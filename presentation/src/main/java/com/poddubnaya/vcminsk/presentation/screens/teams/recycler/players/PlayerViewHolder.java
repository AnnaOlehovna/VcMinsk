package com.poddubnaya.vcminsk.presentation.screens.teams.recycler.players;


import com.poddubnaya.domain.entity.PlayerDomain;
import com.poddubnaya.vcminsk.databinding.PlayerItemBinding;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseItemViewHolder;

public class PlayerViewHolder extends BaseItemViewHolder<PlayerDomain,PlayerItemViewModel,PlayerItemBinding> {

    public PlayerViewHolder(PlayerItemBinding binding, PlayerItemViewModel viewModel) {
        super(binding, viewModel);
    }
}
