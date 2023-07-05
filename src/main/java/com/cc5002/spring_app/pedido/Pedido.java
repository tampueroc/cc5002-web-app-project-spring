package com.cc5002.spring_app.pedido;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table
public class Pedido {
    @Id
    @SequenceGenerator(
        name = "pedido_sequence",
        sequenceName = "pedido_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "pedido_sequence"
    )
    private int Id;

    @NotNull
    private int comuna_id;

    @NotNull
    private Byte tipo;

    private String descripcion;

    @NotNull
    private Long cantidad;

    @NotNull
    private String nombre_solicitante;

    @NotNull
    private String email_solicitante;

    private String celular_solicitante;

    public Pedido() {
    }

    public Pedido(
        int comuna_id,
        Byte tipo,
        String descripcion,
        Long cantidad,
        String nombre_solicitante,
        String email_solicitante,
        String celular_solicitante
    ) {
        this.comuna_id = comuna_id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.nombre_solicitante = nombre_solicitante;
        this.email_solicitante = email_solicitante;
        this.celular_solicitante = celular_solicitante;
    }

    // Getters

    public int getId() {
        return Id;
    }

    public int getComuna_id() {
        return comuna_id;
    }

    public Byte getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public String getNombre_solicitante() {
        return nombre_solicitante;
    }

    public String getEmail_solicitante() {
        return email_solicitante;
    }

    public String getCelular_solicitante() {
        return celular_solicitante;
    }

}
