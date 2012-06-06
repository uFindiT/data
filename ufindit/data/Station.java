/**
 * 
 */
package ufindit.data;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author Jakob Klepp, Daniel Reichmann
 * @version 02.05.2012
 * 
 */
public class Station implements Comparable<Station>{
	// -name: String
	/**
	 * -String name - list<Station, Integer> nachf(ALLE nachfolgerstationen
	 * werden gespeichert) - Station vorg (Der Vorgï¿½nger von dem gekommen wird -
	 * Int Duration - boolean locked - boolean umstieg - Strign linie
	 * 
	 * @param a
	 */
	private String name;
	private TreeMap<Station, Integer> nachf;
	private Station vorg;
	private int duration;	//Gesamtdauer
	private boolean locked;
	private boolean umstieg;
	private String linie;
	//Vorgängerlinie
	private String vorglinie="";

	/**
	 * Im Konstruktor werden die ganzen Attribute aus der Datenbank gelesen.
	 * Vorg. wird am Anfang null gelassen. locked ist false umstieg ist false
	 * Die Nachfolger müssen in einem 2. durchlauf erstellt werden!
	 * ges. ist 10000!
	 */
	public Station(String name, String linie) {
		this.name = name;
		this.linie = linie;
		duration = 10000;	//Gesamtdauer
		locked = false;
		umstieg = false;
		vorglinie=linie;
	}
	//Ändert die Vorgängerstation
	public void changePrevious(Station vorg) {
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

	public void setUmstieg(boolean b) {
		umstieg = b;
	}

	public String getLinie() {
		return this.linie;
	}
	/**
	 * Die Nachfolger werden hier initialisert
	 * @return		Nachfolger in TreeMap
	 */
	public void setNachfolger(TreeMap<Station, Integer> hm) {
		nachf=hm;
	}
	public Station getVorg(){
		return vorg;
	}
	//Gibt die Nachfolgerstationen zurück
	public TreeMap<Station, Integer> getNachfolger(){
		return nachf;
	}
	//Setzt den Vorgänger
	public void setVorg(Station s){
		vorg=s;
	}
	//Gibt namen zurück
	public String getName(){
		return name;
	}
	//Setz vorgängerlinie
	public void setVorgLinie(String n){
		vorglinie=n;
	}
	//Gibt zurück ob die Station ein umstieg ist
	public boolean getUmstieg(){
		return umstieg;
	}

	@Override
	public int compareTo(Station o) {
		// TODO Auto-generated method stub
		return (o.getName().compareTo(this.getName())*-1);
	}

}
