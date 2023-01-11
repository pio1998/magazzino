package it.generationitaly.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "indirizzo")
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "citta", length = 45, nullable = false)
	private String citta;

	@Column(name = "via", length = 45, nullable = false)
	private String via;

	@Column(name = "numero_civico", length = 8, nullable = false)
	private String numeroCivico;

	@Column(name = "cap", length = 5, nullable = false)
	private String cap;

	@Column(name = "provincia", length = 2, nullable = false)
	private String provincia;
	
	@OneToOne(mappedBy = "indirizzo")
	private Azienda azienda;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Azienda getAzienda() {
		return azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", citta=" + citta + ", via=" + via + ", numeroCivico=" + numeroCivico + ", cap="
				+ cap + ", provincia=" + provincia + "]";
	}

}
