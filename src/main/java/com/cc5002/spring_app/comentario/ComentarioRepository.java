package com.cc5002.spring_app.comentario;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("comentarioRepository")
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    Page<Comentario> findAllByOrderByIdDesc(Pageable pageable);
    List<Comentario> findAllByOrderByFechaDesc();
}
