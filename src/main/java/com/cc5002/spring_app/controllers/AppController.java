package com.cc5002.spring_app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cc5002.spring_app.services.AppService;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }
    
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", "Hello World!");
        return "buscador"; //view
    }

    @GetMapping("/comentarios")
    public String comentarios(Model model, @RequestParam int id_pedido, @RequestParam int id_donacion) {
        if (id_donacion != 0) {
            model.addAttribute("message", "Comentarios Donacion " + id_donacion);
        } else {
            model.addAttribute("message", "Comentarios Pedido " + id_pedido);
        }
        model.addAttribute("comentarios", appService.getComentarios(id_pedido, id_donacion));
        return "comentarios"; //view
    }
}
