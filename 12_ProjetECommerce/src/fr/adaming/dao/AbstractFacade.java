package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractFacade<T> {
	
	//1. Déclaration de l'entité
	private Class<T> entity;
	
	//2. Constructeur pour initialiser l'entity
		/**
		 * Initialise la propriété entity
		 * @param entity
		 */
		public AbstractFacade(Class<T> entity) {
			super();
			this.entity = entity;
		}
		
		//attirbut de dao
		
		private SessionFactory sf;
		
		//getters et setters
		public SessionFactory getSf() {
			return sf;
		}

		public void setSf(SessionFactory sf) {
			this.sf= sf;
		}
		
		//4.Déclaration des méthodes communes à toute entité
		
		/**
		 * Permet d'ajouter une entité
		 * @param t
		 */
		
		
		public void add(T t){
			sf.getCurrentSession().save(t);		
		}

}
