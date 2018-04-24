package com.poddubnaya.vcminsk.presentation.screens.news.recycler;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.vcminsk.databinding.NewsItemBinding;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseAdapter;

import io.reactivex.subjects.PublishSubject;

public class NewsRecyclerAdapter extends BaseAdapter<NewsDomain,NewsItemViewModel>{

    private PublishSubject<NewsDomain> clickSubject = PublishSubject.create();

    public PublishSubject<NewsDomain> observeClick(){
        return clickSubject;
    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(inflater,parent,false);
        final NewsViewHolder viewHolder = new NewsViewHolder(binding,new NewsItemViewModel());
       viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position = viewHolder.getAdapterPosition();
               clickSubject.onNext(getItemList().get(position));

           }
       });
        return viewHolder;
    }
}
