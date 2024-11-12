package com.soumyajit.Simple.Calculator.Controller;


import com.soumyajit.Simple.Calculator.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/add")
    public double add(@RequestParam double a , @RequestParam double b){
        return service.add(a,b);
    }
    @GetMapping("/subs")
    public double subs(@RequestParam double a , @RequestParam double b){
        return service.substract(a,b);
    }
    @GetMapping("/multiply")
    public double multiply(@RequestParam double a , @RequestParam double b){
        return service.multiply(a,b);
    }
    @GetMapping("/division")
    public double division(@RequestParam double a , @RequestParam double b){
        return service.division(a,b);
    }

    @GetMapping("/sqrt")
    public double sqrt(@RequestParam double a){
        return service.sqrt(a);
    }
    @GetMapping("/pow")
    public double pow(@RequestParam double a,@RequestParam double b){
        return service.pow(a,b);
    }
    @GetMapping("/log")
    public double log(@RequestParam double a){
        return service.log(a);
    }
    @GetMapping("/exponential")
    public double exponential(@RequestParam double a){
        return service.exponential(a);
    }
    @GetMapping("/sin")
    public double sin(@RequestParam double a){
        return service.sin(a);
    }
    @GetMapping("/cos")
    public double cos(@RequestParam double a){
        return service.cos(a);
    }
    @GetMapping("/tan")
    public double tan(@RequestParam double a){
        return service.tan(a);
    }
}
