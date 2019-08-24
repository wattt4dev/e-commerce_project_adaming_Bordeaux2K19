package fr.adaming.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entity.Categorie;
import fr.adaming.entity.GestionPanierEssai;
import fr.adaming.entity.LigneCommande;
import fr.adaming.entity.Panier;
import fr.adaming.entity.Produit;
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
	
	@Autowired
	private GestionPanierEssai gp;

	//Getters et setters pour injection Spring
	public IInternauteBoutique getIb() {
		return ib;
	}

	public void setIb(IInternauteBoutique ib) {
		this.ib = ib;
	}
	


	@RequestMapping(value="/accueil/internaute", method=RequestMethod.GET)
	public ModelAndView accueillirInternaute () {
		System.out.println("je sus dans la methode accueillir internaute");
		//Construction de l'objet Model and view
		//1- définition des données a retourer dans la vue
		List<Categorie> listeCategorie=ib.getAllCategorie();
		List<Produit> produits=ib.getAllProduitService();
		
		for (Categorie cat:listeCategorie) {
			System.out.println(cat);
		}
		
		//1.1 Encapsulation dans une map
		Map<String, Object> data=new HashMap<>();
		data.put("listeCategorie", listeCategorie);
		data.put("listeProduits", produits);
		
		//2- définition de la vue logique 
		String viewName="accueilBoutique";
		
		//3- constrction de l'objet Model and View
		 ModelAndView modelAndViewAI = new ModelAndView(viewName, data);
		 return modelAndViewAI;
		
	}
	
	@RequestMapping(value="/recherche/catégorie/{pidCategorie}")
	public String rechercheCategorie(@PathVariable ("pidCategorie") long aidCategorie, ModelMap modeleDonnees) {
		//Construction de l'objet Model and view
		//1- définition des données a retourer dans la vue
		List<Produit> listeProduitCategorie=ib.getAllProduitByCategorieService(aidCategorie);
		
		//1.bis
		Categorie categorie=ib.getCategorieById(aidCategorie);
		
		//2- ajout au modele de donnees
		modeleDonnees.addAttribute("listeProduitCategorie", listeProduitCategorie);
		modeleDonnees.addAttribute("categorie", categorie);
		//3- renvoi du nom logique de la vue
		return "rechercheParCategorie";
		
	}
	
	
	@RequestMapping(value="/advancedresearch", method=RequestMethod.GET)
	public String rechercheMotCle(ModelMap data) {
		//Construction de l'objet Model and view
		//1- définition des données a retourer dans la vue

		
		//3- renvoi du nom logique de la vue
		return "rechercheAvancee";
		
	}
	
	
	@RequestMapping(value="/recherche*", method=RequestMethod.GET)
	public String rechercheMotCle(@RequestParam("mc") String motcle, ModelMap modeleDonnees) {
		//Construction de l'objet Model and view
		//1- définition des données a retourer dans la vue
		System.out.println("je suis dans la methode recherche par mot cle");
		List<Produit> listeProduitMotCle=ib.getAllProduitByMotCleService(motcle);
		
		
		//2- ajout au modele de donnees
		modeleDonnees.addAttribute("listeProduitMotCle", listeProduitMotCle);
		
		//3- renvoi du nom logique de la vue
		return "resultatRechercheMotCle";
	}
	
	
	@RequestMapping("/afficherArticle/{produitId}")
	public ModelAndView getProduit(@PathVariable ("produitId") long idProduit ) {
		Map<String, Object> modeleDonnees = new HashMap<>();
		Produit produitRecherche= ib.findProduitByIdService(idProduit);
		
		modeleDonnees.put("produit", produitRecherche);
		
	
		return new ModelAndView("afficherArticle", modeleDonnees);
	}
	
	public String getProduitSelectionnes() {
		return null;
	}
	
	
	

		
	
}
