package fr.adaming.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Commande;
import fr.adaming.service.IAdminCategorieService;

@Controller
public class AdminCategoriesController {

	@Autowired
	private IAdminCategorieService iacs;

	// Getter et setter du Bean IAdminCategorieService pour accès Spring
	public IAdminCategorieService getIacs() {
		return iacs;
	}// end getter

	public void setIacs(IAdminCategorieService iacs) {
		this.iacs = iacs;
	}// end setter

	@RequestMapping(value = "/welcomeAdminCategorie", method = RequestMethod.GET) 
	public ModelAndView pageAccueilAdminCategorie() {
		// =======================================================//
		// =======construction de l'objet ModelAndView============//
		// =======================================================//

		// 1. definir les données à retourner vers la vue (Model de l'objet
		// ModelAndView)
		String titreHeader = "Bienvenue";
		String message = "Gestion des Catégories, Produits, Users et des Roles";
		Date toDay = new Date();
		List<Categorie> categories = iacs.getAllCategorie();

		// 1.1 encapsulation des données dans une map de type string object
		Map<String, Object> data = new HashMap<>();
		data.put("attribut_titreHeader", titreHeader);
		data.put("attribut_message", message);
		data.put("attribut_date", toDay);
		data.put("attribut_categories", categories);

		// 2. definition du nom logique de la vue (view de l'objet modelandview)
		String viewName = "accueilAdminCategorie";

		// 3. construction de l'objet modelandview
		ModelAndView modelAndView = new ModelAndView(viewName, data);

		// 4. renvoi de l'objet
		return modelAndView;

	}// end AccueilAdminCategorie

	// =========================================================================================================================================
	// =========================================================================================================================================
	// =========================================================================================================================================
	// =========================================================================================================================================
	// =========================================================================================================================================

	@RequestMapping(value = "adminCategorie/addCategorie", method = RequestMethod.GET)
	public ModelAndView addCategorieFormulaire() {

		// Données à retourner
		Map<String, Object> data = new HashMap<>();

		// Objet de commande à ajouter dans HashMap
		Categorie categorie = new Categorie();

		// Nom de l'objet ajouté à HashMap
		String objetDeCommandeCategorie = "categorieCommand";

		// Association Nom/Objet de Commande et ajout dans HashMap
		data.put(objetDeCommandeCategorie, categorie);

		// Nom logique de la vue (partie View du ModelAndView)
		String viewName = "ajouterCategorie";

		ModelAndView modelAndView = new ModelAndView(viewName, data);
		return modelAndView;
	}// end addCAtegorieFormulaire

	// =========================================================================================================================================
	// =========================================================================================================================================
	// =========================================================================================================================================
	// =========================================================================================================================================
	// =========================================================================================================================================

	@RequestMapping(value="/adminCategorie/categorie/add",method=RequestMethod.POST)
	public String ajouterCategorieBDD(@ModelAttribute("categorieCommand") Categorie pCategorie, ModelMap modelDonnees) {
		
		iacs.ajouterCategorie(pCategorie);
		
		modelDonnees.addAttribute("attribut_categories", iacs.getAllCategorie());
		
		return "redirect:/welcomeAdminCategorie";
	}
	
	
	
}// end class
