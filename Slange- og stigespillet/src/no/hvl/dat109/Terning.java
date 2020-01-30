/**
 * 
 */
package no.hvl.dat109;

import java.util.Random;

/**
 * @author Vilde Kristine Fossum
 *
 */
public class Terning {
	private int verdi;
	private Random tall = new Random();
	
	/**
	 * Metode for å trille
	 */
	public void trill() {
		verdi = 1 + tall.nextInt(6);
	}
	
	public int getVerdi() {
		return this.verdi;
	}
	
}
