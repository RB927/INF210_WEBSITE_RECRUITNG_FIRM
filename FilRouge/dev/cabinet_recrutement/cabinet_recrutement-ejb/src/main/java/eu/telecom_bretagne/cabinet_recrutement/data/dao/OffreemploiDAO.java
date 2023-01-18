package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Jan 16, 2023, 3:12:29 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Home object for domain model class Offreemploi.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Offreemploi
 * @author Hibernate Tools
 */
  import eu.telecom_bretagne.cabinet_recrutement.data.model.Offreemploi;

@Stateless
public class OffreemploiDAO{

    private static final Logger logger = Logger.getLogger(OffreemploiDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Offreemploi transientInstance) {
        logger.log(Level.INFO, "persisting Offreemploi instance");
        try {
            entityManager.persist(transientInstance);
            logger.log(Level.INFO, "persist successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }
    
    public void remove(Offreemploi persistentInstance) {
        logger.log(Level.INFO, "removing Offreemploi instance");
        try {
            entityManager.remove(persistentInstance);
            logger.log(Level.INFO, "remove successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "remove failed", re);
            throw re;
        }
    }
    
    public Offreemploi merge(Offreemploi detachedInstance) {
        logger.log(Level.INFO, "merging Offreemploi instance");
        try {
            Offreemploi result = entityManager.merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }
    
    public Offreemploi findById( int id) {
        logger.log(Level.INFO, "getting Offreemploi instance with id: " + id);
        try {
            Offreemploi instance = entityManager.find(Offreemploi.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

