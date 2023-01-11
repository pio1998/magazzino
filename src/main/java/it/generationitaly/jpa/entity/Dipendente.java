package it.generationitaly.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dipendente")
public class Dipendente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "matricola", length = 3, unique = true, nullable = false)
	private String matricola;

	@Column(name = "codice_fiscale", length = 16, unique = true, nullable = false)
	private String codiceFiscale;

	@Column(name = "nome", length = 45, nullable = false)
	private String nome;

	@Column(name = "cognome", length = 45, nullable = false)
	private String cognome;

	@Column(name = "mansione", length = 45, nullable = false)
	private String mansione;
	
	@Column(name = "stipendio", nullable = false)
	private int stipendio;
	
	@Column(name = "eta", nullable = false)
	private int eta;
	
	@ManyToOne
	@JoinColumn(name = "azienda_id", nullable = false)
	private Azienda azienda;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMansione() {
		return mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	@Override
	public String toString() {
		return "Dipendente [id=" + id + ", matricola=" + matricola + ", codiceFiscale=" + codiceFiscale + ", nome="
				+ nome + ", cognome=" + cognome + ", mansione=" + mansione + ", stipendio=" + stipendio + ", eta=" + eta
				+ "]";
	}

}
