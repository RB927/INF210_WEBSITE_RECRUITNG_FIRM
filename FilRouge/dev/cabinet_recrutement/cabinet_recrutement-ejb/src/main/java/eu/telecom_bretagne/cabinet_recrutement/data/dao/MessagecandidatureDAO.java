package eu.telecom_bretagne.cabinet_recrutement.data.dao;
// Generated Jan 16, 2023, 3:12:29 PM by Hibernate Tools 5.4.20.Final


import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Home object for domain model class Messagecandidature.
 * @see eu.telecom_bretagne.cabinet_recrutement.data.model.Messagecandidature
 * @author Hibernate Tools
 */
  import eu.telecom_bretagne.cabinet_recrutement.data.model.Messagecandidature;

@Stateless
public class MessagecandidatureDAO {

    private static final Logger logger = Logger.getLogger(MessagecandidatureDAO.class.getName());

    @PersistenceContext private EntityManager entityManager;
    
 
    

    public Messagecandidature persist(Messagecandidature Messagecandidature) {
		if (Messagecandidature != null) {
			entityManager.persist(Messagecandidature);
		}
		return Messagecandidature;
	}

	public Messagecandidature update(Messagecandidature Messagecandidature) {
		if (Messagecandidature != null) {
			entityManager.merge(Messagecandidature);
		}
		return Messagecandidature;
	}

	public void remove(Messagecandidature Messagecandidature) {
		if ((Messagecandidature != null) & (!entityManager.contains(Messagecandidature))) {
			Messagecandidature sup = entityManager.merge(Messagecandidature);
			entityManager.remove(sup);
		}
	}
    
    public Messagecandidature findById( int id) {
        logger.log(Level.INFO, "getting Messagecandidature instance with id: " + id);
        try {
            Messagecandidature instance = entityManager.find(Messagecandidature.class, id);
            logger.log(Level.INFO, "get successful");
            return instance;
        }
        catch (RuntimeException re) {
            logger.log(Level.SEVERE, "get failed", re);
            throw re;
        }
    }
}

