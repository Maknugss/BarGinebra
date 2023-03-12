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
@Table(name="usuario") //Creación de la tabla
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="correo")
    private String correo;
    @Column(name="password")
    private String password;
    @Column(name="nombres")
    private String nombres;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="documento")
    private long documento;
    @Column(name="tipo_documento")
    private String tipo_documento;
    @JoinColumn(name = "id_tipo_usuario")
    @ManyToMany
    private List<TipoUsuario> tipo_usuario;
}
