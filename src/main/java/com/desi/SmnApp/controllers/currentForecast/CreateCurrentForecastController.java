package com.desi.SmnApp.controllers.currentForecast;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.SmnApp.controllers.extendedForecast.ExtendedForecastForm;
import com.desi.SmnApp.controllers.extendedForecast.ExtendedForecastFormModel;
import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.CurrentForecast;
import com.desi.SmnApp.entities.ExtendedForecast;
import com.desi.SmnApp.entities.WeatherStatus;
import com.desi.SmnApp.services.ICityService;
import com.desi.SmnApp.services.ICurrentForecast;


@Controller
@RequestMapping("/createCurrentForecast")
public class CreateCurrentForecastController {

	private ICityService cityService;
	private ICurrentForecast currentForecastService;
	
	@Autowired
	public CreateCurrentForecastController(ICityService cityService, ICurrentForecast currentForecastService) {
		super();
		this.cityService = cityService;
		this.currentForecastService = currentForecastService;
	}
	
	 @ModelAttribute("allCities")
	    public List<City> getAllCities() {
	        return this.cityService.getAll();
	    }
	
	 @RequestMapping(method = RequestMethod.GET)
	    public String configForm(Model model) {
	        CurrentForecastFormModel form = new CurrentForecastFormModel();

	
	        model.addAttribute("formBean", form);
	        return "createCurrentForecast";
	    }
	 @RequestMapping(method = RequestMethod.POST)
	    public String submit(@ModelAttribute("formBean") @Validated CurrentForecastForm formBean, BindingResult result, ModelMap modelo, @RequestParam String action) throws Exception {

	       
	        CurrentForecast e = formBean.toPojo();
	        e.setCity(cityService.getCityById(formBean.getIdCity()));
	        WeatherStatus w = new WeatherStatus(1L,"nublado");
	        e.setWeatherStatus(w);
	        currentForecastService.createCurrentForecast(e);
	        return "redirect:/";
	    }
}
