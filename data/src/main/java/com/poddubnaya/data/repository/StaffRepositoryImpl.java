package com.poddubnaya.data.repository;


import com.poddubnaya.data.entity.Staff;
import com.poddubnaya.data.rest.RestService;
import com.poddubnaya.domain.entity.StaffDomain;
import com.poddubnaya.domain.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

public class StaffRepositoryImpl implements StaffRepository {

    private RestService restService;

    public StaffRepositoryImpl(RestService restService) {
        this.restService = restService;
    }

    @Override
    public Flowable<List<StaffDomain>> getStaff(String team) {
        return restService.getStaff(team)
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
}
