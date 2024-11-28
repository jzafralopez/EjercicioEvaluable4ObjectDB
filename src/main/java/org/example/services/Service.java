package org.example.services;

import org.example.models.Comentario;
import org.example.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class Service {
    private static EntityManagerFactory emf;
    public Service(EntityManagerFactory emf) {
        this.emf = emf;
    }


    public List<Comentario> getComentariosUsuario(Usuario usuario) {
        List<Comentario> comentarios = null;
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Comentario> query = em.createQuery(
                    "SELECT c FROM Comentario c WHERE c.usuario.id = :usuarioId",
                    Comentario.class
            );
            query.setParameter("usuarioId", usuario.getId());
            comentarios = query.getResultList();
            em.close();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al obtener comentarios del usuario: " + e.getMessage(), e);
        }
        System.out.println(comentarios);
        return comentarios;
    }


    public void guardar(Usuario usuario){
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            em.close();
            System.out.println("Usuario guardado correctamente.");
        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public void addComentario(Comentario comentario) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(comentario);
            em.getTransaction().commit();
            em.close();
            System.out.println("Comentario añadido correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Usuario> listarUsuariosValoracionMaxima() {
        List<Usuario> usuarios = null;
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT DISTINCT c.usuario FROM Comentario c WHERE c.valoracion = 10",
                    Usuario.class
            );
            usuarios = query.getResultList();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(usuarios);
        return usuarios;
    }
}
