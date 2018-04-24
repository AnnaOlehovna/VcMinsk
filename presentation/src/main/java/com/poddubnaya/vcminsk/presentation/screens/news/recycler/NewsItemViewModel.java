package com.poddubnaya.vcminsk.presentation.screens.news.recycler;

import android.content.Context;
import android.databinding.ObservableField;

import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.domain.entity.NewsDomain;
import com.poddubnaya.vcminsk.R;
import com.poddubnaya.vcminsk.presentation.base.recyclerView.BaseItemViewModel;

import javax.inject.Inject;

public class NewsItemViewModel extends BaseItemViewModel<NewsDomain> {


    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> team = new ObservableField<>();

    @Override
    public void setItem(NewsDomain newsDomain, int position) {
        if(newsDomain.getTeam().equals(Constants.MINCHANKA)){
            team.set("Минчанка");
        }else
            team.set("Строитель");

        title.set(newsDomain.getTitle());
    }
}
