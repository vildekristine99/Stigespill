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
	 * @param verdi
	 * @return
	 */
	public Rute finnRute(Rute rute, Integer verdi) {
		Integer ruteNr = rute.getRuteNr() + verdi;
		Rute nyRute = null;
		if(ruteNr <= 100) {
			nyRute = ruter.get(ruteNr-1);
		} else {
			nyRute = rute;
		}
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
