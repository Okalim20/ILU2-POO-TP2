package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {

	private Gaulois gaulois;
	
	@BeforeEach
	public void initialisation() {
		gaulois = new Gaulois("Astérix", 5);
	}
	@Test
	void testToString() {
		assertEquals("Gaulois [nom=Astérix, force=5, effetPotion=1]",gaulois.toString());
	}

	@Test
	void testPrendreParole() {
		assertEquals("Le gaulois Astérix : ",gaulois.prendreParole());
	}

	@Test
	void testGaulois() {
		gaulois = new Gaulois("Astérix", 5);
		assertNotNull(gaulois);
	}

	@Test
	void testBoirePotion() {
		gaulois.boirePotion(5);
	}

}
