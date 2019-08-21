package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Role;
import fr.adaming.entity.User;

@Repository
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
	
	//Méthodes propres à role
	
	@Transactional
	public void attributeRole(Role role) {
		sf.getCurrentSession();
		Role roleIn = findById(role.getIdRole());
		add(role);
	}
	
	@Transactional
	public List<Role> getAllRole(){
		return sf.getCurrentSession().createQuery("FROM role r").getResultList();
	}
	
	@Transactional
	public Role getRoleById (long idRole) {
		return findById(idRole);
	}

}
