package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;
	
	
	@BeforeEach
	public void initialiser() {
		System.out.println("Initialisation...");
		village = new Village("Le village des Irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		
	}
	
	@Test
	void testControlEmmenager() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertNotNull(controlEmmenager,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsHabitant() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		assertTrue(controlEmmenager.isHabitant("Bonemine"));
		assertFalse(controlEmmenager.isHabitant("Existe pas"));
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
	}

	@Test
	void testAjouterDruide() {
		Village village1place = new Village("1 place", 1, 1);
		village1place.setChef(abraracourcix);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village1place);
		
		controlEmmenager.ajouterDruide("Panoramix", 10, 1, 5);
		assertTrue(controlEmmenager.isHabitant("Panoramix"));
		assertFalse(controlEmmenager.isHabitant("Existe panonplus"));
		controlEmmenager.ajouterDruide("Panodeux", 10, 1, 5);
		assertFalse(controlEmmenager.isHabitant("Panodeux"));
	
	}

	@Test
	void testAjouterGaulois() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Pourtoutix", 30);
		assertTrue(controlEmmenager.isHabitant("Pourtoutix"));
	}

}
