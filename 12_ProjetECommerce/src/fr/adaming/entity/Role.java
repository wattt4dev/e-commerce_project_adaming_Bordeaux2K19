package fr.adaming.entity;

public class Role {

	//Attributs
	private Long idRole;
	private String roleName;
	
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
