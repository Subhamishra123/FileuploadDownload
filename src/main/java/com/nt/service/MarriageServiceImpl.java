package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeekerInfo;
import com.nt.repository.IMarriageSeekerRepo;
@Service
public class MarriageServiceImpl implements IMarriageService {

	@Autowired
	private IMarriageSeekerRepo repo;
	
	@Override
	public String saveProfile(MarriageSeekerInfo info) {
		// TODO Auto-generated method stub
		return "Profile Saved with id :: "+repo.save(info).getProfileId();
	}
	@Override
	public Iterable<MarriageSeekerInfo> getAllProfiles() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
