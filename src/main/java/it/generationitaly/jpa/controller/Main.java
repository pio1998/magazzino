package it.generationitaly.jpa.controller;

import java.util.List;

import it.generationitaly.jpa.entity.Azienda;
import it.generationitaly.jpa.entity.Dipendente;
import it.generationitaly.jpa.repository.AziendaRepository;
import it.generationitaly.jpa.repository.DipendenteRepository;
import it.generationitaly.jpa.repository.impl.AziendaRepositoryImpl;
import it.generationitaly.jpa.repository.impl.DipendenteRepositoryImpl;

public class Main {
	private static DipendenteRepository dipendenteRepository = new DipendenteRepositoryImpl();
	private static AziendaRepository aziendaRepository = new AziendaRepositoryImpl();
	public static void main(String[] args) {
		//testFindByCodiceFiscale();
		// testFindByMansione();
		//testFindByStipendioEta();
		testFindbyPartitaIva();

	}
	//----------------------------------------------------------------------------------
	private static void testFindByCodiceFiscale() {

		Dipendente dipendente=dipendenteRepository.findByCodiceFiscale("cf1");
		System.out.println(dipendente);
	}
	//----------------------------------------------------------------------------------
	private static void testFindByMansione() {
		List<Dipendente> dipendenti=dipendenteRepository.findByMansione("impiegato");
		for (Dipendente dipendente : dipendenti) {
			System.out.println(dipendente);
		}	
	}
	//----------------------------------------------------------------------------------
	private static void testFindByStipendioEta() {
		List<Dipendente> dipendenti=dipendenteRepository.findByStipendioEta(2500,4000, 37);
		for (Dipendente dipendente : dipendenti) {
			System.out.println(dipendente);
		}	
	}
	//----------------------------------------------------------------------------------
		private static void testFindbyPartitaIva() {
			Azienda azienda=aziendaRepository.findbyPartitaIva("11000043");
				System.out.println(azienda);
				System.out.println(azienda.getIndirizzo());
				for (Dipendente dipendente : azienda.getDipendente()) {
					System.out.println(dipendente);
				}
		
		}
}

