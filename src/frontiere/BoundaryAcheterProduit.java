package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		
		
		if(!controlAcheterProduit.appartientVillage(nomAcheteur)) {
			System.out.println("Je suis désolée "+nomAcheteur+" mais il faut être un habitant du village pour commercer ici");
		}
		else {
			
			
			StringBuilder question = new StringBuilder();
			question.append("Quel produit voulez-vous acheter ?");
			String produit = Clavier.entrerChaine(question.toString());
			if (controlAcheterProduit.existeProduit(produit)) {
				System.out.println("Désolé, personne ne vend ça sur le marché.");
			}
			else {
				
			
			System.out.println("Chez quel commerçant voulez-vous acheter des"+produit+" ?");
			String vendeur = controlAcheterProduit.afficherVendeur(produit);
			int choixVendeur = Clavier.entrerEntier(vendeur);
			String nomVendeur = controlAcheterProduit.getVendeur(choixVendeur, produit);
			
			System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+ nomVendeur);
			int nombreAchat= Clavier.entrerEntier("Combien de "+produit+" voulez vous acheter");
			
			int nbProduit = controlAcheterProduit.getNbProduitsEtalVendeur(nomVendeur);
			int transaction = controlAcheterProduit.acheterProduit(nomVendeur,produit,nombreAchat);

			if (transaction==0) {
				System.out.println(nomAcheteur+" veut acheter "+nombreAchat+" "+produit+", malheureusement, il n'y en a plus !");
			}
			else {
				
				if (nbProduit>=nombreAchat) {
					System.out.println(nomAcheteur+" achète "+transaction+ " "+ produit+ " à "+nomVendeur+".");
				}
				else {
					System.out.println(nomAcheteur+" veut acheter "+nombreAchat+" "+produit+", malheureusement, "+nomVendeur+" n'en a plus que "+transaction+". "+nomAcheteur+" achète tout le stock de "+nomVendeur+".");
				
				}
			}
			
			}
			
		}
	}
}
