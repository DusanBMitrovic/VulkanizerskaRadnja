/**
 * 
 */
package gume.radnja;
import java.util.*;
import gume.AutoGuma;
import gume.radnja.VulkanizerskaRadnja;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dusan Mitrovic
 *
 */
public class VulkanizerskaRadnjaTest {

	private VulkanizerskaRadnja vr;
	private AutoGuma ag;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vr = new VulkanizerskaRadnja();

		ag = new AutoGuma();
		ag.setMarkaModel("BMW 330");
		ag.setPrecnik(15);
		ag.setSirina(190);
		ag.setVisina(70);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		vr = null;
		ag = null;
	}

	/**
	 * Test method for {@link gume.radnja.VulkanizerskaRadnja#dodajGumu(gume.AutoGuma)}.
	 */
	@Test
	public void testDodajGumu() {
		vr.dodajGumu(ag);
		assertEquals(1, vr.gume.size());
	}

	@Test
	public void testDodajGumu2() {
		vr.dodajGumu(ag);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Honda");
		ag2.setPrecnik(18);
		ag2.setSirina(190);
		ag2.setVisina(60);
		vr.dodajGumu(ag2);

		assertEquals(2, vr.gume.size());
	}
	
	@Test(expected = java.lang.NullPointerException.class)
	public void testDodajGumuNull() {
		vr.dodajGumu(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testDodajGumuKojaJeUListi() {
		vr.dodajGumu(ag);
		vr.dodajGumu(ag);
	}
	
	
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testPronadjiGumuNull() {
		vr.pronadjiGumu(null);
	}
	
	@Test
	public void testPronadjiGumuKojaNePostoji() {
		vr.dodajGumu(ag);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Honda");
		ag2.setPrecnik(17);
		ag2.setSirina(190);
		ag2.setVisina(60);

		vr.dodajGumu(ag2);

		LinkedList<AutoGuma> nova = vr.pronadjiGumu("Skoda");

		assertEquals(0, nova.size());
	}
	
	@Test
	public void testPronadjiGumuIsteMarkeModelaRazlicitihDimenzija() {
		vr.dodajGumu(ag);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Honda");
		ag2.setPrecnik(17);
		ag2.setSirina(190);
		ag2.setVisina(60);

		AutoGuma ag3 = new AutoGuma();
		ag3.setMarkaModel("BMW 330");
		ag3.setPrecnik(18);
		ag3.setSirina(180);
		ag3.setVisina(90);

		vr.dodajGumu(ag2);
		vr.dodajGumu(ag3);

		LinkedList<AutoGuma> nova = vr.pronadjiGumu("BMW 330");

		assertEquals(2, nova.size());

	}
}
