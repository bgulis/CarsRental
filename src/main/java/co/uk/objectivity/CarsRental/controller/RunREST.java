package co.uk.objectivity.CarsRental.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunREST {
    @GetMapping
    String defaultMessage(){
        return "Default Message";
    }
}
