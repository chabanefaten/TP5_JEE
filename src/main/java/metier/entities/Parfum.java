package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "PARFUMS")
public class Parfum implements Serializable{
	@Id
	@Column (name="ID_PARFUM")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idParfum;
	@Column (name="NOM_PARFUM")
	private String nomParfum;
	private double prix;
	
	
	public Parfum() {
		super();
		}
	
	public Parfum(String nomParfum, double prix) {
		super();
		this.nomParfum = nomParfum;
		this.prix = prix;
	}
	public Long getIdParfum() {
		return idParfum;
	}
	public void setIdParfum(Long idParfum) {
		this.idParfum = idParfum;
	}
	public String getNomParfum() {
		return nomParfum;
	}
	public void setNomParfum(String nomParfum) {
		this.nomParfum = nomParfum;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Parfum [idParfum=" + idParfum + ", nomParfum=" + nomParfum + ", prix=" + prix + "]";
	}	
}
