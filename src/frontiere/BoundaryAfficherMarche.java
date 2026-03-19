package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length==0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		} else {
			StringBuilder message = new StringBuilder();
			System.out.println(nomAcheteur+", vous trouverez au marché :");
			String vendeur;
			String quantite;
			String produit;
			for (int i = 0; i < infosMarche.length;) {
				vendeur = infosMarche[i];
				i++;
				quantite = infosMarche[i];
				i++;
				produit = infosMarche[i];
				i++;
				message.append("- "+vendeur+" qui vend "+quantite+" "+produit);
			}
			System.out.println(message.toString());
		}
	}
}
