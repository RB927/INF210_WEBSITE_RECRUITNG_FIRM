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
    

    
    public Messageoffreemploi persist(Messageoffreemploi Messageoffreemploi) {
		if (Messageoffreemploi != null) {
			entityManager.persist(Messageoffreemploi);
		}
		return Messageoffreemploi;
	}

	public Messageoffreemploi update(Messageoffreemploi Messageoffreemploi) {
		if (Messageoffreemploi != null) {
			entityManager.merge(Messageoffreemploi);
		}
		return Messageoffreemploi;
	}

	public void remove(Messageoffreemploi Messageoffreemploi) {
		if ((Messageoffreemploi != null) & (!entityManager.contains(Messageoffreemploi))) {
			Messageoffreemploi sup = entityManager.merge(Messageoffreemploi);
			entityManager.remove(sup);
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

