/**
 * 
 */
package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Klasse som definerer spillet
 * 
 * @author Vilde Kristine Fossum
 *
 */
public class Stigespillet {
	private List<Spiller> spillere = new ArrayList<Spiller>();
	private Terning terning;
	private Brett brett;
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * @param spillere
	 * @param ferdig
	 */
	public Stigespillet() {
		this.brett = new Brett();
		this.terning = new Terning();
	}
	
	private boolean vunnet() {
		return spillere.stream().anyMatch(p -> p.getBrikke().getRute().getRuteNr() == 100);
	}
	/**
	 * Metode som starter spillet
	 */
	public void startSpill() {
		opprettSpillere();
		while(!vunnet()) {
			spillRunde();
		}
		sluttSpill();
	}
	
	private void sluttSpill() {
		String vinner = spillere.stream().filter(s -> s.getBrikke().getRute().getRuteNr() == 100)
										 .map(s -> s.getNavn())
										 .collect(Collectors.joining());
		System.out.println(vinner + ", du har vunnet spillet!");
		System.out.println("Spillet er n� ferdig");
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
