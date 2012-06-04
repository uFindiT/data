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
public class Station extends AbstractStation {
	// -name: String
	/**
	 * -String name - list<Station, Integer> nachf(ALLE nachfolgerstationen
	 * werden gespeichert) - Station vorg (Der Vorgï¿½nger von dem gekommen wird -
	 * Int Duration - boolean locked - boolean umstieg - Strign linie
	 * 
	 * @param a
	 */
	private String name;
	private HashMap<Station, Integer> nachf;
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
	//Ändert die Vorgängerstation
	public void changePrevious(AbstractStation vorg) {
		this.vorg = vorg;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDuration() {
		return this.duration;
	}

	public void lock() {
		this.locked = true;
	}

	public boolean isLocked() {
		return this.locked;
	}

	public boolean isUmstieg() {
		return umstieg = vorg.getLinie().equals(this.linie);
	}

	public String getLinie() {
		return this.linie;
	}
	
	private HashMap<Station, Integer> getFromDB() {
		HashMap<Station, Integer> hm = new HashMap<Station, Integer>();
		//Do something
		
		return hm;
	}
	public AbstractStation getVorg(){
		return vorg;
	}
	//Gibt die Nachfolgerstationen zurück
	public HashMap<Station, Integer> getNachfolger(){
		return nachf;
	}
	//Setzt den Vorgänger
	public void setVorg(Station s){
		vorg=s;
	}

}
