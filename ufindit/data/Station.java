/**
 * 
 */
package ufindit.data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Jakob Klepp
 * @version 02.05.2012
 * 
 */
public class Station implements AbstractStation {
	// -name: String
	/**
	 * -String name - list<Station, Integer> nachf(ALLE nachfolgerstationen
	 * werden gespeichert) - Station vorg (Der Vorg�nger von dem gekommen wird -
	 * Int Duration - boolean locked - boolean umstieg - Strign linie
	 * 
	 * @param a
	 */
	private String name;
	private HashMap<AbstractStation, Integer> nachf;
	private AbstractStation vorg;
	private int duration;	//Gesamtdauer
	private boolean locked;
	private boolean umstieg;
	private String linie;

	/**
	 * Im Konstruktor werden die ganzen Attribute aus der Datenbank gelesen.
	 * Vorg. wird am Anfang null gelassen. locked ist false umstieg ist false
	 * ges. ist 10000!
	 */
	public Station(String name, String linie) {
		this.name = name;
		this.linie = linie;
		nachf = getFromDB();
		duration = 10000;	//Gesamtdauer
		locked = false;
		umstieg = false;
	}

	@Override
	public void changePrevious(AbstractStation vorg) {
		this.vorg = vorg;
	}

	@Override
	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public int getDuration() {
		return this.duration;
	}

	@Override
	public void lock() {
		this.locked = true;
	}

	@Override
	public boolean isLocked() {
		return this.locked;
	}

	@Override
	public boolean isUmstieg() {
		return umstieg = vorg.getLinie().equals(this.linie);
	}

	@Override
	public String getLinie() {
		return this.linie;
	}

}
