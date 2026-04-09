package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private Village village;
	private ControlAfficherVillage controlAfficherVillage;
	private Chef chef;
	private Gaulois habitant1;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	public void initialiser() {
		village = new Village("Le super village", 10, 3);
		chef = new Chef("Chef", 5, village);
		village.setChef(chef);
		controlEmmenager = new ControlEmmenager(village);
		for (int i = 0; i < 10; i++) {
			controlEmmenager.ajouterGaulois("Gaulois"+i, 4);
			
		}
		controlEmmenager.ajouterDruide("Druide", 5, 5, 7);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}
	@Test
	void testControlAfficherVillage() {
		controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		String [] expected = new String[11];
		expected = village.donnerVillageois();
		assertArrayEquals(expected,controlAfficherVillage.donnerNomsVillageois());
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("Le super village",controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(3,controlAfficherVillage.donnerNbEtals());
	}

}
