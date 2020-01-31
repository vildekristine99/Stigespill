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

	/**
	 * 
	 * @param terning
	 */
	public void spillTrekk(Terning terning) {
		System.out.println("Det er " + navn + " sin tur");
		System.out.println("Trykk enter for � kaste terningen");
		if(scanner.hasNextLine()) {
			terning.trill();
			Integer verdi = terning.getVerdi();
			if(verdi.equals(6)) {
				System.out.println("Du fikk: 6");
				brikke.flytt(verdi);
				System.out.println("Du er n� p� rute: "+brikke.getRute().getRuteNr());
				System.out.println("Trykk enter for � kaste igjen");
				scanner.nextLine();
				if(scanner.hasNextLine()) {
					terning.trill();
					verdi = terning.getVerdi();
					if(verdi.equals(6)) {
						brikke.startP�Nytt();
						System.out.println("Du fikk: "+verdi+ " og rykker tilbake til start");
						verdi = 0;
					}
				}
			}
			if(!verdi.equals(0)) {
				System.out.println("Du fikk: " + verdi);
				brikke.flytt(verdi);
			}
			System.out.println("Du er n� p� rute: "+brikke.getRute().getRuteNr());
			scanner.nextLine();
			
		}
		
		
		
	}


	/**
	 * @return the navn
	 */
	public String getNavn() {
		return navn;
	}



	/**
	 * @param navn the navn to set
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}



	/**
	 * @return the brikke
	 */
	public Brikke getBrikke() {
		return brikke;
	}



	/**
	 * @param brikke the brikke to set
	 */
	public void setBrikke(Brikke brikke) {
		this.brikke = brikke;
	}



	

}
