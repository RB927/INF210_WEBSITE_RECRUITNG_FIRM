package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Jan 16, 2023, 3:12:29 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
/**
 * Home object for domain model class Candidature.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature
 * @author Hibernate Tools
 */
 import eu.telecom_bretagne.cabinet_recrutement.data.model.Candidature;

@Stateless
public class CandidatureDAO{

    private static final Logger logger = Logger.getLogger(CandidatureDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    

    public Candidature findById( int id) {
        logger.log(Level.INFO, "getting Candidature instance with id: " + id);
        try {
            Candidature instance = entityManager.find(Candidature.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
    public Candidature persist(Candidature Candidature) {
		if (Candidature != null) {
			entityManager.persist(Candidature);
		}
		return Candidature;
	}

	public Candidature update(Candidature Candidature) {
		if (Candidature != null) {
			entityManager.merge(Candidature);
		}
		return Candidature;
	}

	public void remove(Candidature Candidature) {
		if ((Candidature != null) & (!entityManager.contains(Candidature))) {
			Candidature sup = entityManager.merge(Candidature);
			entityManager.remove(sup);
		}
	}
}

