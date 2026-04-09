package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Chef chef;
	
	
	@BeforeEach
	public void initialiser() {
		village = new Village("Les vendeurs", 2, 10);
		chef = new Chef("Vendix", 780, village);
		village.setChef(chef);
		Gaulois vendeur = new Gaulois("Le vendeur fou", 23);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "banane", 49);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}
	@Test
	void testControlTrouverEtalVendeur() {
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur);
	}

	@Test
	void testTrouverEtalVendeur() {
		Etal etal = new Etal();
		
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Le vendeur fou"));
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("L'acheteur fou"));

	}

}
