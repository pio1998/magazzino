package it.generationitaly.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "azienda")
public class Azienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome", length = 45, nullable = false)
	private String nome;
	
	@Column(name = "partita_iva", length = 45, nullable = false)
	private String partitaIva;

	@Column(name = "capitale_sociale", nullable = false)
	private int capitaleSociale;
	
	@OneToOne
	@JoinColumn(name = "indirizzo_id")
	private Indirizzo indirizzo;
	
	@OneToMany(mappedBy="azienda", fetch = FetchType.EAGER) 
	private List <Dipendente> dipendente= new ArrayList<Dipendente>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public int getCapitaleSociale() {
		return capitaleSociale;
	}

	public void setCapitaleSociale(int capitaleSociale) {
		this.capitaleSociale = capitaleSociale;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Dipendente> getDipendente() {
		return dipendente;
	}

	public void setDipendente(List<Dipendente> dipendente) {
		this.dipendente = dipendente;
	}

	@Override
	public String toString() {
		return "Azienda [id=" + id + ", nome=" + nome + ", partitaIva=" + partitaIva + ", capitaleSociale="
				+ capitaleSociale + "]";
	}
	
}
