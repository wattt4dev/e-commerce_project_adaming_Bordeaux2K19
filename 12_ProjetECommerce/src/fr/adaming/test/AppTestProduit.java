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

	// ============== M�thodes d'AbstractFacade
		// =======================================//

		// 3. Ajout de produits dans la bdd via le service
		// ---------------------------------------------------------------------------------------
		// 3.1. produit a ajouter

		//Produit p1 = new Produit("Tata", "Tutu", 45, 4, false, "Pipo");
		//.setPhoto("chat.jpg");
		// 3.2. invocation du service pour l'ajout
		//produitService.addProduitService(p1);
//
		Produit p1 = new Produit("Harry Potter � l'�cole des Sorciers", "Le jour de ses onze ans, Harry Potter, un orphelin �lev� par un oncle et une tante qui le d�testent, voit son existence boulevers�e. Un g�ant nomm� Hagrid,vient le chercher pour l'emmener � Poudlard, une �cole de sorcellerie ! Voler en balai, jeter des sorts, combattre les trolls : Harry se r�v�le un sorcier dou�. Mais quel est le myst�re qui l'entoure ? Et qui est l'effroyable V..., le mage dont personne n'ose prononcer le nom ? \r\n" + 
				"\r\n" + 
				"Amiti�, surprises, dangers, sc�nes comiques, Harry d�couvre ses pouvoirs et la vie � Poudlard. Le premier tome des aventures du jeune h�ros vous ensorcelle aussit�t !\r\n" + 
				"\r\n" + 
				"Harry Potter � l'�cole des sorciers a obtenu le prix Sorci�res du roman 1999 et le prix Tam-Tam du livre de jeunesse 1999, cat�gorie Je Bouquine...", 8.7, 10, true, "hp1.jpg");
		Produit p2 = new Produit("Harry Potter et la chambre des Secrets", "Une rentr�e fracassante en voiture volante, une �trange mal�diction qui s'abat sur les �l�ves, cette deuxi�me ann�e � l'�cole des sorciers ne s'annonce pas de tout repos ! Entre les cours de potions magiques, les matches de Quidditch et les combats de mauvais sorts, Harry Potter trouvera-t-il le temps de percer le myst�re de la Chambre des Secrets ? Un livre magique pour sorciers confirm�s.", 8.7, 10, true, "hp2.jpg");
		Produit p3 = new Produit("Harry Potter et le prisonier d'Azkaban", "Sirius Black, le dangereux criminel qui s�est �chapp� de la forteresse d�Azkaban, recherche Harry Potter. C�est donc sous bonne garde que l�apprenti sorcier fait sa troisi�me rentr�e. Au programme : des cours de divination, la fabrication d�une potion de ratatinage, le dressage des hippogriffes� Mais Harry est-il vraiment � l�abri du danger qui le menace ? Un livre �poustouflant qui vous emportera dans un tourbillon de surprises et d��motions !", 8.7, 10, true, "hp3.jpg");

		Produit cd1 = new Produit("The Beatles", "Imagine all the people ",11 , 10, true, "beatles.jpg");
		Produit cd2 = new Produit("Mago de Oz", "Cuando despiertes un dia y sientas que no puedes mas",12, 10, true, "mago.jpg");
		Produit cd3 = new Produit("Joaquin Sabina", "blabla hp 2", 10, 10, true, "js.jpg");

		
		Produit j1 = new Produit("Trivial Pursuit", "Une tr�s large vari�t� de questions est disponible pour le jeu. Chaque couleur correspond � un th�me � par exemple dans le jeu ordinaire � Genus � � celles en vert sont sur la � vie et nature �. Il y a des versions pour les plus jeunes, sur des p�riodes de l'Histoire, des univers de fiction ou beaucoup d'autres qui d�pendent de la culture notamment d'un pays.", 20, 10, true, "tp.jpg");
		Produit j2 = new Produit("UNO", "A l'origine des divorces", 5.2, 10, true, "uno.jpg");
		Produit j3 = new Produit("TriDomino", "Triplement amusant!", 15, 10, true, "dom.jpg");

		
		
//////		// 3.2. invocation du service pour l'ajout
		produitService.addProduitService(p1);
		
		
		
		// -----------------------------------------------------------------------------------------



	//	Produit p1 = new Produit("Harry Potter � l'�cole des Sorciers", "blabla hp 1", 8.7, 10, true, "hp1.jpg");
	//	Produit p2 = new Produit("Harry Potter et la chambre des Secrets", "blabla hp 2", 8.7, 10, true, "hp2.jpg");
////		// 3.2. invocation du service pour l'ajout
	//	produitService.addProduitService(p1);
	//	produitService.addProduitService(p2);


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

		// ============== M�thodes propres � produit
		// =======================================//

		// 7. get all produits
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
//		// ============== M�thodes propres � produit
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
//		// 8. get all produits par mot cl�
//		// ------------------------------------------------------------------------------------------
//		 System.out.println(" ");
//		 System.out.println("------------------------ GET ALL Produits Par Mot Cl�------------------------------------");
//		 for (Produit produit : produitService.getAllProduitByMotCleService("Titi")) {
//		
//		 System.out.println(
//		 "\t - " + " " + produit.getDesignation() + produit.getPrix() + " " +
//		 produit.getDescription());
//		 }
//
//		// 9. get all produits par Cat�gorie
//		// ------------------------------------------------------------------------------------------
//		 System.out.println(" ");
//		 System.out.println("------------------------ GET ALL Produits Par Cat�gorie------------------------------------");
//		 for (Produit produit : produitService.getAllProduitByCategorieService((long) 3)) {
//		
//		 System.out.println(
//		 "\t - " + " " + produit.getDesignation() + produit.getPrix() + " " +
//		 produit.getDescription());
//		 }
//
//		// 10. get all produits S�lectionn�s
//		// ------------------------------------------------------------------------------------------
//		 System.out.println(" ");
//		 System.out.println("------------------------ GET ALL Produits Par Cat�gorie------------------------------------");
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
