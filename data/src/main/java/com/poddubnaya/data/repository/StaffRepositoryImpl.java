package com.poddubnaya.data.repository;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.poddubnaya.data.constants.Constants;
import com.poddubnaya.data.database.AppDataBase;
import com.poddubnaya.data.database.StaffDao;
import com.poddubnaya.data.database.databaseEntity.MinchankaPlayer;
import com.poddubnaya.data.database.databaseEntity.MinchankaStaff;
import com.poddubnaya.data.entity.Player;
import com.poddubnaya.data.entity.Staff;
import com.poddubnaya.data.rest.RestService;
import com.poddubnaya.domain.entity.StaffDomain;
import com.poddubnaya.domain.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class StaffRepositoryImpl implements StaffRepository {


    private Context context;
    private RestService restService;
    private StaffDao staffDao;

    public StaffRepositoryImpl(RestService restService,Context context, AppDataBase appDataBase) {
        this.restService = restService;
        this.context = context;
        this.staffDao = appDataBase.getStaffDao();
    }

    @Override
    public Flowable<List<StaffDomain>> getStaff(final String team) {
        Flowable<List<Staff>> listStaff;
        if(checkNetwork()){
            listStaff = restService.getStaff(team)
                    .doOnNext(new Consumer<List<Staff>>() {
                        @Override
                        public void accept(List<Staff> staff) throws Exception {
                            switch (team){
                                case Constants.MINCHANKA:
                                    List<MinchankaStaff> list = new ArrayList<>();
                                    for (Staff s: staff){
                                        list.add((MinchankaStaff) s);
                                    }
                                    staffDao.insertMinchanka(list);
                                    break;
                            }
                        }
                    });
        }else{
            listStaff = staffDao.getMinchankaStaff()
                    .map(new Function<List<MinchankaStaff>, List<Staff>>() {
                        @Override
                        public List<Staff> apply(List<MinchankaStaff> minchankaStaffs) throws Exception {
                            List<Staff> list = new ArrayList<>();
                            list.addAll(minchankaStaffs);
                            return list;
                        }
                    });
        }

        return listStaff
                .map(new Function<List<Staff>, List<StaffDomain>>() {
                    @Override
                    public List<StaffDomain> apply(List<Staff> staff) throws Exception {
                        List<StaffDomain> staffDomainList = new ArrayList<>();
                        for (Staff s : staff) {
                            staffDomainList.add(
                                    new StaffDomain(s.getSurname(),
                                            s.getName(),
                                            s.getMiddleName(),
                                            s.getRole()));

                        }
                        return staffDomainList;
                    }
                });
    }


    private boolean checkNetwork() {
        boolean isConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                isConnected = true;
            }
        }
        return isConnected;
    }
}
