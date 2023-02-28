package com.barginebra.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String nombre;

    @Column(name="precio")
    private String precio;
}
