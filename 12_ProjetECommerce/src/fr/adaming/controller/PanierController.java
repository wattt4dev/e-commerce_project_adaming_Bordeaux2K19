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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.Client;
import fr.adaming.entity.Commande;
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

	// setter pour injection spring

	public void setPanierService(BoutiqueServiceImpl panierService) {
		this.panierService = panierService;
	}

	// ---------------------------------------------------------------------------
	// Methode de gestion des lignes de commandes
	// ---------------------------------------------------------------------------
	// ajouter un article au panier (panier intermédiaire)
	@RequestMapping(value = "/panier/addProduit/{pIdProduit}", method = RequestMethod.GET)
	public ModelAndView addProduitPanier(@PathVariable("pIdProduit") long idProduit) {
		Map<String, Object> data = new HashMap<>();

		Produit p = panierService.findProduitByIdService(idProduit);

		LigneCommande lignC = new LigneCommande();
		lignC.setProduit(panierService.findProduitByIdService(idProduit));
		lignC.setQuantité(1);
		lignC.setIdP(idProduit);
		lignC.setPrix(panierService.findProduitByIdService(idProduit).getPrix());

		List<LigneCommande> listeLC = panierService.getAllLigneCommandeService();

		List<Categorie> listeCategorie = panierService.getAllCategorie();
		data.put("listeCategorie", listeCategorie);
		data.put("produit", p);
		data.put("ligneCommande", lignC);

		return new ModelAndView("ligneCommande", data);
	}

	// confirmer l 'ajout d'un article au panier avec quantite
	@RequestMapping(value = "/panier/ajouterPanier", method = RequestMethod.POST)
	public ModelAndView ajouterPanier(@ModelAttribute("ligneCommande") LigneCommande lc) {
		Map<String, Object> data = new HashMap<>();

		List<Panier> listePan = panierService.getAllPanierService();
		Panier pan = null;
		if (listePan.isEmpty()) {
			pan = new Panier();
			panierService.addPanierService(pan);
		} else {
			pan = listePan.get(listePan.size() - 1);
		}

		Produit p = panierService.findProduitByIdService(lc.getIdP());
		lc.setProduit(p);
		lc.setPanier(pan);
		System.out.println("ligne commande dans ajouterPanier" + lc);

		panierService.addLigneCommandeService(lc);

		List<LigneCommande> panier = panierService.getAllLigneCommandeService();
		pan.setListeLC(panier);
		panierService.updatePanierService(pan);

		data.put("panier", panier);
		double total = 0;
		for (LigneCommande ligne : panier) {
			total = total + ligne.getPrix();
		}
		data.put("total", total);
		data.put("pan", pan);

		return new ModelAndView("panier", data);
	}

	// methode pour recuperer la liste des produits du panier
	@RequestMapping(value = "/panier/getProduits", method = RequestMethod.GET)
	public ModelAndView getProduitsPanier() {
		Map<String, Object> data = new HashMap<>();

		List<Panier> listePan = panierService.getAllPanierService();
		Panier pan=null;
		double total = 0.0;

		if (listePan.isEmpty()) {
			List<LigneCommande> panier=null;
			data.put("panier", panier);
			
		} else {
			List<LigneCommande> panier = panierService.getAllLigneCommandeService();
			pan = listePan.get(listePan.size() - 1);
			data.put("panier", panier);

			for (LigneCommande ligne : panier) {
				total = total + ligne.getPrix();
			}
		}
		data.put("total", total);
		data.put("pan", pan);

		return new ModelAndView("panier", data);

	}

	// methode pour recuperer le nombre de produits dans le panier

	@RequestMapping(value = "/panier/getNbreProduits", method = RequestMethod.GET)
	public int getSizePanier() {
		Map<String, Object> data = new HashMap<>();
		List<LigneCommande> panier = panierService.getAllLigneCommandeService();
		data.put("panier_attribut", panier);
		int nbArticles = 0;
		for (LigneCommande lc : panier) {
			nbArticles = nbArticles + lc.getQuantite();
		}

		return nbArticles;

	}

	// methode pour recuperer le prix total du panier

	@RequestMapping(value = "/panier/getTotal", method = RequestMethod.GET)
	public double getTotal() {

		List<LigneCommande> listeLC = panierService.getAllLigneCommandeService();

		double total = 0;

		for (LigneCommande lp : listeLC) {

			total += lp.getPrix() * lp.getQuantite();

		}

		return total;

	}

	// methode pour supprimer un produit d'un panier

	@RequestMapping(value = "/panier/suppProduit/{idLigneCommande}", method = RequestMethod.GET)
	public String deleteProduitPanier(@PathVariable("idLigneCommande") int idL, ModelMap modeleDonnees) {

		List<Panier> listePan = panierService.getAllPanierService();
		Panier pan = listePan.get(listePan.size() - 1);
		pan.setListeLC(null);
		panierService.updatePanierService(pan);

		LigneCommande lc = panierService.getLigneCommandeService(idL);
		lc.setProduit(null);
		lc.setPanier(null);
		panierService.updateLigneCommandeService(lc);
		panierService.deleteLigneCommandeService(idL);

		List<LigneCommande> panier = panierService.getAllLigneCommandeService();
		for (LigneCommande l : panier) {
			System.out.println(l.getIdLigneCommande() + " : " + l.getProduit().getDesignation());
		}
		pan.setListeLC(panier);
		panierService.updatePanierService(pan);

		modeleDonnees.put("panier_attribut", panier);
		modeleDonnees.put("pan", pan);
		double total = 0;
		for (LigneCommande ligne : panier) {
			total = total + ligne.getPrix();
		}
		modeleDonnees.put("total", total);

		return "redirect:/panier/getProduits";
	}

	@RequestMapping(value = "/panier/suppProduit1/{idLigneCommande}", method = RequestMethod.GET)
	public String deleteProduitAccueilPanier(@PathVariable("idLigneCommande") int idL, ModelMap modeleDonnees) {
		Map<String, Object> data = new HashMap<>();

		List<Panier> listePan = panierService.getAllPanierService();
		Panier pan = listePan.get(listePan.size() - 1);
		pan.setListeLC(null);
		panierService.updatePanierService(pan);

		LigneCommande lc = panierService.getLigneCommandeService(idL);
		lc.setProduit(null);
		panierService.updateLigneCommandeService(lc);
		panierService.deleteLigneCommandeService(idL);

		List<LigneCommande> panier = panierService.getAllLigneCommandeService();
		pan.setListeLC(panier);
		panierService.updatePanierService(pan);

		data.put("panier_attribut", panier);
		double total = 0;
		for (LigneCommande ligne : panier) {
			total = total + ligne.getPrix();
		}
		data.put("total", total);
		data.put("pan", pan);

		return "redirect:/accueilBoutique";
	}

	// ---------------------------------------------------------------------------
	// Methode de gestion des commandes
	// ---------------------------------------------------------------------------

	@RequestMapping(value = "/panier/addCommande/{panId}", method = RequestMethod.GET)
	public ModelAndView setUpFormulaireAjout(@PathVariable("panId") int panId) {

		Panier pan = panierService.getPanierService(panId);
		List<LigneCommande> listeLC = pan.getListeLC();

		// Etape 1 : création de l'objet à retourner pour les données
		double total=0.0;
		for (LigneCommande lc : listeLC) {
			total=total+lc.getPrix();
		}

		Map<String, Object> data = new HashMap<String, Object>();
		 Commande commande= new Commande();
		 commande.setListeLigneCommande(listeLC);
		 commande.setTotal(total);
		// commande.setDateCommande(dateCommande);
		 panierService.addCommandeService(commande);
		
		 data.put("commande", commande);
		
		 Client client=new Client();

		 data.put("clientCommande", client);
		
		
		 // Etape 2 : création du nom logique vue + renvoi du ModelandView

		String nomVue = "confirmerCommande";

		return new ModelAndView(nomVue, data);

	}
	
	
	
	//-------------------------------------------
	//      Méthodes pour la commande
	//-------------------------------------------
	
	
	
	
	
	
	

}
