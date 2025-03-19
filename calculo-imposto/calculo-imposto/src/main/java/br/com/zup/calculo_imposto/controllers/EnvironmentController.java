package br.com.zup.calculo_imposto.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

    @Value("${app.env}")
    private String appEnv;

    @GetMapping("/env")
    public String getEnvironment(){
        return "Current environments: " + appEnv;

    }

}
