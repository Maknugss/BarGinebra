package com.barginebra.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="tipo")
    private String tipo;
}
