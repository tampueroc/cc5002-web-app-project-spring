package com.cc5002.spring_app.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cc5002.spring_app.comentario.Comentario;
import com.cc5002.spring_app.comentario.ComentarioRepository;

@Service
public class AppService {
    private final ComentarioRepository comentarioRepository;

    public AppService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public List<Comentario> getComentarios(Integer id_donacion, Integer id_pedido) {
        if (id_donacion != null) {
            List<Comentario> comentarios = comentarioRepository.findAllByOrderByFechaDesc();
            List<Comentario> matchComentarios = new ArrayList<Comentario>();
            for (Comentario comentario : comentarios) {
                if (comentario.getId_donacion() == id_donacion) {
                    matchComentarios.add(comentario);
                }
            }
            return matchComentarios;
        } else {
            List<Comentario> comentarios = comentarioRepository.findAllByOrderByFechaDesc();
            List<Comentario> matchComentarios = new ArrayList<Comentario>();
            for (Comentario comentario : comentarios) {
                if (comentario.getId_pedido() == id_pedido) {
                    matchComentarios.add(comentario);
                }
            }
            return matchComentarios;
        }
    }

    public void handlePostRequest(Integer id_pedido, Integer id_donacion, String comentario, String nombre, String email) {
        LocalDateTime comentarioTimestamp = LocalDateTime.now();
        Comentario comentario_object = new Comentario(nombre, email, comentarioTimestamp, comentario, id_donacion, id_pedido);
        comentarioRepository.save(comentario_object);
    }
}
