/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sebastián
 */
@Controller
public class IndexController {
    
    @RequestMapping("/") // URL al que responde
    public String page(Model model) {
        model.addAttribute("NombreProfesor", "Jonathan");
        return "index"; //nombre de la vista en template a mostrar
    }
    
    @RequestMapping("/info") // URL al que responde
    public String page() {
        return "info"; //nombre de la vista en template a mostrar
    }
    
}
