package com.fedex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fedex.service.ApplicationConfigurationService;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationConfigurationService applicationConfigurationService;
	
    /**
     * @return
     */
    @RequestMapping(method={RequestMethod.GET},value={"api/config/port"})
    public String getApplicationServerPort() {
    	return applicationConfigurationService.getApplicationServerPort();
    }
    
    /**
     * @return
     */
    @RequestMapping(method={RequestMethod.GET},value={"api/config/name"})
    public String getApplicationName() {
    	return applicationConfigurationService.getApplicationName();
    }
}

