package com.dqv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by @DanielQuirozV on 3/17/2017.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String iniciaSesion(){
        return "inicio";
    }

}
