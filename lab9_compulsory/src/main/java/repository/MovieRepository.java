package repository;

import main.EntityManagerFactorySingleton;
import model.Movies;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

public class MovieRepository {
    @PersistenceContext(unitName = "lab9")
    private static EntityManager em;

    public static void create(Movies movie) {
        em = EntityManagerFactorySingleton.createEntityManager();
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
    }

    public static Movies findById(String id) {
        em = EntityManagerFactorySingleton.createEntityManager();
        return (Movies) em.createNamedQuery("Movie.findById")
                .setParameter("id", id)
                .getSingleResult();
    }
}
