package org.example.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
public class Comentario implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String contenido;;
    private int valoracion;

    @ManyToOne
    private Usuario usuario;
}
