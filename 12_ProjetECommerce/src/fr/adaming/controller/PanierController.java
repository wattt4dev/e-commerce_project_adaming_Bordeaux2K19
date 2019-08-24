package fr.adaming.controller;

import java.util.Collection;
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

import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Panier;
import fr.adaming.entity.Produit;
import fr.adaming.service.BoutiqueServiceImpl;

@Controller
public class PanierController {

	
	private Map<Integer, LigneCommande> articles = new HashMap<Integer, LigneCommande>();

	

	/* _______________ Déclaration de la classe Service ________________ */

	
	@Autowired
	private BoutiqueServiceImpl panierService;

	

	//setter pour injection spring

	public void setPanierService(BoutiqueServiceImpl panierService) {
		this.panierService = panierService;
	}


	
	@RequestMapping(value = "/panier/liste", method = RequestMethod.GET)

	public String listePaniersBDD(ModelMap modelDonnees) {

		

		//Etape 1 : recupération de la liste des paniers depuis la BDD

		List<Panier> listePaniers = panierService.getAllPanierService();

		//Etape 2 : Encapsulation de la liste dans l'objet ModelMap
		modelDonnees.addAttribute("liste_paniers", listePaniers);

		//Etape 3 : Définition du nom logique de la vue
		String nomVue = "liste_des_paniers";

		return nomVue;


	}



	@RequestMapping(value = { "/panier/delete/{pPanierId}"}, method = RequestMethod.GET)

	public String deletePanierBDD(@PathVariable("pPanierId") int aPanierId,

			ModelMap modelDonnees) {
		

		//Etape 1 : suppression de la catégorie depuis la BDD

		panierService.deletePanierService(aPanierId);

		
		//Etape 2 : recup de la nouvelle liste de catégories et défintion du modèle de données

		List<Panier> listePanierBDD = panierService.getAllPanierService();

		modelDonnees.addAttribute("liste_paniers", listePanierBDD);


		// Etape 3 : Renvoi non logique + redirection

		return "accueil_internaute";

	}



	@RequestMapping(value = "/addPanier", method = RequestMethod.GET)

	private ModelAndView setUpFormulaireAjout() {

		
		//Etape 1 : création de l'objet à retourner pour les données

		Map<String, Object> data = new HashMap<String, Object>();

		Panier panier = new Panier();
	

		data.put("panierCommand", panier);
	

		// Etape 2 : création du nom logique vue + renvoi du ModelandView

		String nomVue = "ajouter_panier";

		
		return new ModelAndView(nomVue, data);



	}

	@RequestMapping(value="/panier/add", method=RequestMethod.POST)

	public String addPanierBDD(@ModelAttribute("panierCommand") Panier pPanier, ModelMap modeleDonnees) {

		

		panierService.addPanierService(pPanier);

		

		//redirection vers liste_panier

		modeleDonnees.addAttribute("liste_paniers", panierService.getAllPanierService());

		

		return "redirect:/panier/liste";

		

	}

	
	@RequestMapping(value="/panier/addProduit", method=RequestMethod.POST)

	public void addProduitPanier(Produit p, int quantite) {

		

		LigneCommande lc=articles.get(p.getIdProduit());
		

		if(lc==null) {
		

			LigneCommande lignC = new LigneCommande();

			lignC.setProduit(p);

			lignC.setQuantité(quantite);

			lignC.setPrix(p.getPrix());

			articles.put(p.getIdProduit(), lignC);

		

		}else {
		

			lc.setQuantité(lc.getQuantite() + quantite);

		}


	}

	
	//methode pour recuperer la liste des produits du panier

	@RequestMapping(value="/panier/getProduits", method=RequestMethod.GET)

	public Collection<LigneCommande> getProduitsPanier(){

		return articles.values();

	}

	

	//methode pour recuperer le nombre de produits dans le panier

		@RequestMapping(value="/panier/getNbreProduits", method=RequestMethod.GET)

		public int getSizePanier() {

			return articles.size();

		}

	//methode pour recuperer le prix total du panier

		@RequestMapping(value="/panier/getTotal", method=RequestMethod.GET)

		public double getTotal() {

			double total = 0;

			for(LigneCommande lp : articles.values()) {

				total += lp.getPrix()* lp.getQuantite();

			}

			return total;

		}
	
	//methode pour supprimer un produit d'un panier

		@RequestMapping(value="/panier/suppProduit", method=RequestMethod.GET)

		public void deleteProduitPanier(int idProduit) {

			articles.remove(idProduit);

		}

}
