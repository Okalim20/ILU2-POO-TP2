package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ChefTest {
	private Chef chef;
	private Village village;
	
	@BeforeEach
	public void initialisation() {
		village = new Village("A", 5, 5);
		chef = new Chef("Chef", 5, village);
	}
	
	@Test
	void testParler() {
		chef.parler("texte");

	}

	@Test
	void testPrendreParole() {
		assertEquals("Le chef Chef du village A : ",chef.prendreParole());
	}

	@Test
	void testChef() {
		assertNotNull(chef);
	}

}
