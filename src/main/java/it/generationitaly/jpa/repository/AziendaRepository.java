package it.generationitaly.jpa.repository;

import it.generationitaly.jpa.entity.Azienda;

public interface AziendaRepository {
Azienda findbyPartitaIva(String partitaIva);
}
