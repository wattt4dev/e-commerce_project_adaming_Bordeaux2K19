package fr.adaming.test;

import org.omg.CORBA.PRIVATE_MEMBER;

import fr.adaming.entity.Categorie;
import fr.adaming.service.BoutiqueServiceImpl;
import fr.adaming.service.IAdminCategorieService;

public class AppTestCategorie {
	
	public static void main(String[] args) {
		
		//=============================================================================================
		//===================== Test des m�thodes Cat�gorie � partir de Service =======================
		//=============================================================================================

			//D�claration du Service Categorie
		
		IAdminCategorieService categorieService = new BoutiqueServiceImpl();
		
			//Ajouter une cat�gorie
		byte[] photo = {15,12,14};
		Categorie categorie = new Categorie("Appareil Photo", photo, "Appareil Photo num�rique");
		categorieService.ajouterCategorie(categorie);
		
		
		
	}//end main

}//end class
