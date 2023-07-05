package com.cc5002.spring_app.comentario;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table
public class Comentario {
    @Id
    @SequenceGenerator(name = "comentario_sequence", sequenceName = "comentario_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_sequence")
    private Long Id;

    @NotNull
    private String nombre;

    @NotNull
    private String email;

    @NotNull
    private LocalDateTime fecha;

    @NotNull
    private String comentario;

    private Integer id_donacion;

    private Integer id_pedido;

    public Comentario() {
    }

    public Comentario(
        String nombre,
        String email,
        LocalDateTime fecha,
        String comentario,
        Integer id_donacion,
        Integer id_pedido
    ) {
        this.nombre = nombre;
        this.email = email;
        this.fecha = fecha;
        this.comentario = comentario;
        this.id_donacion = id_donacion;
        this.id_pedido = id_pedido;
    }

    // Getters

    public Long getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getId_donacion() {
        return id_donacion;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }
}
