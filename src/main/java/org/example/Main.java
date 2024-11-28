package org.example;

import org.example.models.Comentario;
import org.example.models.Usuario;
import org.example.services.Service;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = ObjectDBUtil.getEntityManagerFactory();
        Service service = new Service(emf);

        /** 1.- Crear un usuario y registrarlo en la BD **/
        var usuario = new Usuario();
        usuario.setCorreo("usuario@ejemplo.com");
        usuario.setNombre("Pepito");

        service.guardar(usuario);

        /** 2.- Listar comentarios de un usuario específico **/
        var comentario = new Comentario();
        comentario.setContenido("La peli ha estado regular.");
        comentario.setValoracion(4);
        comentario.setUsuario(usuario);
        usuario.setComentarios(List.of(comentario));

        service.getComentariosUsuario(usuario);

        /** 3.- Añadir un comentario a la plataforma como usuario registrado **/
        var comentario2 = new Comentario();
        comentario2.setContenido("La peli ha estado genial.");
        comentario2.setValoracion(10);
        comentario2.setUsuario(usuario);

        service.addComentario(comentario2);

        /** 4.- Listar usuarios que han realizado comentarios con la valoración máxima posible **/
        var usuariosConValoracionMaxima = service.listarUsuariosValoracionMaxima();
        usuariosConValoracionMaxima.forEach(u -> System.out.println("Usuario: " + u.getNombre()));

    }
}
