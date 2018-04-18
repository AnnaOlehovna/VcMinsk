package com.poddubnaya.vcminsk.presentation.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

public abstract class BaseAdapter<Model,
        ItemViewModel extends BaseItemViewModel<Model>>
        extends RecyclerView.Adapter<BaseItemViewHolder<Model,ItemViewModel,?>>{

    private List<Model> itemList = new ArrayList<>();




    @Override
    public void onViewAttachedToWindow(BaseItemViewHolder<Model, ItemViewModel, ?> holder) {
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(BaseItemViewHolder<Model, ItemViewModel, ?> holder) {
        super.onViewDetachedFromWindow(holder);

    }

    public void setItemList(List<Model> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }



    @Override
    public void onBindViewHolder(BaseItemViewHolder<Model, ItemViewModel, ?> holder, int position) {
        Model item = itemList.get(position);
        holder.bindTo(item,position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //на случай если надо передать и модель и позицию в списке
    public static class ItemEntity<Model>{

        public Model model;
        public int position;
        public ItemEntity(Model model) {
            this.model = model;
        }

    }
}
