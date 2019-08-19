package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.User;

@Repository
public class UserFacade extends AbstractFacade<User> {

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

	public UserFacade() {
		super(User.class);
	}

}
