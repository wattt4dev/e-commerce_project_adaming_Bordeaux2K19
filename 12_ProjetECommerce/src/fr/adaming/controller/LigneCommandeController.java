package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entity.LigneCommande;
import fr.adaming.service.BoutiqueServiceImpl;

@Controller
public class LigneCommandeController {

	
	@Autowired
	BoutiqueServiceImpl cService;

	public void setcService(BoutiqueServiceImpl cService) {
		this.cService = cService;
	}
	

	

	@RequestMapping(value = "/ligne_c/liste", method = RequestMethod.GET)

	public String listeLignePaniersBDD(ModelMap modelDonnees) {

		

		//Etape 1 : recupération de la liste des lignes paniers depuis la BDD

		List<LigneCommande> listeLigneCommandes = cService.getAllLigneCommandeService();

		

		//Etape 2 : Encapsulation de la liste dans l'objet ModelMap

		modelDonnees.addAttribute("liste_ligneCommandes", listeLigneCommandes );

		

		//Etape 3 : Définition du nom logique de la vue

		String nomVue = "liste_ligneCommandes";



		return nomVue;

		
	}
	
	
	@RequestMapping(value = { "/ligne_c/delete/{pLigneCId}"}, method = RequestMethod.GET)

	public String deleteLignePanierBDD(@PathVariable("pLigneCId") int aLigneCId,

			ModelMap modelDonnees) {

		

		//Etape 1 : suppression de la lignepanier depuis la BDD

		cService.deleteLigneCommandeService(aLigneCId);
		

		//Etape 2 : recup de la nouvelle liste de ligne panier et défintion du modèle de données

		List<LigneCommande> listeLigneCBDD = cService.getAllLigneCommandeService();

		modelDonnees.addAttribute("liste_ligneC", listeLigneCBDD  );



		// Etape 3 : Renvoi non logique + redirection

		return "redirect:/ligne_c/liste";

	}

}
