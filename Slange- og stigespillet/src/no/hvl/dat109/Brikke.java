/**
 * 
 */
package no.hvl.dat109;

/**
 * @author Vilde Kristine Fossum
 *
 */
public class Brikke {
	private Rute rute;
	private Brett brett;
	private Farge farge;
	/**
	 * Lager en ny brikke
	 * 
	 * @param brett
	 */
	public Brikke(Brett brett, Farge farge) {
		this.brett = brett;
		this.rute = brett.getRuter().get(0);
		this.setFarge(farge);
		
	}


	/**
	 * Flytter brikken et gitt antall steg
	 * @param sum
	 */
	public void flytt(Integer verdi) {
		Rute nyRute = brett.finnRute(rute, verdi);
		setRute(nyRute);
	}
	

	public void startPåNytt() {
		Rute nyRute = brett.getRuter().get(0);	
		setRute(nyRute);
	}
	
	public Rute getRute() {
		return rute;
	}
	
	private void setRute(Rute rute) {
		this.rute = rute;	
	}

	public Farge getFarge() {
		return farge;
	}

	public void setFarge(Farge farge) {
		this.farge = farge;
	}


}
