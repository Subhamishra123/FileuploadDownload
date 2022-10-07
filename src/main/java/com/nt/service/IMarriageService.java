package com.nt.service;

import com.nt.entity.MarriageSeekerInfo;

public interface IMarriageService {
	
	public String saveProfile(MarriageSeekerInfo info);
	
	public Iterable<MarriageSeekerInfo> getAllProfiles();

}
