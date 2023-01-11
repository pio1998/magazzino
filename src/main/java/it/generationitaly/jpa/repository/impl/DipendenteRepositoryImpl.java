package it.generationitaly.jpa.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.generationitaly.jpa.entity.Dipendente;
import it.generationitaly.jpa.repository.DipendenteRepository;

public class DipendenteRepositoryImpl implements DipendenteRepository  {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	
	@Override
	public Dipendente findByCodiceFiscale(String codiceFiscale) {
		Dipendente dipendente = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Dipendente> q = em.createQuery("FROM Dipendente d WHERE d.codiceFiscale=:codiceFiscale", Dipendente.class); // decido io l'ordine
			q.setParameter("codiceFiscale", codiceFiscale);
			dipendente=q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return dipendente;
	}

	@Override
	public List<Dipendente> findByMansione(String mansione) {
		List<Dipendente> dipendenti = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Dipendente> q = em.createQuery("FROM Dipendente d WHERE d.mansione=:mansione", Dipendente.class); // decido io l'ordine
			q.setParameter("mansione", mansione);
			dipendenti=q.getResultList();
			tx.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return dipendenti;
	}

	@Override
	public List<Dipendente> findByStipendioEta(int min, int max, int eta) {
		List<Dipendente> dipendenti = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Dipendente> q = em.createQuery("FROM Dipendente d WHERE (d.stipendio BETWEEN :min AND :max) AND d.eta>:eta ", Dipendente.class); // decido io l'ordine
			q.setParameter("min", min);
			q.setParameter("max", max);
			q.setParameter("eta", eta);
			dipendenti=q.getResultList();
			tx.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return dipendenti;
	}

}
