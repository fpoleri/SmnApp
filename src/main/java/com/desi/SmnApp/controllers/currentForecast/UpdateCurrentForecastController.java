package com.desi.SmnApp.controllers.currentForecast;

import com.desi.SmnApp.controllers.currentForecast.CurrentForecastForm;
import com.desi.SmnApp.controllers.currentForecast.CurrentForecastFormModel;
import com.desi.SmnApp.controllers.extendedForecast.ExtendedForecastForm;
import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.CurrentForecast;
import com.desi.SmnApp.entities.ExtendedForecast;
import com.desi.SmnApp.entities.WeatherStatus;
import com.desi.SmnApp.services.ICityService;
import com.desi.SmnApp.services.ICurrentForecast;
import com.desi.SmnApp.services.IWeatherStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/updateCurrentForecast")
public class UpdateCurrentForecastController {

    private ICityService cityService;

    private IWeatherStatusService weatherStatusService;
    private ICurrentForecast currentForecastService;

    @Autowired
    public UpdateCurrentForecastController(ICityService cityService, ICurrentForecast currentForecastService, IWeatherStatusService weatherStatusService) {
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
    public String submit(@ModelAttribute("formBean") @Validated CurrentForecastForm formBean, BindingResult result, ModelMap model, @RequestParam String action) throws Exception {

        if (action.equals("Buscar pronóstico")) {
            Long cityId = formBean.getIdCity();
            CurrentForecast currentForeacast = currentForecastService.getCurrentForecastByCityId(cityId);
            model.addAttribute("allExtendedForecastByCity", currentForeacast);
            return "updateExtendedForecast";
        }

        if (action.equals("Registrar Clima")) {
            CurrentForecast e = formBean.toPojo();
            e.setCity(cityService.getCityById(formBean.getIdCity()));
            e.setWeatherStatus(weatherStatusService.getWeatherStatusById(formBean.getIdWeatherStatus()));
            currentForecastService.createCurrentForecast(e);
            return "redirect:/";
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/getForUpdate/{id}", method = RequestMethod.GET)
    public String getForUpdateById(Model model, @PathVariable("id") Long id) {
        CurrentForecast currentForecast = currentForecastService.getById(id);
        CurrentForecastForm formBean = new CurrentForecastForm(currentForecast);
        model.addAttribute("formBean", formBean);
        return "updateExtendedForecast";
    }
}