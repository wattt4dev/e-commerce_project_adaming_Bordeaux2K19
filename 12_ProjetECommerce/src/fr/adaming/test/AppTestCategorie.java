package fr.adaming.test;

import org.omg.CORBA.PRIVATE_MEMBER;

import fr.adaming.entity.Categorie;
import fr.adaming.service.BoutiqueServiceImpl;
import fr.adaming.service.ICategorieService;

public class AppTestCategorie {
	
	public static void main(String[] args) {
		
		//=============================================================================================
		//===================== Test des méthodes Catégorie à partir de Service =======================
		//=============================================================================================

			//Déclaration du Service Categorie
		
		ICategorieService categorieService = new BoutiqueServiceImpl();
		
			//Ajouter une catégorie
		byte[] photo = {15,12,14};
		Categorie categorie = new Categorie();
		categorieService.ajouterCategorie(categorie);
		
			//Récupérer une catégorie
		Categorie categorie2 = categorieService.getCategorieById(1);
		System.out.println(categorie2);
		
		
	}//end main

}//end class
