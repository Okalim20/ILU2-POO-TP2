package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Chef chef;
	
	
	@BeforeEach
	public void initialiser() {
		village = new Village("Les vendeurs", 3, 2);
		chef = new Chef("Vendix", 780, village);
		village.setChef(chef);
		Gaulois vendeur = new Gaulois("Le vendeur fou", 23);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "banane", 49);
		
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}
	
	@Test
	void testControlPrendreEtal() {
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal);
	}

	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		Gaulois vendeur2 = new Gaulois("Le deuxième vendeur", 5);
		village.ajouterHabitant(vendeur2);
		village.installerVendeur(vendeur2, "pommes", 43);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		Gaulois vendeur2 = new Gaulois("Le vendeur 2", 5);
		village.ajouterHabitant(vendeur2);
		assertEquals(2, controlPrendreEtal.prendreEtal("Le vendeur 2", "pommes", 5));
		assertEquals(-1, controlPrendreEtal.prendreEtal("Le vendeur 3", "pommes", 5));

	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlPrendreEtal.verifierIdentite("Le vendeur fou"));
		assertFalse(controlPrendreEtal.verifierIdentite("Le vendeur kiexistepa"));	}

}
