package com.cc5002.spring_app.donacion;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Donacion {
    @Id
    @SequenceGenerator(name = "donacion_sequence", sequenceName = "donacion_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "donacion_sequence")
    private int Id;

    @NotNull
    private int comuna_id;

    @NotNull
    private String calle_numero;

    @NotNull
    private Byte tipo;

    @NotNull
    private Long cantidad;

    @NotNull
    private LocalDateTime fecha_disponibilidad;

    private String descripcion;

    private String condiciones_retirar;

    @NotNull
    private String nombre;

    @NotNull
    private String email;

    private String celular;


    public Donacion() {
    }

    public Donacion(
        int comuna_id,
        String calle_numero,
        Byte tipo,
        Long cantidad,
        LocalDateTime fecha_disponibilidad,
        String descripcion,
        String condiciones_retirar,
        String nombre,
        String email,
        String celular
    ){
        this.comuna_id = comuna_id;
        this.calle_numero = calle_numero;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha_disponibilidad = fecha_disponibilidad;
        this.descripcion = descripcion;
        this.condiciones_retirar = condiciones_retirar;
        this.nombre = nombre;
        this.email = email;
        this.celular = celular;
    }

    // Getters
    public int getId() {
        return Id;
    }

    public int getComuna_id() {
        return comuna_id;
    }

    public String getCalle_numero() {
        return calle_numero;
    }

    public Byte getTipo() {
        return tipo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public LocalDateTime getFecha_disponibilidad() {
        return fecha_disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCondiciones_retirar() {
        return condiciones_retirar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

}
