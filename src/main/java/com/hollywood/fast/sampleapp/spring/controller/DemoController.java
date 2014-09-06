package com.hollywood.fast.sampleapp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class DemoController {

	@RequestMapping("form")
	public String loadForm(ModelMap model) {
		return "form-demo";
	}
	
	@RequestMapping("test")
	public String testPage(ModelMap model) {
		return "test";
	}
}
