package fr.adaming.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.service.IAdminCategorieService;

@Controller
public class AdminCategoriesController {
	
	@Autowired
	private IAdminCategorieService iacs;

	//Getter et setter du Bean IAdminCategorieService pour accès Spring
	public IAdminCategorieService getIacs() {
		return iacs;
	}//end getter

	public void setIacs(IAdminCategorieService iacs) {
		this.iacs = iacs;
	}//end setter
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET) // permet d'associer la methode à une requete http en 'GET' (ca veut dire quand je vais envoyer une requete http en get c'est cette methode là qui va s'exécuter)
	public ModelAndView pageAccueilAdminCategorie() {
		//=======================================================//
		//=======construction de l'objet ModelAndView============//
		//=======================================================//
		
		//1. definir les données à retourner vers la vue (Model de l'objet ModelAndView)
		String titreHeader = "Bienvenue";
		String message = "Gestion des Catégories, Produits, Users et des Roles";
		Date toDay = new Date();
		
		//1.1 encapsulation des données dans une map de type string object
		Map<String,Object> data = new HashMap<>();
		data.put("attribut_titreHeader", titreHeader);
		data.put("attribut_message", message);
		data.put("attribut_date", toDay);
		
		//2. definition du nom logique de la vue (view de l'objet modelandview)
		String viewName= "accueil";
		System.out.println("definition nom logique");
		//3. construction de l'objet modelandview
		ModelAndView modelAndView = new ModelAndView(viewName, data);
		
		//4. renvoi de l'objet
		return modelAndView;
		
	}
	
	

}//end class
