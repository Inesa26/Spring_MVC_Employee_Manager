package edu.step.manager.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ContactController {
    @GetMapping("/contact")
    public String viewContactPage(){
        return "contact";
    }
}
