package com.poddubnaya.domain.repository;


import com.poddubnaya.domain.entity.StaffDomain;

import java.util.List;

import io.reactivex.Flowable;

public interface StaffRepository {
    Flowable<List<StaffDomain>> getStaff(String team);

}
