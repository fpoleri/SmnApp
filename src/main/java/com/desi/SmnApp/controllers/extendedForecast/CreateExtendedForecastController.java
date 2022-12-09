package com.desi.SmnApp.controllers.extendedForecast;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.ExtendedForecast;
import com.desi.SmnApp.services.ICityService;
import com.desi.SmnApp.services.IExtendedForecast;

import javax.validation.Valid;

@Controller
@RequestMapping("/createExtendedForecast")
public class CreateExtendedForecastController {
    private ICityService cityService;
    private IExtendedForecast extendedForecastService;

    @Autowired
    public CreateExtendedForecastController(ICityService cityService, IExtendedForecast extendedForecastService) {
        this.cityService = cityService;
        this.extendedForecastService = extendedForecastService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String configForm(Model model) {
        ExtendedForecastFormModel form = new ExtendedForecastFormModel();
        model.addAttribute("formBean", form);
        return "createExtendedForecast";
    }

    @ModelAttribute("allCities")
    public List<City> getAllCities() {
        return this.cityService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid ExtendedForecastForm formBean, BindingResult result, ModelMap model, @RequestParam String action) throws Exception {

        if (!extendedForecastService.doesExtendedForescastExists(formBean.getIdCity(), formBean.getDate())) {
            try {
                ExtendedForecast e = formBean.toPojo();
                e.setCity(cityService.getCityById(formBean.getIdCity()));
                extendedForecastService.createExtendedForecast(e);
            } catch (Exception e) {
                ObjectError error = new ObjectError("globalError", e.getMessage());
                result.addError(error);
                return "createExtendedForecast";
            }
        }

        if (result.hasErrors()) {
            model.addAttribute("formBean", formBean);
            return "createExtendedForecast";
        }
        return "redirect:/";
    }

}
