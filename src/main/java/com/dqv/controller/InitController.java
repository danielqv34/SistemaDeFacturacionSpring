package com.dqv.controller;

import com.sun.istack.internal.logging.Logger;
import org.apache.commons.logging.Log;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ezequ on 12/11/2016.
 */

@Controller
@ComponentScan("com.dqv.controller")
public class InitController {

    final static Logger logger = Logger.getLogger(InitController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicio(){
        logger.info("Info:LLamo al controlador de inicio");
        return "login";
    }
}
