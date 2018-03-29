package gume.radnja;

import java.util.LinkedList;


import gume.AutoGuma;

/**
 * Klasa koja predstavlja Vulkanizersku Radnja sa odgovarajucim metodama
 * @author Dusan Mitrovic
 * @version 1.0 Alpha
 *
 */
public class VulkanizerskaRadnja {

	/**
	 * Lista dostupnih auto guma u radnji
	 */
	public LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();

	/**
	 * Ubacuje novu auto gumu u ponudu radnje
	 * 
	 * @param AutoGuma a
	 *            nova guma koja se dodaje u vulkanizersku radnju
	 * @throws java.lang.NullPointerException
	 *             ako je uneta guma null
	 * @throws java.lang.RuntimeException
	 *             ako uneta guma vec postoji
	 */
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.addFirst(a);
	}

	/**
	 * Nalazi i vraca listu auto guma koje su dostupne za odredjenu marku i model
	 * 
	 * @param String markaModel
	 *            marka i model auto gume
	 * @return null ako je unet upit null, u suprotnom novu listu sa postojecim
	 *         gumama za upit
	 * @throws java.lang.RuntimeException
	 *             ako je uneti parametar markaModel null
	 */

	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			throw new RuntimeException("Marka i model ne smeju biti null.");
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).getMarkaModel().equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}

}