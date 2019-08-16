package fr.adaming.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="role")
@Table(name="roles")
public class Role {

	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	private String roleName;
	
	//Associations
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="idUser")
	private User user;
	
	
	//Constructeurs
		//Constructeur vide
	public Role() {
		super();
	}
		//Constructeurs chargés
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	public Role(Long idRole, String roleName) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
	}
	
	//Getters et setters
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", roleName=" + roleName + "]";
	}
	
}
