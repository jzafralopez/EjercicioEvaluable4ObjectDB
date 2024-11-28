package org.example.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String correo;
    private String nombre;

    @OneToMany
    private List<Comentario> comentarios;
}
