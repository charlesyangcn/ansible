package com.charlesyang.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class StatusController {

	private final String datacenterId;
	private final String workerId;

	@Autowired
	public StatusController(Environment environment) {
		datacenterId = environment.getProperty("data.generator.datacenterId");
		workerId = environment.getProperty("data.generator.workerId");
	}
	
	@RequestMapping(value = "/status")
	public void status(Model model) {
			model.addAttribute("datacenterId", datacenterId);
			model.addAttribute("workerId", workerId);
	}

	

}
