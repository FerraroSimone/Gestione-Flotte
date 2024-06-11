package com.flotte.gestioneFlotte.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin("*")
@Controller
@RequestMapping("/swagger")
public class swaggerController {


	@GetMapping //localhost:8080/
	String redirezionaSwagger() {
		return "redirect:/swagger-ui/index.html#";
	} 
	
	


}
