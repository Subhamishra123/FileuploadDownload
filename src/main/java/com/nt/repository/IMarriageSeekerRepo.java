package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.MarriageSeekerInfo;

public interface IMarriageSeekerRepo extends PagingAndSortingRepository<MarriageSeekerInfo, Integer> {

}
