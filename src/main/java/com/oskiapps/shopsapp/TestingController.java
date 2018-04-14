package com.oskiapps.shopsapp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @RequestMapping("/test")
    public String greeting() {
        return "test controller";
    }

}