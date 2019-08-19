package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.adaming.service.IInternauteBoutique;

/**
 *  implementation d'un controleur spring mvc pour le produit
 * @author IN-BR-009
 *
 */

@Controller
public class InternauteBoutiqueController {

	@Autowired
	private IInternauteBoutique ib;

	//Getters et setters pour injection Spring
	public IInternauteBoutique getIb() {
		return ib;
	}

	public void setIb(IInternauteBoutique ib) {
		this.ib = ib;
	}
	
	
	
	
	
}
