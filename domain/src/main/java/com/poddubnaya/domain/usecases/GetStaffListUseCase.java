package com.poddubnaya.domain.usecases;


import com.poddubnaya.domain.entity.StaffDomain;
import com.poddubnaya.domain.executor.PostExecutionThread;
import com.poddubnaya.domain.repository.StaffRepository;

import java.util.List;

import io.reactivex.Flowable;

public class GetStaffListUseCase extends BaseUseCase {
    private StaffRepository staffRepository;

    public GetStaffListUseCase(PostExecutionThread postExecutionThread, StaffRepository staffRepository) {
        super(postExecutionThread);
        this.staffRepository = staffRepository;
    }

    public Flowable<List<StaffDomain>> getStaff(String team){
        return staffRepository.getStaff(team)
                .subscribeOn(threadExecution)
                .observeOn(postExecutionThread);
    }
}
