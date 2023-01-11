package it.generationitaly.jpa.repository;

import java.util.List;

import it.generationitaly.jpa.entity.Indirizzo;


public interface IndirizzoRepository {

	void save(Indirizzo indirizzo);
	
	void update(Indirizzo indirizzo);
	
	void delete(Indirizzo indirizzo);
	
	void deleteById(int id);
	
	Indirizzo findById(int id);
	
	List<Indirizzo> findAll();

}
