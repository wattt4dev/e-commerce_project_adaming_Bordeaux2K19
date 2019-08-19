package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	
	

}
