package fr.adaming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entity.Produit;
import fr.adaming.service.IAdminProduitMetier;

/**
 *  implementation d'un controleur spring mvc pour le produit
 * @author IN-BR-009
 *
 */

@Controller
public class AdminProduitsController {
	
	@Autowired
	private IAdminProduitMetier iapm;

	//Getters et setters pour injection Spring
	public IAdminProduitMetier getIapm() {
		return iapm;
	}

	public void setIapm(IAdminProduitMetier iapm) {
		this.iapm = iapm;
	}
	
	//==================================================================//
	//================Méthode permettant de lister les produits=========//
	//==================================================================//
	
	@RequestMapping(value = "/produit/liste", method = RequestMethod.GET)
	public String listerProduitsBdd(ModelMap modeleDonnees) {
		
		//1 - récup des données de la bdd
		List<Produit> listeProduits = iapm.getAllProduitService();
		
		//2 - encapsulation dans le model map
		modeleDonnees.addAttribute("att_listeProduits", listeProduits );
		
		//3 - Nom logique de la vue
		String nomVue = "liste_produits";
		
		return nomVue;
	}
	
	//=====================================================================//
	//================Méthode permettant de supprimer les produits=========//
	//=====================================================================//

	@RequestMapping(value =  "/produit/delete/{pProduitId}", method = RequestMethod.GET)
public String deleteProduit(@PathVariable("pProduitId") Long aProduitId, ModelMap modeleDonnees) {
		
		iapm.deleteProduitService((long)aProduitId);
		
		List<Produit> listeProduits = iapm.getAllProduitService();
		
		modeleDonnees.addAttribute("att_listeProduits", listeProduits );

		return "liste_produits";
		
	}
	
	//=======================================================================//
	//================Méthode permettant  Affichage formulaire Ajout=========//
	//=======================================================================//
	
	@RequestMapping(value = "/addProduit", method = RequestMethod.GET)
	public ModelAndView setUpFormulaireAjout() {
		
		// 1 - definition des donnes a retourner vers la servlet
		Map<String, Object> data = new HashMap<>();
		
		// 1.1 définition des objets de commande (objet fonctionnaire vide)
		Produit produit = new Produit();
		
		// 1.2 Association
		data.put("produitCommande",produit);
		
		// 2. nom logique de la vue
		String viewName = "ajouter_produit";
		
		// 3- renvoi
		return new ModelAndView(viewName, data);
		
	}
	
		
	//================================================================//
	//================Méthode permettant d'ajouter un produit=========//
	//================================================================//

	@RequestMapping(value = "/produit/add", method = RequestMethod.POST)
	public String addProduitBDD(@ModelAttribute("produitCommande") Produit pProduit, ModelMap modeleDonnees) {
		
		// 1 - Méthode
		Long idCat= pProduit.getCategorie().getIdCategorie();
		//iapm.addProduit(pProduit, (long) idCat);
		iapm.addProduitService(pProduit);
		List<Produit> listeProduits = iapm.getAllProduitService();
		
		modeleDonnees.addAttribute("att_listeProduits", listeProduits );
		
		return "liste_produits";
	}//end addProduit

	
	
	
	
}//end controller
