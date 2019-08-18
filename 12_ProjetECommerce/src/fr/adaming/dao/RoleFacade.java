package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.entity.Role;

public class RoleFacade extends AbstractFacade<Role> {

	// Déclaration d'une SessionFactory
	@Autowired
	private SessionFactory sf;

	// Getter et setter de la SessionFactory
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public RoleFacade() {
		super(Role.class);
	}

}
