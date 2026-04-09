package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Chef chef;
	
	
	@BeforeEach
	public void initialiser() {
		village = new Village("Les vendeurs", 2, 10);
		chef = new Chef("Vendix", 780, village);
		village.setChef(chef);
		Gaulois vendeur = new Gaulois("Le vendeur fou", 23);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "banane", 49);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	
	
	@Test
	void testControlVerifierIdentite() {
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Le vendeur fou"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Le vendeur kiexistepa"));
	}

}
