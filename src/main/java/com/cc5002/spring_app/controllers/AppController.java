package com.cc5002.spring_app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cc5002.spring_app.services.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }
    
    @GetMapping("/")
    public String main(Model model) {
        return "buscador"; //view
    }

    @GetMapping("/comentarios")
    public String comentarios(Model model, @RequestParam(required = false) Integer id_pedido, @RequestParam(required = false) Integer id_donacion) {
        if (id_donacion != null) {
            model.addAttribute("message", "Comentarios Donacion " + id_donacion);
            model.addAttribute("id_donacion", id_donacion);
        } else {
            model.addAttribute("message", "Comentarios Pedido " + id_pedido);
            model.addAttribute("id_pedido", id_pedido);
        }
        model.addAttribute("comentarios", appService.getComentarios(id_donacion, id_pedido));
        return "comentarios"; //view
    }

    @PostMapping(value="/comentarios")
    public String postComentario(@RequestParam(required = false) Integer id_pedido, @RequestParam(required = false) Integer id_donacion, @RequestParam String comentario, @RequestParam String nombre, @RequestParam String email) {
        appService.handlePostRequest(id_pedido, id_donacion, comentario, nombre, email);  
        if (id_donacion == null) {
            return "redirect:/comentarios?id_pedido=" + Integer.toString(id_pedido);
        }
        else {
            return "redirect:/comentarios?id_donacion=" + Integer.toString(id_donacion);
        }      
    }
    
}
