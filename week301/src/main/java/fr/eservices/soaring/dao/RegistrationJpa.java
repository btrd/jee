package fr.eservices.soaring.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import fr.eservices.soaring.model.Pilote;
import fr.eservices.soaring.model.Repas;

public class RegistrationJpa implements RegistrationDao {
	EntityManager em;
	EntityManagerFactory emf;
	EntityTransaction tx;

	public RegistrationJpa() {
		emf = Persistence.createEntityManagerFactory("myApp");
		em = emf.createEntityManager();
		tx = em.getTransaction();		
	}

	public void close() {
		em.close();
		emf.close();
	}

	@Override
	public List<Pilote> findPilotsByName(String nom) {
		Root<Pilote> _pilote;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pilote> criteria = cb.createQuery(Pilote.class);
		ParameterExpression<String> param = cb.parameter(String.class);

		criteria
		.select( 
				_pilote = criteria.from(Pilote.class) 
				)
		.where(
				cb.equal(_pilote.get("nom"), param)
				);

		TypedQuery<Pilote> q = em.createQuery( criteria );
		q.setParameter(param, nom);
		return q.getResultList();
	}

	@Override
	public List<Pilote> findPilotsByRegion(int id_region) {
		TypedQuery<Pilote> q = em.createQuery("SELECT p FROM Pilote p WHERE region_id = :region_id", Pilote.class);
		q.setParameter("region_id", id_region);
		return q.getResultList();
	}

	@Override
	public List<Pilote> findPilotsByClub(int id_club) {
		TypedQuery<Pilote> q = em.createQuery("SELECT p FROM Pilote p WHERE club_id = :club_id", Pilote.class);
		q.setParameter("club_id", id_club);
		return q.getResultList();
	}

	@Override
	public List<Pilote> findPilotsBelow(Date currentDate, int age) {
		TypedQuery<Pilote> q = em.createQuery("SELECT p FROM Pilote p WHERE dateNaissance < :year", Pilote.class);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.YEAR, -age);
		Date year = cal.getTime();
		
		q.setParameter("year", year);
		return q.getResultList();
	}

	@Override
	public Map<Repas, Integer> getAvailableSeatsForLunch(Date day, String time) {
		// TODO Auto-generated method stub
		return null;
	}

}
