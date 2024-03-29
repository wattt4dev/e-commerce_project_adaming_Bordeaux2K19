package fr.adaming.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Role;
import fr.adaming.entity.User;
import fr.adaming.service.IAdminCategorieService;

public class AppTestCategorie {
	
	public static void main(String[] args) {
		
		//=============================================================================================
		//===================== Test des m�thodes Cat�gorie � partir de Service =======================
		//=============================================================================================

			//Cr�ation du conteneur Spring
		ApplicationContext conteneurSpring = new ClassPathXmlApplicationContext("applicationContextTest.xml");
		
			//R�cup�ration du bean Service de Cat�gorie
		IAdminCategorieService categorieService = (IAdminCategorieService) conteneurSpring.getBean("boutiqueServiceImpl");
		
			//================================================================================
			//=========================Ajout d'une nouvelle cat�gorie=========================
			//================================================================================
		
				//Instanciation d'un objet de type Categorie
		Categorie categorie = new Categorie("Livres", "La lecture quelle aventure");
		Categorie categorie2 = new Categorie("Jeux", "Allez!! Juste une partie");
		Categorie categorie3 = new Categorie("CD", "Allez!! Danse Danse !!!");

		
				//Ajout de l'objet dans la DataBase
		categorieService.ajouterCategorie(categorie);
		categorieService.ajouterCategorie(categorie2);

		categorieService.ajouterCategorie(categorie3);

//		categorieService.ajouterCategorie(categorie2);
//		categorieService.ajouterCategorie(categorie2);


//		categorieService.ajouterCategorie(categorie2);
//		categorieService.ajouterCategorie(categorie2);

//		categorieService.ajouterCategorie(categorie2);
//		categorieService.ajouterCategorie(categorie2);
//		categorieService.ajouterCategorie(categorie2);
//		
			
			//================================================================================
			//==========================Modification d'une cat�gorie==========================
			//================================================================================
		
//		Categorie categorie3 = categorieService.getCategorieById((long) 1);
//		categorie3.setNomCategorie("Appareil Photo Reflexe");
//		categorieService.modifierCategorie(categorie3);
//		
		
			//================================================================================
			//==========================Suppression d'une cat�gorie===========================
			//================================================================================
		
//		categorieService.supprimerCategorie((long) 3);
//		categorieService.supprimerCategorie((long) 4);
//		categorieService.supprimerCategorie((long) 5);
//		categorieService.supprimerCategorie((long) 6);
//			
		
			//================================================================================
			//==========================R�cup�ration d'une cat�gorie==========================
			//================================================================================
//		
//		Categorie categorie4 = categorieService.getCategorieById((long) 1);
//		System.out.println("\n\t ===================== Get Categorie By Id =====================");
//		System.out.println("\t\t - "+categorie4);
//		System.out.println("\t ===============================================================");
//		
//		
//			//================================================================================
//			//=======================R�cup�ration Liste d'une cat�gorie=======================
//			//================================================================================
//		
//		List<Categorie> categories = categorieService.getAllCategorie();
//		System.out.println("\n\t ===================== Get All Categorie =====================");
//		for (Categorie categorieOut : categories) {
//			System.out.println("\t\t - "+categorieOut);
//		}
//		System.out.println("\t =============================================================");
//		
//			//================================================================================
//			//========================Ajouter un User via ajouterUser=========================
//			//================================================================================
//		
		User user1 = new User("admincat", "admincat", true);
		categorieService.ajouterUser(user1);
		User user2 = new User("adminprod", "adminprod", true);
		categorieService.ajouterUser(user2);
		User user3 = new User("client", "client", true);
		categorieService.ajouterUser(user3);
		
//			//================================================================================
//			//========================AttribuerRole via attribuerRole=========================
//			//================================================================================
//		
		Role roleCat = new Role("ROLE_ADMINCAT");
		Role roleProd = new Role("ROLE_ADMINPROD");
		Role roleClient = new Role("ROLE_CLIENT");
		categorieService.attribuerRole(roleCat, (long) 1);
		categorieService.attribuerRole(roleProd, (long) 2);
		categorieService.attribuerRole(roleClient, (long) 3); 
//		
		
	}//end main

}//end class
