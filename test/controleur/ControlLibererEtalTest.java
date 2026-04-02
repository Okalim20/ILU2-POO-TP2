package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	private Chef abraracourcix;
	@BeforeEach
	public void initialiser() {
		village = new Village("Les Réductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 1, village);
		village.setChef(abraracourcix);
		Gaulois vendix = new Gaulois("Vendix", 1);
		village.ajouterHabitant(vendix);
		village.installerVendeur(vendix, "fruix", 2);
		controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Le constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	
		assertTrue(controlLibererEtal.isVendeur("Vendix"));
		assertFalse(controlLibererEtal.isVendeur("Pasvendeur"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		String[] donnees = controlLibererEtal.libererEtal("Vendix");
		String[] donnesBonnes = {"true","Vendix","fruix","2","0"};
		assertEquals(donnesBonnes,donnees);
	}

}
