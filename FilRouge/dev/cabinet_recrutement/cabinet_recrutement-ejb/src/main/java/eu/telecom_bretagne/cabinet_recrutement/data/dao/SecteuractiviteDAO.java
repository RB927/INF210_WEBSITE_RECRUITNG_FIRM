package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Jan 16, 2023, 3:12:29 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Home object for domain model class Secteuractivite.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite
 * @author Hibernate Tools
 */
import eu.telecom_bretagne.cabinet_recrutement.data.model.Secteuractivite;

@Stateless
public class SecteuractiviteDAO {

    private static final Logger logger = Logger.getLogger(SecteuractiviteDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
     public Secteuractivite persist(Secteuractivite Secteuractivite) {
		if (Secteuractivite != null) {
			entityManager.persist(Secteuractivite);
		}
		return Secteuractivite;
	}

	public Secteuractivite update(Secteuractivite Secteuractivite) {
		if (Secteuractivite != null) {
			entityManager.merge(Secteuractivite);
		}
		return Secteuractivite;
	}

	public void remove(Secteuractivite Secteuractivite) {
		if ((Secteuractivite != null) & (!entityManager.contains(Secteuractivite))) {
			Secteuractivite sup = entityManager.merge(Secteuractivite);
			entityManager.remove(sup);
		}
	}
    public Secteuractivite findById( int id) {
        logger.log(Level.INFO, "getting Secteuractivite instance with id: " + id);
        try {
            Secteuractivite instance = entityManager.find(Secteuractivite.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

