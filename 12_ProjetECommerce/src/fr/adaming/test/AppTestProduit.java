package fr.adaming.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.dao.ProduitFacade;
import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Produit;
import fr.adaming.service.IAdminCategorieService;

import fr.adaming.service.IAdminProduitMetier;
import fr.adaming.service.IInternauteBoutique;

public class AppTestProduit {

	public static void main(String[] args) {

		// 1. Instanciation du conteneur IoC de Spring
		ApplicationContext conteneurSpring = new ClassPathXmlApplicationContext("applicationContextTest.xml");

		// 2. recup du bean de la couche service a partir du conteneur

		IAdminCategorieService produitService =  (IAdminCategorieService) conteneurSpring.getBean("boutiqueServiceImpl");

	// ============== Méthodes d'AbstractFacade
		// =======================================//

		// 3. Ajout de produits dans la bdd via le service
		// ---------------------------------------------------------------------------------------
		// 3.1. produit a ajouter

		//Produit p1 = new Produit("Tata", "Tutu", 45, 4, false, "Pipo");
		//.setPhoto("chat.jpg");
		// 3.2. invocation du service pour l'ajout
		//produitService.addProduitService(p1);
//
		Produit p1 = new Produit("Harry Potter à l'école des Sorciers", "blabla hp 1", 8.7, 10, true, "hp1.jpg");
		Produit p2 = new Produit("Harry Potter et la chambre des Secrets", "blabla hp 2", 8.7, 10, true, "hp2.jpg");
//////		// 3.2. invocation du service pour l'ajout
		produitService.addProduitService(p1);
		produitService.addProduitService(p2);
		
		
		
		// -----------------------------------------------------------------------------------------


		// 4. Get produit par Id
		// ------------------------------------------------------------------------------------------
		//System.out.println(" ");
		//System.out.println("------------------------ GET Produit BY ID ------------------------------------");
		//System.out.println("\t - " + produitService.findProduitByIdService((long) 1).getPrix() + " "
		//		+ produitService.findProduitByIdService((long) 1).getDescription());

		// 5. Modification d'un produit
		// ------------------------------------------------------------------------------------------
//		System.out.println(" ");
//		System.out.println("------------------------ UPDATE Produit------------------------------------");
//		Produit p = produitService.findProduitByIdService((long) 4);
//		System.out.println("\t - Before Update : " + p.getDescription());
//		p.setDescription("C'est un test");
//		System.out.println(p.getDescription());
//		produitService.updateProduitService(p);
//		System.out.println("\t - After Update : " + produitService.findProduitByIdService((long) 4).getDescription());

		// 6. Suppression d'un produit
		// ------------------------------------------------------------------------------------------
		// produitService.deleteProduitService((long) 1);

		// ============== Méthodes propres à produit
		// =======================================//

		// 7. get all produits
//		 ------------------------------------------------------------------------------------------
//		// 4. Get produit par Id
//		// ------------------------------------------------------------------------------------------
//		//System.out.println(" ");
//		//System.out.println("------------------------ GET Produit BY ID ------------------------------------");
//		//System.out.println("\t - " + produitService.findProduitByIdService((long) 1).getPrix() + " "
//		//		+ produitService.findProduitByIdService((long) 1).getDescription());
//
//		// 5. Modification d'un produit
//		// ------------------------------------------------------------------------------------------
////		System.out.println(" ");
////		System.out.println("------------------------ UPDATE Produit------------------------------------");
////		Produit p = produitService.findProduitByIdService((long) 4);
////		System.out.println("\t - Before Update : " + p.getDescription());
////		p.setDescription("C'est un test");
////		System.out.println(p.getDescription());
////		produitService.updateProduitService(p);
////		System.out.println("\t - After Update : " + produitService.findProduitByIdService((long) 4).getDescription());
//
//		// 6. Suppression d'un produit
//		// ------------------------------------------------------------------------------------------
//		 produitService.deleteProduitService((long) 1);
//
//		// ============== Méthodes propres à produit
//		// =======================================//
//
//		// 7. get all produits
////		 ------------------------------------------------------------------------------------------
////		 System.out.println(" ");
////		 System.out.println("------------------------ GET ALL Produits------------------------------------");
////		 for (Produit produit : produitService.getAllProduitService()) {
////		
////		 System.out.println("\t - " + produit.getPrix() + " " +
////		 produit.getDescription());
////		 }
//
//		// 8. get all produits par mot clé
//		// ------------------------------------------------------------------------------------------
//		 System.out.println(" ");
//		 System.out.println("------------------------ GET ALL Produits Par Mot Clé------------------------------------");
//		 for (Produit produit : produitService.getAllProduitByMotCleService("Titi")) {
//		
//		 System.out.println(
//		 "\t - " + " " + produit.getDesignation() + produit.getPrix() + " " +
//		 produit.getDescription());
//		 }
//
//		// 9. get all produits par Catégorie
//		// ------------------------------------------------------------------------------------------
//		 System.out.println(" ");
//		 System.out.println("------------------------ GET ALL Produits Par Catégorie------------------------------------");
//		 for (Produit produit : produitService.getAllProduitByCategorieService((long) 3)) {
//		
//		 System.out.println(
//		 "\t - " + " " + produit.getDesignation() + produit.getPrix() + " " +
//		 produit.getDescription());
//		 }
//
//		// 10. get all produits Sélectionnés
//		// ------------------------------------------------------------------------------------------
//		 System.out.println(" ");
//		 System.out.println("------------------------ GET ALL Produits Par Catégorie------------------------------------");
//		 for (Produit produit : produitService.getAllProduitSelection()) {
//		
//		 System.out.println(
//		 "\t - " + " " + produit.getDesignation() + produit.getPrix() + " " +
//		 produit.getDescription());
//		 }
//
		
		//-----------------------------------
		//    Testligne commande et panier
		//-----------------------------------
		
		
		Produit p = produitService.findProduitByIdService((long)2);
		System.out.println("produit p " +p);
		LigneCommande lp=new LigneCommande();
		lp.setProduit(p);
		lp.setIdP(p.getIdProduit());
		lp.setPrix(p.getPrix());
		lp.setQuantite(1);
//		
//		
		int v=produitService.addLigneCommandeService(lp);
		System.out.println(v);
//		
		
		LigneCommande lp2=produitService.getLigneCommandeService(1);
		lp2.setQuantite(3);
		produitService.updateLigneCommandeService(lp2);
		
		
		

//		
	}// end main

}// end classe
