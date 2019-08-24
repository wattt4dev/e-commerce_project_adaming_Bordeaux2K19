package fr.adaming.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity(name="user")
@Table(name="users")
public class User {
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUser;
	private String userName;
	private String password;
	private boolean actived;
	

	//Constructeurs
		//Constructeur vide
	public User() {
		super();
	}
	
		//Constructeurs chargés
	public User(Long idUser, String userName, String password, boolean actived) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.actived = actived;
	}
	public User(String userName, String password, boolean actived) {
		super();
		this.userName = userName;
		this.password = password;
		this.actived = actived;
	}

	//Getters et setters
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	//ToString
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", actived=" + actived
				+ "]";
	}

}
