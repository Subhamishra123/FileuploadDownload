package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class ConfigClass {
	@Bean
	 CommonsMultipartResolver createCMResolver()
	{
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		resolver.setMaxUploadSizePerFile(300*1024);
		resolver.setPreserveFilename(true);
		return resolver;
	}

}
