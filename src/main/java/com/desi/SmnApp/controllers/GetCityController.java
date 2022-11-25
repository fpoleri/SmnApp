package com.desi.SmnApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.services.ICityService;

@Controller
@RequestMapping("/getCity")
public class GetCityController {
	
	private ICityService cityService;

	@Autowired
	public GetCityController(ICityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	/*
    @GetMapping
    public String preparaForm(Model modelo) {
    	CiudadesBuscarForm form =  new CiudadesBuscarForm();
//    	 form.setProvincias(servicioProvincia.getAll());    //  en lugar de esto hacemos @ModelAttribute("allProvincias")
       modelo.addAttribute("formBean",form);
       return "getCity";
    }*/
    
    public List<City> getAllCities() {
        return this.cityService.getAll();
    }
  
}
