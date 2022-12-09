package com.desi.SmnApp.controllers.extendedForecast;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.ExtendedForecast;
import com.desi.SmnApp.services.ICityService;
import com.desi.SmnApp.services.IExtendedForecast;

import javax.validation.Valid;

@Controller
@RequestMapping("/updateExtendedForecast")
public class UpdateExtendedForecastController {


    private ICityService cityService;
    private IExtendedForecast extendedForecastService;

    @Autowired
    public UpdateExtendedForecastController(ICityService cityService, IExtendedForecast extendedForecastService) {
        this.cityService = cityService;
        this.extendedForecastService = extendedForecastService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String configForm(Model model) {
        ExtendedForecastFormModel form = new ExtendedForecastFormModel();
        java.util.Date today = new java.util.Date();
        java.sql.Date todaySql = new java.sql.Date(today.getYear(), today.getMonth(), today.getDate());
        form.setDate(todaySql);
        model.addAttribute("formBean", form);
        return "updateExtendedForecast";
    }

    @ModelAttribute("allCities")
    public List<City> getAllCities() {
        return this.cityService.getAll();
    }

    @ModelAttribute("allExtendedForecastByCity")
    public List<ExtendedForecast> getExtendedForecast(ExtendedForecastForm formBean) {
        return extendedForecastService.getExtendedForecastByCityId(formBean.getIdCity());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid ExtendedForecastForm formBean, BindingResult result, ModelMap model, @RequestParam String action) throws Exception {


        if (action.equals("Buscar pronóstico")) {
            Long cityId = formBean.getIdCity();
            List<ExtendedForecast> extendedForeacast = extendedForecastService.getExtendedForecastByCityId(cityId);
            model.addAttribute("allExtendedForecastByCity", extendedForeacast);
            return "updateExtendedForecast";
        }

        if (action.equals("Editar pronóstico")) {
            Long cityId = formBean.getIdCity();
            if (extendedForecastService.getExtendedForecastByCityId(cityId).size() > 0) {
                ExtendedForecast e = formBean.toPojo();
                e.setCity(cityService.getCityById(formBean.getIdCity()));
                extendedForecastService.createExtendedForecast(e);
                model.addAttribute("formBean", formBean);
                return "redirect:/";
            }
            return "updateExtendedForecast";

        }

        return "redirect:/";
    }

    @RequestMapping(path = "/getForUpdate/{id}", method = RequestMethod.GET)
    public String getForUpdateById(Model model, @PathVariable("id") Long id) {
        ExtendedForecast extendedForecast = extendedForecastService.getById(id);
        ExtendedForecastForm formBean = new ExtendedForecastForm(extendedForecast);
        model.addAttribute("formBean", formBean);
        return "updateExtendedForecast";
    }

}
