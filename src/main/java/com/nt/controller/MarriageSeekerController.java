package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.MarriageSeekerInfo;
import com.nt.model.MarriageSeeker;
import com.nt.service.IMarriageService;

@Controller
public class MarriageSeekerController {
	
	@Autowired
	private Environment env;
	@Autowired
	private IMarriageService service;
	
	@Autowired
	private ServletContext sc;
	
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	@GetMapping("/register")
	public String showRegister(@ModelAttribute("profile") MarriageSeeker profile)
	{
		return "profile_register";
	}
	
	@PostMapping("/register")
	public String processForm(@ModelAttribute("profile") MarriageSeeker profile,
								Map<String, Object> map)throws IOException
	{
		String location=env.getProperty("store.location");
		File file=new File(location);
		if(!file.exists())
			file.mkdir();
		MultipartFile resumeFile=profile.getResume();
		MultipartFile photoFile=profile.getPhoto();
		String resumeFileName=resumeFile.getOriginalFilename();
		String photoFileName=photoFile.getOriginalFilename();
		InputStream resumeIStream=resumeFile.getInputStream();
		InputStream photoIStream=photoFile.getInputStream();
		OutputStream resumeOStream=new FileOutputStream(location+"/"+resumeFileName);
		OutputStream photoOStream=new FileOutputStream(location+"/"+photoFileName);
		IOUtils.copy(photoIStream, photoOStream);
		IOUtils.copy(resumeIStream, resumeOStream);
		resumeIStream.close();photoIStream.close();
		resumeOStream.close();photoOStream.close();
		
		MarriageSeekerInfo info=new MarriageSeekerInfo();
		info.setProfileName(profile.getProfileName());
		info.setProfileGender(profile.getProfileGender());
		info.setResumePath(location+"/"+resumeFileName);
		info.setPhotoPath(location+"/"+photoFileName);
		String message = service.saveProfile(info);
		map.put("resumeFileName",resumeFileName);
		map.put("photoFileName",photoFileName);
		map.put("resultMsg", message);
		return "display_result";
	}
	@GetMapping("/display")
	public String showDisplay(Map<String, Object> map)
	{
		Iterable<MarriageSeekerInfo> profiles = service.getAllProfiles();
		System.out.println(profiles);
		map.put("profilesList", profiles);
		return "profile_display";
	}
	
	
	@GetMapping("/download")
	public String download(@RequestParam("fileName")String fileName,
							HttpServletResponse response)throws Exception
	{
		File file=new File(fileName);
		response.setContentLengthLong(file.length());
		String mimeType=sc.getMimeType(fileName);
		mimeType=mimeType!=null?mimeType:"application/octet-stream";
		response.setContentType(mimeType);
		InputStream is=new FileInputStream(file);
		OutputStream os=response.getOutputStream();
		response.setHeader("Content-Disposition", "attachment;fileName="+file.getName());
		IOUtils.copy(is, os);
		is.close();os.close();
		
		return null;
	}

}
