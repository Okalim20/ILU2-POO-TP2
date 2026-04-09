package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private ControlAfficherMarche controlAfficherMarche;
	private Chef chef;
	
	
	@BeforeEach
	public void initialiser() {
		village = new Village("Les vendeurs", 3, 2);
		chef = new Chef("Vendix", 780, village);
		village.setChef(chef);
		Gaulois vendeur = new Gaulois("Le vendeur fou", 23);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "banane", 49);
		
		controlAfficherMarche = new ControlAfficherMarche(village);
	}
	@Test
	void testControlAfficherMarche() {
		controlAfficherMarche= new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche);
	}

	@Test
	void testDonnerInfosMarche() {
		String [] expected = village.donnerEtatMarche();
		assertArrayEquals(expected,controlAfficherMarche.donnerInfosMarche());
	}

}
