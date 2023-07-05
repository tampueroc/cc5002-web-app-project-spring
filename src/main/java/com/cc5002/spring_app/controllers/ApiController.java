package com.cc5002.spring_app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cc5002.spring_app.comentario.Comentario;
import com.cc5002.spring_app.pedido.Pedido;
import com.cc5002.spring_app.services.ApiService;


@RestController
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping(path = "/api/donaciones")
    public List<Map<String, Object>> getDonaciones(@RequestParam String name) {
        return apiService.getDonaciones(name);
    }

    @GetMapping(path = "/api/pedidos")
    public List<Pedido> getPedidos(@RequestParam String name) {
        return apiService.getPedidos(name);
    }

    @GetMapping(path = "/api/comentarios")
    public List<Comentario> getDonacionComentarios(@RequestParam int id_donacion, @RequestParam int id_pedido) {
        if (id_donacion != 0) {
            return apiService.getDonacionComentarios(id_donacion);
        } else {
            return apiService.getPedidoComentarios(id_pedido);
        }
    }
    
}
