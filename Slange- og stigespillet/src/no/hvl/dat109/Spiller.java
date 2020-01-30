package no.hvl.dat109;

import java.util.Scanner;

/**
 * Klasse som definerer spilleren
 * 
 * @author Vilde Kristine Fossum
 *
 */
public class Spiller {
	private String navn;
	private Brikke brikke;
	private Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * @param navn
	 * @param brikke
	 */
	public Spiller(String navn, Farge farge, Brett brett) {
		this.navn = navn;
		this.brikke = new Brikke(brett, farge);
	}



	public void spillTrekk(Terning terning) {
		System.out.println("Det er " + navn + " sin tur");
		System.out.println("Trykk enter for � kaste terningen");
		if(scanner.hasNextLine()) {
			terning.trill();
			int verdi = terning.getVerdi();
			System.out.println("Du fikk: " + verdi);
			brikke.flytt(verdi);
			System.out.println("Du er n� p� rute: "+brikke.getRute().getRuteNr());
			scanner.nextLine();
		}
		
		
		
	}


}
