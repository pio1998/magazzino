package it.generationitaly.jpa.repository;

import java.util.List;

import it.generationitaly.jpa.entity.Dipendente;

public interface DipendenteRepository {

	Dipendente findByCodiceFiscale(String codiceFiscale);
	List<Dipendente> findByMansione(String mansione);
	List<Dipendente> findByStipendioEta(int min, int max, int eta);
}
