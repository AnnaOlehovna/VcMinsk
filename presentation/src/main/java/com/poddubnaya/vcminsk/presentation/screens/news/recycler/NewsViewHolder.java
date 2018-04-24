package com.poddubnaya.vcminsk.presentation.screens.news.recycler;


import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.vcminsk.databinding.NewsItemBinding;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseItemViewHolder;

public class NewsViewHolder extends BaseItemViewHolder<NewsDomain,NewsItemViewModel,NewsItemBinding> {

    public NewsViewHolder(NewsItemBinding binding, NewsItemViewModel viewModel) {
        super(binding, viewModel);
    }

}
