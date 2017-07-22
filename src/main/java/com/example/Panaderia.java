package com.example;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Guicho on 15/07/2017.
 */
@Entity
public class Panaderia {
    private int codigo;
    private String panaderia;
    private String pedido;
    private String equipo;



    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Panaderia() {
    }

    public Panaderia(int codigo, String panaderia, String pedido, String equipo) {
        this.codigo = codigo;
        this.panaderia = panaderia;
        this.pedido = pedido;
        this.equipo = equipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPanaderia() {
        return panaderia;
    }

    public void setPanaderia(String panaderia) {
        this.panaderia = panaderia;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
