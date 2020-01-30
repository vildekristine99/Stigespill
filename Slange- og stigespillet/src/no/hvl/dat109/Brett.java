/**
 * 
 */
package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vilde Kristine Fossum
 *
 */
public class Brett {
	private List<Rute> ruter;
	
	public Brett() {
		ruter = new ArrayList<Rute>();
		leggTilRuter();
	}
	
	/**
	 * Metode for � lage ruter til brettet
	 */
	private void leggTilRuter() {
		for(int i = 1; i <= 100; i++) {
			Rute ny = new Rute();
			ny.setRuteNr(i);
			ruter.add(ny);
		}
	}
	/**
	 * Finner og retunerer ruten som er sum steg frem for rute
	 * 
	 * @param rute
	 * @param sum
	 * @return
	 */
	public Rute finnRute(Rute rute, Integer verdi) {
		Rute nyRute = ruter.get(rute.getRuteNr() + verdi - 1);
		return nyRute;
	}

	/**
	 * 
	 * @return
	 */
	public List<Rute> getRuter() {
		return ruter;
	}
	
}
