package com.poddubnaya.vcminsk.presentation.screens.teams.recycler.staff;
import com.poddubnaya.domain.entity.StaffDomain;
import com.poddubnaya.vcminsk.databinding.StaffItemBinding;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseItemViewHolder;


public class StaffViewHolder extends BaseItemViewHolder<StaffDomain,StaffItemViewModel,StaffItemBinding> {

    public StaffViewHolder(StaffItemBinding binding, StaffItemViewModel viewModel) {
        super(binding, viewModel);
    }
}
