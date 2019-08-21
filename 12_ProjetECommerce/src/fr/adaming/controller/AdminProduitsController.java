package fr.adaming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Produit;
import fr.adaming.service.IAdminCategorieService;
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
	
	@Autowired
	private IAdminCategorieService iacs;

	// Getter et setter du Bean IAdminCategorieService pour accès Spring
	public IAdminCategorieService getIacs() {
		return iacs;
	}// end getter

	public void setIacs(IAdminCategorieService iacs) {
		this.iacs = iacs;
	}// end setter
	
	//==================================================================//
	//================Méthode permettant de lister les produits=========//
	//==================================================================//
	
	@RequestMapping(value = "/liste_produits", method = RequestMethod.GET)
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

		return "redirect:/liste_produits";
		
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
		Categorie categorie = new Categorie();
		List<Categorie> listeCategories = iapm.getAllCategorie();
		
		// 1.2 Association
		data.put("produitCommande",produit);
		data.put("categorieCommande",categorie);
		data.put("attribut_categories", listeCategories);
		
		// 2. nom logique de la vue
		String viewName = "ajouter_produit";
		
		// 3- renvoi
		return new ModelAndView(viewName, data);
		
	}
	
		
	//================================================================//
	//================Méthode permettant d'ajouter un produit=========//
	//================================================================//

	@RequestMapping(value = "/produit/add", method = RequestMethod.POST)
	public String addProduitBDD(@ModelAttribute("produitCommande") Produit pProduit,ModelMap modeleDonnees) {
		
		// 1 - Méthode
		Long idCat =pProduit.getIdCat();
		//Long idCat= pProduit.getCategorie().getIdCategorie();


		iapm.addProduit(pProduit, (long) idCat);
		//iapm.addProduitService(pProduit);
		List<Produit> listeProduits = iapm.getAllProduitService();
		
		modeleDonnees.addAttribute("att_listeProduits", listeProduits );
		
		return "redirect:/liste_produits";
	}//end addProduit


	
	
	
}//end controller
