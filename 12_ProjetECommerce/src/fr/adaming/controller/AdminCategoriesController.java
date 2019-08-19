package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	
	
	
	

}//end class
