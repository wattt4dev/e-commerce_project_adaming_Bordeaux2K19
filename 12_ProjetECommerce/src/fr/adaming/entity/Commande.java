package fr.adaming.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="commande")
@Table(name="commandes")
public class Commande {
	
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCommande;
	private Date dateCommande;
	
	private double total;
	private boolean valider;
	
	//Associations
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="commande_id", referencedColumnName="idClient")
	private Client client;
	
	@OneToMany(mappedBy="commande", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<LigneCommande> listeLigneCommande;
	
	//Constructeur
	public Commande() {
		super();
	}

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	public Commande(Long idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	
	//Getters et Setters
	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isValider() {
		return valider;
	}

	public void setValider(boolean valider) {
		this.valider = valider;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}

	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}
	
	
	
	
	
	
	

}
