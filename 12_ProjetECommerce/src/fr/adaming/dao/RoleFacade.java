package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Role;
import fr.adaming.entity.User;

@Repository
public class RoleFacade extends AbstractFacade<Role> {

	// D�claration d'une SessionFactory
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
	
	//M�thodes propres � role
	
	@Transactional
	public void attributeRole(Role role) {
		sf.getCurrentSession();
		Role roleIn = findById(role.getIdRole());
		add(role);
		
	}

}
