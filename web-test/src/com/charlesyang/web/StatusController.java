package com.charlesyang.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class StatusController {

	private final String datacenterId;

	@Autowired
	public StatusController(Environment environment) {
		datacenterId = environment.getProperty("data.generator.datacenterId");
	}
	
	@RequestMapping(value = "/status")
	public void status(Model model) {
			model.addAttribute("ping", datacenterId);
	}

	

}
