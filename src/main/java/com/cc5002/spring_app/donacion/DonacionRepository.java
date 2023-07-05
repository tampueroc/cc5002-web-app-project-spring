package com.cc5002.spring_app.donacion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("donacionRepository")
public interface DonacionRepository extends JpaRepository<Donacion, Long>{
    Page<Donacion> findAllByOrderByIdDesc(Pageable pageable);
}
