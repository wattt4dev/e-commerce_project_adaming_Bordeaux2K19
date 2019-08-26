package fr.adaming.controller;

import java.util.ArrayList;
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

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;
import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Panier;
import fr.adaming.entity.Produit;
import fr.adaming.service.BoutiqueServiceImpl;

@Controller
public class PanierController {

	
	private Map<Long, LigneCommande> articles = new HashMap<Long, LigneCommande>();

	

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



	

	@RequestMapping(value="/panier/add", method=RequestMethod.POST)

	public String addPanierBDD(@ModelAttribute("panierCommand") Panier pPanier, ModelMap modeleDonnees) {
		panierService.addPanierService(pPanier);
		//redirection vers liste_panier

		modeleDonnees.addAttribute("liste_paniers", panierService.getAllPanierService());

		return "redirect:/panier/liste";

		

	}
	//---------------------------------------------------------------------------
	//ajouter un article au panier (panier intermédiaire)
		@RequestMapping(value="/panier/addProduit/{pIdProduit}", method=RequestMethod.GET)
		public ModelAndView addProduitPanier(@PathVariable("pIdProduit") long idProduit) {
			Map<String, Object> data = new HashMap<>();
			LigneCommande lignC=articles.get(idProduit);
			Produit p=panierService.findProduitByIdService(idProduit);
			if(lignC==null) {
			

				lignC = new LigneCommande();
				lignC.setProduit(panierService.findProduitByIdService(idProduit));
				lignC.setQuantité(1);
				lignC.setIdP(idProduit);
				lignC.setPrix(panierService.findProduitByIdService(idProduit).getPrix());
				
				articles.put(idProduit, lignC);

			}
			
			List<Categorie> listeCategorie=panierService.getAllCategorie();
			data.put("listeCategorie", listeCategorie);
			data.put("produit", p);
			data.put("ligneCommande", lignC);
			
			return new ModelAndView("ligneCommande", data);
		}
	
	//confirmer l 'ajout d'un article au panier avec quantite
	@RequestMapping(value="/panier/ajouterPanier", method=RequestMethod.POST)
	public ModelAndView ajouterPanier(@ModelAttribute("ligneCommande") LigneCommande lc) {
		Map<String, Object> data = new HashMap<>();
		
		Produit p=panierService.findProduitByIdService(lc.getIdP());
		lc.setProduit(p);
		System.out.println("ligne commande dans ajouterPanier" + lc);
		panierService.addLigneCommandeService(lc);
		
		List<LigneCommande> panier=panierService.getAllLigneCommandeService();
		data.put("panier_attribut", panier);
		double total=0;
		for (LigneCommande ligne : panier) {
			total=total+ligne.getPrix();
		}
		data.put("total", total);
		
		return new ModelAndView("panier", data);
	}

	

	
	//methode pour recuperer la liste des produits du panier
	@RequestMapping(value="/panier/getProduits", method=RequestMethod.GET)
	public ModelAndView getProduitsPanier(){
		Map<String, Object> data = new HashMap<>();
		
		List<LigneCommande> panier=panierService.getAllLigneCommandeService();
		data.put("panier_attribut", panier);
		double total=0;
		for (LigneCommande ligne : panier) {
			total=total+ligne.getPrix();
		}
		data.put("total", total);
	
		return new ModelAndView("panier", data);

	}

	

	//methode pour recuperer le nombre de produits dans le panier

		@RequestMapping(value="/panier/getNbreProduits", method=RequestMethod.GET)
		public int getSizePanier() {
			Map<String, Object> data = new HashMap<>();
			List<LigneCommande> panier=panierService.getAllLigneCommandeService();
			data.put("panier_attribut", panier);
			int nbArticles=0;
			for (LigneCommande lc: panier) {
				nbArticles=nbArticles+lc.getQuantite();
			}
			
			return nbArticles;

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

		@RequestMapping(value="/panier/suppProduit/{idLigneCommande}", method=RequestMethod.GET)
		public ModelAndView deleteProduitPanier(@PathVariable("idLigneCommande") int idL) {
			Map<String, Object> data = new HashMap<>();
			
			LigneCommande lc = panierService.getLigneCommandeService(idL);
			lc.setProduit(null);
			panierService.updateLigneCommandeService(lc);
			panierService.deleteLigneCommandeService(idL);
			
			List<LigneCommande> panier=panierService.getAllLigneCommandeService();
			data.put("panier_attribut", panier);
			double total=0;
			for (LigneCommande ligne : panier) {
				total=total+ligne.getPrix();
			}
			data.put("total", total);
		
			return new ModelAndView("panier", data);
		}
		
		
		@RequestMapping(value = "/addPanier/{panier_attribut}", method = RequestMethod.GET)

		private ModelAndView setUpFormulaireAjout(@PathVariable("panier_attribut") List<LigneCommande> listeLC) {

			
			//Etape 1 : création de l'objet à retourner pour les données
			for (LigneCommande lc: listeLC) {
				System.out.println(lc);
			}
			
			
			
			Map<String, Object> data = new HashMap<String, Object>();
			Panier panier=new Panier();
			panier.setPanier(listeLC);
			data.put("panierCommande", panier);
			
			double total=0;
			for (LigneCommande lc: listeLC) {
				total=total+lc.getPrix();
			}
			panier.setTotal(total);
			
			panierService.addPanierService(panier);
			
			
			Client client=new Client();
			data.put("clientCommande", client);
		

			// Etape 2 : création du nom logique vue + renvoi du ModelandView

			String nomVue = "confirmerCommande";

			
			return new ModelAndView(nomVue, data);



		}
		

}
