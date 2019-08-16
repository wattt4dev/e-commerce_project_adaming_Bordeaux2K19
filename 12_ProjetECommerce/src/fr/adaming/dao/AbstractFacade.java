package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractFacade<T> {
	
	//1. D�claration de l'entit�
	private Class<T> entity;
	
	//2. Constructeur pour initialiser l'entity
		/**
		 * Initialise la propri�t� entity
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
		
		//4.D�claration des m�thodes communes � toute entit�
		
		/**
		 * Permet d'ajouter une entit�
		 * @param t
		 */
		
		
		public void add(T t){
			sf.getCurrentSession().save(t);		
		}

}
