package by.grsu.ruduk.taxopark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers")
public class DriversController {
    @GetMapping
    public String getDriversPage(){
        return "drivers";
    }
}
