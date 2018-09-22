package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController{

	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}

//	@RequestMapping("/challenge")
//	public String challenge(@RequestParam(value = "name") String name, Model model) {
//		model.addAttribute("name",name);
//		return "challenge";
//	}

	@RequestMapping({"/challenge","/challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name",name.get());
		}
		else {
			model.addAttribute("name","KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", defaultValue = "1") String m, @RequestParam(value = "b",defaultValue = "1") String hm, Model model){	
		int mInt = Integer.parseInt(m);
		int hmInt = Integer.parseInt(hm);
		String output = "hm";		
		String outputHm ="hm";
		
		if(mInt > 1) {
			for (int i = mInt ; i > 1 ; i-- ) {
				output = output + "m";			
			}
		}
		outputHm = output; 
		
		if(hmInt > 1) {
			for (int i = hmInt ; i > 1 ; i-- ) {
				output = output + " " + outputHm;
			}
		}
		model.addAttribute("m",mInt);
		model.addAttribute("hm",hmInt);
		model.addAttribute("output",output);
		return "generator";
	}
		


}
