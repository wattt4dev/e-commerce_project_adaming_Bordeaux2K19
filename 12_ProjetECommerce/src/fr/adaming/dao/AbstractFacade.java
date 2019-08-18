package fr.adaming.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
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
		
		//attribut de dao
		@Autowired	
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
		
		@Transactional
		public void add(T t){
			sf.getCurrentSession().save(t);		
		}

		@Transactional
		public void update(T t) {
			sf.getCurrentSession().update(t);
		}
		
		@Transactional
		public void delete(int id) {
			T t = sf.getCurrentSession().get(entity, id);
			sf.getCurrentSession().delete(t);
		}	
		
		@Transactional(readOnly=true)
		public T findById(int id){			
			return sf.getCurrentSession().get(entity, id);
		}

// Vu que dans cette m�thode il y a une requ�te sql, je pense qu'il faut la mettre direct dans l'impl�mentation		
//		@Transactional(readOnly=true)
//		public List<T> getAll(){
//			return sf.getCurrentSession().createQuery("FROM T").getResultList();			
//			
//		}
}
