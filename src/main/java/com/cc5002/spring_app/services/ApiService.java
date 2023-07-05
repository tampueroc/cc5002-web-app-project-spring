package com.cc5002.spring_app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cc5002.spring_app.comentario.Comentario;
import com.cc5002.spring_app.comentario.ComentarioRepository;
import com.cc5002.spring_app.donacion.Donacion;
import com.cc5002.spring_app.donacion.DonacionRepository;
import com.cc5002.spring_app.pedido.Pedido;
import com.cc5002.spring_app.pedido.PedidoRepository;

@Service
public class ApiService {
    private final DonacionRepository donacionRepository;
    private final PedidoRepository pedidoRepository;
    private final ComentarioRepository comentarioRepository;

    public ApiService(DonacionRepository donacionRepository, PedidoRepository pedidoRepository,
            ComentarioRepository comentarioRepository) {
        this.donacionRepository = donacionRepository;
        this.pedidoRepository = pedidoRepository;
        this.comentarioRepository = comentarioRepository;
    }

    public List<Map<String, Object>> getDonaciones(String nameSubString) {
        List<Donacion> donaciones = donacionRepository.findAll();
        System.out.println("donaciones: " + donaciones);
        List<Map<String, Object>> matchDonaciones = new ArrayList<>();
        for (Donacion donacion : donaciones) {
            if (donacion.getNombre().toLowerCase().contains(nameSubString)) {
                int totalComentarios = 0;
                List<Comentario> comentarios = comentarioRepository.findAll();
                for (Comentario comentario : comentarios) {
                    if (comentario.getId_donacion() == donacion.getId()) {
                        totalComentarios++;
                    }
                }
                Map<String, Object> donacionEntry = new HashMap<>();
                donacionEntry.put("donacion", donacion);
                donacionEntry.put("total_comentarios", totalComentarios);
                matchDonaciones.add(donacionEntry);
            }
        }
        return matchDonaciones;
    }

    public List<Pedido> getPedidos(String nameSubString) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<Pedido> matchPedidos = new ArrayList<Pedido>();
        for (Pedido pedido : pedidos) {
            if (pedido.getNombre_solicitante().toLowerCase().contains(nameSubString)) {
                matchPedidos.add(pedido);
            }
        }
        return matchPedidos;
    }

    public List<Comentario> getDonacionComentarios(int id_donacion) {
        List<Comentario> comentarios = comentarioRepository.findAll();
        List<Comentario> matchComentarios = new ArrayList<Comentario>();
        for (Comentario comentario : comentarios) {
            if (comentario.getId_donacion() == id_donacion) {
                matchComentarios.add(comentario);
            }
        }
        return matchComentarios;
    }

    public List<Comentario> getPedidoComentarios(int id_pedido) {
        List<Comentario> comentarios = comentarioRepository.findAll();
        List<Comentario> matchComentarios = new ArrayList<Comentario>();
        for (Comentario comentario : comentarios) {
            if (comentario.getId_pedido() == id_pedido) {
                matchComentarios.add(comentario);
            }
        }
        return matchComentarios;
    }

}
