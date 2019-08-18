package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.dao.ProduitFacade;
import fr.adaming.entity.Produit;
import fr.adaming.service.IProduitService;

public class AppTestProduit {

	public static void main(String[] args) {

		
		// 1. Instanciation du conteneur IoC de Spring
		ApplicationContext conteneurSpring = new ClassPathXmlApplicationContext("applicationContextTest.xml");

		// 2. recup du bean de la couche service a partir du conteneur
		IProduitService produitService = (IProduitService) conteneurSpring.getBean("produitServiceImpl");
		//ProduitFacade pf = (ProduitFacade) conteneurSpring.getBean("produitFacade");
		
		// 3. Ajout de produits dans la bdd via le service
		// ---------------------------------------------------------------------------------------

		// 3.1. emplyés a ajouter

		Produit p1 = new Produit("Toto", "Titi", 45, 4, true, "Pipo");
		System.out.println(p1.getPrix());
		// 3.2. invocation du service pour l'ajout
		produitService.addService(p1);
		
//		// 5. get all produits
//				// ------------------------------------------------------------------------------------------
//				System.out.println(" ");
//				System.out.println("------------------------ GET ALL Produits  ------------------------------------");
//				for (Produit produit : produitService.getAllService()) {
//
//					System.out.println("\t - " + produit.getPrix() + " " + produit.getDescription());
//				}
		
	}

}
