package fr.adaming.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entity.Client;
import fr.adaming.entity.Commande;

@Repository
public class ClientDao {
	
	
	@Autowired
	private SessionFactory sf;
	

	public SessionFactory getSf() {
		return sf;
	}


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	
	/*___________ Les méthodes ____________*/

	@Transactional
	public int addClientDao(Client client) {
		return (int) sf.getCurrentSession().save(client);
	}
	


	@Transactional
	public void updateClientDao(Client client) {
		sf.getCurrentSession().update(client);
	}
	

	@Transactional
	public void deleteClientDao(int pIdClient) {
		Client client = sf.getCurrentSession().get(Client.class, pIdClient);
		sf.getCurrentSession().delete(client);
	}


	@Transactional
	public Client getClientDao(long pIdClient) {
		return sf.getCurrentSession().get(Client.class, pIdClient);
	}



	@Transactional
	public List<Client> getAllClientDao() {

		return sf.getCurrentSession().createQuery("FROM client").getResultList();

	}


	
	
	
	
	

}
