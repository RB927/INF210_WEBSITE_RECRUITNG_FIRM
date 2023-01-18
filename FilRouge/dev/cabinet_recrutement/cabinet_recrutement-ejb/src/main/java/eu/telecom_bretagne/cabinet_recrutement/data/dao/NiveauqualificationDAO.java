package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Jan 16, 2023, 3:12:29 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Home object for domain model class Niveauqualification.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification
 * @author Hibernate Tools
 */
import eu.telecom_bretagne.cabinet_recrutement.data.model.Niveauqualification;

@Stateless
public class NiveauqualificationDAO {

    private static final Logger logger = Logger.getLogger(NiveauqualificationDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
    public Niveauqualification persist(Niveauqualification Niveauqualification) {
		if (Niveauqualification != null) {
			entityManager.persist(Niveauqualification);
		}
		return Niveauqualification;
	}

	public Niveauqualification update(Niveauqualification Niveauqualification) {
		if (Niveauqualification != null) {
			entityManager.merge(Niveauqualification);
		}
		return Niveauqualification;
	}

	public void remove(Niveauqualification Niveauqualification) {
		if ((Niveauqualification != null) & (!entityManager.contains(Niveauqualification))) {
			Niveauqualification sup = entityManager.merge(Niveauqualification);
			entityManager.remove(sup);
		}
	}
    
    public Niveauqualification findById( int id) {
        logger.log(Level.INFO, "getting Niveauqualification instance with id: " + id);
        try {
            Niveauqualification instance = entityManager.find(Niveauqualification.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

