package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef chef;
	private Gaulois vendeur;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlAcheterProduit controlAcheterProduit;
	
	@BeforeEach
	public void initialiser() {
		village = new Village("Les vendeurs", 3, 2);
		chef = new Chef("Vendix", 780, village);
		village.setChef(chef);
		vendeur = new Gaulois("Le vendeur fou", 23);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "banane", 49);
		Gaulois acheteur = new Gaulois("Acheteur", 6);
		village.ajouterHabitant(acheteur);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}
	
	
	@Test
	void testControlAcheterProduit() {
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit);
	}
	

	@Test
	void testAfficherVendeur() {
		String expected = "1 - Le vendeur fou\n";
		assertEquals(expected,controlAcheterProduit.afficherVendeur("banane"));
		assertEquals("Pas de personnes qui vendent ce produit",controlAcheterProduit.afficherVendeur("pomme"));
	}

	@Test
	void testEstVendeur() {
		assertTrue(controlAcheterProduit.estVendeur("Le vendeur fou"));
		assertFalse(controlAcheterProduit.estVendeur("PasVendeur"));
	}

	@Test
	void testAppartientVillage() {
		assertTrue(controlAcheterProduit.appartientVillage("Le vendeur fou"));
		assertFalse(controlAcheterProduit.appartientVillage("Non"));
	}

	@Test
	void testGetVendeur() {
		assertEquals("Le vendeur fou",controlAcheterProduit.getVendeur(1, "banane"));
		assertNotEquals("Le vendeur fou",controlAcheterProduit.getVendeur(1, "polle"));
	}

	@Test
	void testExisteProduit() {
		assertTrue(controlAcheterProduit.existeProduit("banane"));
		assertFalse(controlAcheterProduit.existeProduit("polle"));
	}

	@Test
	void testGetNbProduitsEtalVendeur() {
		assertEquals(49,controlAcheterProduit.getNbProduitsEtalVendeur("Le vendeur fou"));
		
	}

	@Test
	void testAcheterProduit() {
		assertEquals(2,controlAcheterProduit.acheterProduit("Le vendeur fou", "banane", 2));
		assertNotEquals(50,controlAcheterProduit.acheterProduit("Le vendeur fou", "banane", 50));
		assertEquals(0,controlAcheterProduit.acheterProduit("Le vendeur fou", "banane", 5));
	}

}
