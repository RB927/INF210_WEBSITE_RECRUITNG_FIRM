package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Jan 16, 2023, 3:12:29 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Home object for domain model class Messageoffreemploi.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Messageoffreemploi
 * @author Hibernate Tools
 */
import eu.telecom_bretagne.cabinet_recrutement.data.model.Messageoffreemploi;

@Stateless
public class MessageoffreemploiDAO {

    private static final Logger logger = Logger.getLogger(MessageoffreemploiDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Messageoffreemploi transientInstance) {
        logger.log(Level.INFO, "persisting Messageoffreemploi instance");
        try {
            entityManager.persist(transientInstance);
            logger.log(Level.INFO, "persist successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "persist failed", re);
            throw re;
        }
    }
    
    public void remove(Messageoffreemploi persistentInstance) {
        logger.log(Level.INFO, "removing Messageoffreemploi instance");
        try {
            entityManager.remove(persistentInstance);
            logger.log(Level.INFO, "remove successful");
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "remove failed", re);
            throw re;
        }
    }
    
    public Messageoffreemploi merge(Messageoffreemploi detachedInstance) {
        logger.log(Level.INFO, "merging Messageoffreemploi instance");
        try {
            Messageoffreemploi result = entityManager.merge(detachedInstance);
            logger.log(Level.INFO, "merge successful");
            return result;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "merge failed", re);
            throw re;
        }
    }
    
    public Messageoffreemploi findById( int id) {
        logger.log(Level.INFO, "getting Messageoffreemploi instance with id: " + id);
        try {
            Messageoffreemploi instance = entityManager.find(Messageoffreemploi.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

