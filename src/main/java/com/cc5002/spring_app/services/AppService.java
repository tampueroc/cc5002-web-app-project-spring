package com.cc5002.spring_app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cc5002.spring_app.comentario.Comentario;
import com.cc5002.spring_app.comentario.ComentarioRepository;

@Service
public class AppService {
    private final String pathStatic = "./spring_app/src/main/resources/static";
    private final ComentarioRepository comentarioRepository;

    public AppService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public List<Comentario> getComentarios(int id_donacion, int id_pedido) {
        if (id_donacion != 0) {
            List<Comentario> comentarios = comentarioRepository.findAll();
            List<Comentario> matchComentarios = new ArrayList<Comentario>();
            for (Comentario comentario : comentarios) {
                if (comentario.getId_donacion() == id_donacion) {
                    matchComentarios.add(comentario);
                }
            }
            return matchComentarios;
        } else {
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

}
