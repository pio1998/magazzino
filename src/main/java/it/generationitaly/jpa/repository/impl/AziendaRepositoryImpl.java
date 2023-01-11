package it.generationitaly.jpa.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.generationitaly.jpa.entity.Azienda;
import it.generationitaly.jpa.entity.Dipendente;
import it.generationitaly.jpa.repository.AziendaRepository;

public class AziendaRepositoryImpl implements AziendaRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	
	@Override
	public Azienda findbyPartitaIva(String partitaIva) {
		Azienda azienda = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Azienda> q = em.createQuery("FROM Azienda a WHERE a.partitaIva=:partitaIva", Azienda.class); // decido io l'ordine
			q.setParameter("partitaIva", partitaIva);
			azienda=q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return azienda;
	}

}
