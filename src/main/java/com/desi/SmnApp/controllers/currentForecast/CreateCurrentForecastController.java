package com.desi.SmnApp.controllers.currentForecast;

import java.util.Date;
import java.util.List;

import com.desi.SmnApp.exceptions.ExceptionManager;
import com.desi.SmnApp.services.IWeatherStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.CurrentForecast;
import com.desi.SmnApp.entities.WeatherStatus;
import com.desi.SmnApp.services.ICityService;
import com.desi.SmnApp.services.ICurrentForecast;

import javax.validation.Valid;


@Controller
@RequestMapping("/createCurrentForecast")
public class CreateCurrentForecastController {

    private ICityService cityService;

    private IWeatherStatusService weatherStatusService;
    private ICurrentForecast currentForecastService;

    @Autowired
    public CreateCurrentForecastController(ICityService cityService, ICurrentForecast currentForecastService, IWeatherStatusService weatherStatusService) {
        this.cityService = cityService;
        this.currentForecastService = currentForecastService;
        this.weatherStatusService = weatherStatusService;
    }

    @ModelAttribute("allCities")
    public List<City> getAllCities() {
        return this.cityService.getAll();
    }

    @ModelAttribute("allWeatherStatus")
    public List<WeatherStatus> getAllWeatherStatus() {
        return this.weatherStatusService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String configForm(Model model) {
        CurrentForecastFormModel form = new CurrentForecastFormModel();
        Date today = new Date();
        java.sql.Date todaySql = new java.sql.Date(today.getYear(), today.getMonth(), today.getDate());
        form.setDate(todaySql);
        model.addAttribute("formBean", form);
        return "createCurrentForecast";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid CurrentForecastForm formBean, BindingResult result, ModelMap modelo, @RequestParam String action) throws Exception {

        if (action.equals("Ir al menú")) {
            return "redirect:/";
        }
        if (currentForecastService.doesExtendedForescastExists(formBean.getIdCity(), formBean.getDate())) {
            return "createCurrentForecast";
        }
        try {
            CurrentForecast e = formBean.toPojo();
            e.setCity(cityService.getCityById(formBean.getIdCity()));
            e.setWeatherStatus(weatherStatusService.getWeatherStatusById(formBean.getIdWeatherStatus()));
            currentForecastService.createCurrentForecast(e);
        } catch (Exception e) {
            ObjectError error = new ObjectError("globalError", e.getMessage());
            result.addError(error);
            return "createCurrentForecast";
        }
        return "redirect:/";
    }
}
