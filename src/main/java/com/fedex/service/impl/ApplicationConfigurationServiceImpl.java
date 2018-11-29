package com.fedex.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fedex.service.ApplicationConfigurationService;

@Service
public class ApplicationConfigurationServiceImpl implements ApplicationConfigurationService{
	
	/**
	 * 
	 */
	@Value("${server.port}")
	private String port;
	
	@Value("${spring.application.name}")
	private String name;
	
	/* (non-Javadoc)
	 * @see com.fedex.service.ApplicationConfigurationService#getApplicationServerPort()
	 */
	public String getApplicationServerPort(){
		return port;
	}
	
	
	/* (non-Javadoc)
	 * @see com.fedex.service.ApplicationConfigurationService#getApplicationName()
	 */
	public String getApplicationName(){
		return name;
	}

}
