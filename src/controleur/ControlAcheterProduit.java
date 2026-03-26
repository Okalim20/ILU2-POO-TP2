package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	
	public String afficherVendeur(String produit) {
		StringBuilder vendeurs = new StringBuilder();
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
		for (int i = 0; i < gaulois.length; i++) {
			vendeurs.append(i+1);
			vendeurs.append(" - ");
			vendeurs.append(gaulois[i].getNom());
			vendeurs.append("\n");
		}
		
		return vendeurs.toString();
		
	}
	
	public boolean estVendeur(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	
	public boolean appartientVillage(String nom) {
		return village.trouverHabitant(nom)!=null;
	}
	
	public String getVendeur(int numero, String produit) {
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);

		return gaulois[numero-1].getNom();
		
	}
	
	public boolean existeProduit(String produit) {
		return village.rechercherVendeursProduit(produit)==null;
	}

	
	public int getNbProduitsEtalVendeur(String vendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		return etal.getQuantite();
	}
	public int acheterProduit(String nomVendeur, String produit,int nbAchat) {
		
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(nbAchat);
	}
}
