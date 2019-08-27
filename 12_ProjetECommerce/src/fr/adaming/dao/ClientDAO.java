package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entity.Client;

@Repository
public class ClientDAO extends AbstractFacade<Client>{

	// Déclaration d'une SessionFactory
		@Autowired
		private SessionFactory sf;
		
		// Getter et setter de la SessionFactory
		public SessionFactory getSf() {
			return sf;
		}

		public void setSf(SessionFactory sf) {
			this.sf= sf;
		}
	
	public ClientDAO(Class<Client> entity) {
		super(Client.class);
		// TODO Auto-generated constructor stub
	}

}
