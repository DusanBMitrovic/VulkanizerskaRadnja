/**
 * 
 */
package gume;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dusan Mitrovic
 */
public class AutoGumaTest {

	private AutoGuma ag;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ag = new AutoGuma();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ag = null;
	}

	/**
	 * Test method for {@link gume.AutoGuma#setMarkaModel(java.lang.String)}.
	 */
	@Test
	public void testSetMarkaModel() {
		ag.setMarkaModel("Audi S5");

		assertEquals("Audi S5", ag.getMarkaModel());

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelNull() {
		ag.setMarkaModel(null);

	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetMarkaModelManjeOd3() {
		ag.setMarkaModel("");
	}

	/**
	 * Test method for {@link gume.AutoGuma#setPrecnik(int)}.
	 */
	@Test
	public void testSetPrecnik() {
		ag.setPrecnik(19);

		assertEquals(19, ag.getPrecnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrecnikManjiOd13() {
		ag.setPrecnik(10);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrecnikVeciOd22() {
		ag.setPrecnik(30);
	}

	/**
	 * Test method for {@link gume.AutoGuma#setSirina(int)}.
	 */
	@Test
	public void testSetSirina() {
		ag.setSirina(200);

		assertEquals(200, ag.getSirina());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSirinaManjiOd135() {
		ag.setSirina(20);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSirinaVeciOd355() {
		ag.setSirina(400);
	}

	/**
	 * Test method for {@link gume.AutoGuma#setVisina(int)}.
	 */
	@Test
	public void testSetVisina() {
		ag.setVisina(75);

		assertEquals(75, ag.getVisina());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVisinaManjaOd25() {
		ag.setVisina(15);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetVisinaVecaOd95() {
		ag.setVisina(150);
	}

	/**
	 * Test method for {@link gume.AutoGuma#toString()}.
	 */
	@Test
	public void testToString() {
		ag.setMarkaModel("Audi S5");
		ag.setPrecnik(20);
		ag.setSirina(200);
		ag.setVisina(75);

		assertEquals("AutoGuma [markaModel=Audi S5, precnik=20, sirina=200, visina=75]", ag.toString());
	}

	/**
	 * Test method for {@link gume.AutoGuma#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		ag.setMarkaModel("Audi S5");
		ag.setPrecnik(20);
		ag.setSirina(200);
		ag.setVisina(75);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Audi S5");
		ag2.setPrecnik(20);
		ag2.setSirina(200);
		ag2.setVisina(75);

		assertTrue(ag.equals(ag2));
	}

	@Test
	public void testEqualsObjectFalse() {
		ag.setMarkaModel("Audi S5");
		ag.setPrecnik(20);
		ag.setSirina(200);
		ag.setVisina(75);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Audi S4");
		ag2.setPrecnik(21);
		ag2.setSirina(250);
		ag2.setVisina(80);

		assertFalse(ag.equals(ag2));
	}

}
