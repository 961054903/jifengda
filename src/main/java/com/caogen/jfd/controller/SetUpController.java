package com.caogen.jfd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/member")
public class SetUpController {

    @RequestMapping(value = "/City")
    public String City() {
        return null;

    }
}