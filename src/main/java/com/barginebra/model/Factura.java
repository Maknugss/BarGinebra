package com.barginebra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="total")
    private long total;

    @JoinColumn(name="tipo_pago")
    @OneToOne
    private TipoPago tipoPago;

    @JoinColumn(name = "id_productos")
    @OneToMany
    private List<Producto> producto;
}
