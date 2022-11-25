package com.desi.SmnApp.controllers.extendedForecast;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desi.SmnApp.services.ICityService;
import com.desi.SmnApp.services.IExtendedForecast;

@Controller
@RequestMapping("/createExtendedForecast")
public class CreateExtendedForecastController {

	private ICityService cityService;
	private IExtendedForecast extendedForecastService;
	
	@Autowired
	public CreateExtendedForecastController(ICityService cityService, IExtendedForecast extendedForecastService) {
		super();
		this.cityService = cityService;
		this.extendedForecastService = extendedForecastService;
	}
	
	@GetMapping("/")
	public String welcome() {
		
		return "createExtendedForecast";
	}
}
