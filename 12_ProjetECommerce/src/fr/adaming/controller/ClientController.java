package fr.adaming.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entity.Client;
import fr.adaming.service.IAdminCategorieService;

@Controller
public class ClientController {

	
	@Autowired
	private IAdminCategorieService iacs;

	// Getter et setter du Bean IAdminCategorieService pour accès Spring
	public IAdminCategorieService getIacs() {
		return iacs;
	}// end getter

	public void setIacs(IAdminCategorieService iacs) {
		this.iacs = iacs;
	}// end setter
	
	

	
	@RequestMapping(value="/client/welcomeClient")
	public ModelAndView accueilClient() {
		
		
		
		
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		return new ModelAndView("accueilClient", data);
		
		
		
	}
	
	
	
	@RequestMapping(value="addClient", method=RequestMethod.GET)
	public ModelAndView ajouterClientForm() {
		
		Map<String, Object> data = new HashMap<>();
		
		Client client = new Client();
		
		data.put("clientCommand", client);
		
		ModelAndView modelAndView = new ModelAndView("loginClient", data);
		return modelAndView; 
	}
	
	@RequestMapping(value="addClient/add", method=RequestMethod.POST)
	public String ajouterClientBDD(@ModelAttribute("clientCommand") Client pClient, ModelMap modelDonnees) {
		iacs.addClientService(pClient);
		return "redirect:/accueilBoutique";
	}
	

	
	
	
}
