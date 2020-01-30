/**
 * 
 */
package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Klasse som definerer spillet
 * 
 * @author Vilde Kristine Fossum
 *
 */
public class Stigespillet {
	private List<Spiller> spillere = new ArrayList<Spiller>();
	private boolean ferdig;
	private Terning terning;
	private Brett brett;
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * @param spillere
	 * @param ferdig
	 */
	public Stigespillet() {
		this.brett = new Brett();
		this.ferdig = false;
		this.terning = new Terning();
	}
	
	/**
	 * Metode som starter spillet
	 */
	public void startSpill() {
		opprettSpillere();
		while(ferdig == false) {
			spillRunde();
		}
	}
	
	private void sluttSpill() {
		
	}

	/**
	 * Metode som utf�rer en runde
	 */
	private void spillRunde() {
		for(int i = 0; i < spillere.size(); i++) {
			spillere.get(i).spillTrekk(terning);
		}
	}
	
	private void opprettSpillere() {
		System.out.println("Hvor mange spillere skal v�re med?");
		int antall = scanner.nextInt();
		for(int i=1; i <= antall; i++) {
			System.out.println("Oppgi navn p� spiller "+i);
			scanner.nextLine();
			String navn = scanner.nextLine();
			System.out.println("Oppgi nummer p� fargen til spiller "+i);
			System.out.println("1: Bl�, 2: Gr�nn, 3: Gul, 4: R�d");
			int svar = scanner.nextInt();
			Farge farge = null;
			switch(svar){
				case 1: farge = Farge.BL�;
				case 2: farge = Farge.GR�NN;
				case 3: farge = Farge.GUL;
				case 4: farge = Farge.R�D;
			}
			Spiller spiller = new Spiller(navn, farge, brett);
			spillere.add(spiller);
		}
		
	}
}
