package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Categorie;
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

	
	//Méthode propre à User
	
	/**
	  * Méthode getAll User copié à partir de AbstractFacade
	  */
	
	@Transactional(readOnly=true)
	public List<User> getAllUser(){
		List<User> users = sf.getCurrentSession().createQuery("FROM user u").getResultList();
		return users;
	}
	
	
	
}
