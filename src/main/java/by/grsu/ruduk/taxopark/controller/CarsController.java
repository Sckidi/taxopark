package by.grsu.ruduk.taxopark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarsController {
    @GetMapping
    public String getCarsPage(){
        return "cars";
    }
}
