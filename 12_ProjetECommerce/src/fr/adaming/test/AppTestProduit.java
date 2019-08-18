package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import fr.adaming.entity.Produit;
import fr.adaming.service.IProduitService;

public class AppTestProduit {

	public static void main(String[] args) {

		
		// 1. Instanciation du conteneur IoC de Spring
		ApplicationContext conteneurSpring = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2. recup du bean de la couche service a partir du conteneur
		IProduitService produitService = (IProduitService) conteneurSpring.getBean("produitService");
		
		
		// 5. get all produits
				// ------------------------------------------------------------------------------------------
				System.out.println(" ");
				System.out.println("------------------------ GET ALL Produits  ------------------------------------");
				for (Produit produit : produitService.getAllService()) {

					System.out.println("\t - " + produit.getPrix() + " " + produit.getDescription()));
				}
		
	}

}
