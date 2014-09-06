package com.hollywood.common.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollywood.fast.commons.BuildInformation;
import com.hollywood.fast.sampleapp.spring.controller.AboutController;

public class FastAboutController {

	private final Logger log = LoggerFactory.getLogger(AboutController.class);
	
	@Autowired
	private BuildInformation buildInfo;
	
	@RequestMapping("about")	
	public final String version(final ModelMap model) {
		log.debug("Running version");
		model.addAttribute("applicationName", getAppName());
		model.addAttribute("versionNumber", getVersionNumber());
		// return the name of the view
		return "about";
	}

	@RequestMapping(value="versionNumber", method = RequestMethod.GET )
	@ResponseBody
	public String versionNumber() { 
	  return getVersionNumber();	
	}
	
	private Object getAppName() {
		return "webapp-bootstrap";
	}
	
	private String getVersionNumber() {
		return buildInfo.getVersion();
	}
	
}
