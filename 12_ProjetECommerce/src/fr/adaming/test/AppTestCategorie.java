package fr.adaming.test;

import org.omg.CORBA.PRIVATE_MEMBER;

import fr.adaming.entity.Categorie;
import fr.adaming.service.BoutiqueServiceImpl;
import fr.adaming.service.IAdminCategorieService;

public class AppTestCategorie {
	
	public static void main(String[] args) {
		
		//=============================================================================================
		//===================== Test des méthodes Catégorie à partir de Service =======================
		//=============================================================================================

			//Déclaration du Service Categorie
		
		IAdminCategorieService categorieService = new BoutiqueServiceImpl();
		
			//Ajouter une catégorie
		byte[] photo = {15,12,14};
		Categorie categorie = new Categorie("Appareil Photo", photo, "Appareil Photo numérique");
		categorieService.ajouterCategorie(categorie);
		
		
		
	}//end main

}//end class
