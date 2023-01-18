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
    
    public Offreemploi persist(Offreemploi Offreemploi) {
		if (Offreemploi != null) {
			entityManager.persist(Offreemploi);
		}
		return Offreemploi;
	}

	public Offreemploi update(Offreemploi Offreemploi) {
		if (Offreemploi != null) {
			entityManager.merge(Offreemploi);
		}
		return Offreemploi;
	}

	public void remove(Offreemploi Offreemploi) {
		if ((Offreemploi != null) & (!entityManager.contains(Offreemploi))) {
			Offreemploi sup = entityManager.merge(Offreemploi);
			entityManager.remove(sup);
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

