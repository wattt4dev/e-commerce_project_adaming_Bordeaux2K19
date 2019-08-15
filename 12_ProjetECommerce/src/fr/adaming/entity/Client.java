package fr.adaming.entity;

public class Client {
	
	private Long idClient;
	private String nomClient;
	private String adresse;
	private String mail;
	private String telephone;
	
	//Constructeurs
	
	public Client() {
		super();
	}
	public Client(String nomClient, String adresse, String mail, String telephone) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
	}
	public Client(Long idClient, String nomClient, String adresse, String mail, String telephone) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
	}
	
	//Getters et setters
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	//To String
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", adresse=" + adresse + ", mail=" + mail
				+ ", telephone=" + telephone + "]";
	}
	
	
	
	
	

}
