package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "boot_marriage_seeker")
@Data
public class MarriageSeekerInfo {
	
	@Id
	@GeneratedValue
	private Integer profileId;
	@Column(length = 30)
	private String profileName;
	private String profileGender;
	@Column(length = 150)
	private String resumePath;
	@Column(length = 150)
	private String photoPath;

}
