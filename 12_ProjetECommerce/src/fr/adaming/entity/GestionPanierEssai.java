package fr.adaming.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class GestionPanierEssai {

	@Autowired
	private Panier panier=new Panier();
	
	public GestionPanierEssai() {
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Panier getPanier() {
		return panier;
	}

//	public void ajouterAuPanier(LigneCommande lc) {
//		Map<Long, LigneCommande> monPanier=panier.getPanier();
//		System.out.println(monPanier);
//		monPanier.put(lc.getProduit().getIdProduit(), lc);
//	}
//	
//	public void modifierQuantite (Produit produit, int quantite) {
//		Map<Long, LigneCommande> monPanier=panier.getPanier();
//		LigneCommande lc=monPanier.get(produit.getIdProduit());
//		lc.setQuantité(quantite);
//		lc.setPrix(produit.getPrix()*quantite);
//		monPanier.replace(lc.getProduit().getIdProduit(), lc);					
//	}
	
//
//	public void retirerDuPanier(long idProduit) {
//		Map<Long, LigneCommande> monPanier=panier.getPanier();
//		monPanier.remove(idProduit);
//	}
//	
//	public double total() {
//		Map<Long, LigneCommande> monPanier=panier.getPanier();
//		double total=0;
//		
//		for (LigneCommande lc : monPanier.values()) {
//			total=total+lc.getPrix();
//		}
//		return total;
//	}
//	
//	public Collection<LigneCommande> afficherPanier(){
//		Map<Long, LigneCommande> monPanier=panier.getPanier();
//		return monPanier.values();
//	}
//	
//	public LigneCommande afficherLigne(Produit produit) {
//		Map<Long, LigneCommande> monPanier=panier.getPanier();
//		LigneCommande lc=monPanier.get(produit.getIdProduit());
//		return lc;
//	}
//	
//	
//	public Map<Long, LigneCommande> panierIsExist() {
//		Map<Long, LigneCommande> monPanier=panier.getPanier();
//		if (monPanier==null) {
//			monPanier= new HashMap<Long, LigneCommande>();
//		}
//		return monPanier;
//	}
}
