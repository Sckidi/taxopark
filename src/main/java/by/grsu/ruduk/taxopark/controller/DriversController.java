package by.grsu.ruduk.taxopark.controller;

import by.grsu.ruduk.taxopark.model.Driver;
import by.grsu.ruduk.taxopark.model.User;
import by.grsu.ruduk.taxopark.repository.DriverRepository;
import by.grsu.ruduk.taxopark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers")
public class DriversController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping
    public String getDriversPage(Model model) {
        model.addAttribute("isAuhorised", getCurrentUser() != null);
        model.addAttribute("drivers", driverRepository.findAll());
        return "drivers";
    }

    @GetMapping("/del/{id}")
    public String deleteCardById(@PathVariable("id") Long id, Model model) {
        driverRepository.deleteById(id);
        model.addAttribute("isAuhorised", getCurrentUser() != null);
        model.addAttribute("drivers", driverRepository.findAll());
        return "drivers";
    }


    @PostMapping
    public String addDriversPage(@ModelAttribute("form") Driver aDriver, Model model) {
        model.addAttribute("isAuhorised", getCurrentUser() != null);
        Driver driver = driverRepository.findByLicenseNumber(aDriver.getLicenseNumber());
        if(driver!=null){
            model.addAttribute("driverError", true);
        }else{
            driver = aDriver;
            driverRepository.save(driver);
            model.addAttribute("addedSuccessful", true);
        }
        model.addAttribute("drivers", driverRepository.findAll());
        return "drivers";
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(auth.getName());
    }

    @Autowired
    private UserRepository userRepository;
}
