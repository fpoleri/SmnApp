package com.desi.SmnApp.controllers.extendedForecast;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.ExtendedForecast;
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

    @RequestMapping(method = RequestMethod.GET)
    public String configForm(Model model) {
        ExtendedForecastFormModel form = new ExtendedForecastFormModel();

        Date today = new Date();
        java.sql.Date tomorrow = new java.sql.Date(today.getYear(), today.getMonth(), today.getDate());
        form.setDate(tomorrow);
        model.addAttribute("formBean", form);
        return "createExtendedForecast";
    }

    @ModelAttribute("allCities")
    public List<City> getAllCities() {
        return this.cityService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Validated ExtendedForecastForm formBean, BindingResult result, ModelMap modelo, @RequestParam String action) throws Exception {

        if (extendedForecastService.doesExtendedForescastExists(formBean.getIdCity(), formBean.getDate())) {
            //ObjectError error = new ObjectError("ExtendedForecastForm", "bbbb");
            FieldError fieldError = new FieldError("formBean", "aaaa", "bbbb");
            result.addError(fieldError);
        }

        if (result.hasErrors()) {
            modelo.addAttribute("formBean", formBean);
            return "createExtendedForecast";
        }
        ExtendedForecast e = formBean.toPojo();
        e.setCity(cityService.getCityById(formBean.getIdCity()));
        extendedForecastService.createExtendedForecast(e);
        return "redirect:/createExtendedForecast";
    }

}
