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
		
		
	//==============    Méthodes d'AbstractFacade =======================================//	
		
		
		// 3. Ajout de produits dans la bdd via le service
		// ---------------------------------------------------------------------------------------
		// 3.1. produit a ajouter
		Produit p1 = new Produit("Toto", "Titi", 45, 4, true, "Pipo");		
		// 3.2. invocation du service pour l'ajout
		//produitService.addService(p1);
		//-----------------------------------------------------------------------------------------

		
		//4. Get produit par Id
		// ------------------------------------------------------------------------------------------
		System.out.println(" ");
		System.out.println("------------------------ GET Produit BY ID ------------------------------------");
		System.out.println("\t - " + produitService.findByIdService((long) 1).getPrix() + " "
				                   + produitService.findByIdService((long) 1).getDescription());

		
		//5. Modification d'un produit
		// ------------------------------------------------------------------------------------------
//				System.out.println(" ");
//				System.out.println("------------------------ UPDATE Produit  ------------------------------------");
//				Produit p = produitService.findByIdService((long) 4);
//				System.out.println("\t - Before Update : " + p.getDescription());
//				p.setDescription("C'est un test");
//				System.out.println(p.getDescription());
//				produitService.updateService(p);
//				System.out.println("\t - After Update : " + produitService.findByIdService((long) 4).getDescription());
		
		//6. Suppression d'un produit
		// ------------------------------------------------------------------------------------------
//				produitService.deleteService((long) 3);
				

		//==============    Méthodes propres à produit =======================================//			
		
		// 7. get all produits
		// ------------------------------------------------------------------------------------------
				System.out.println(" ");
				System.out.println("------------------------ GET ALL Produits  ------------------------------------");
				for (Produit produit : produitService.getAllService()) {

					System.out.println("\t - " + produit.getPrix() + " " + produit.getDescription());
				}
		
	}

}
