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
	 * werden gespeichert) - Station vorg (Der Vorg�nger von dem gekommen wird -
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
	//Vorg�ngerlinie
	private String vorglinie="";

	/**
	 * Im Konstruktor werden die ganzen Attribute aus der Datenbank gelesen.
	 * Vorg. wird am Anfang null gelassen. locked ist false umstieg ist false
	 * Die Nachfolger m�ssen in einem 2. durchlauf erstellt werden!
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
	//�ndert die Vorg�ngerstation
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
	//Gibt die Nachfolgerstationen zur�ck
	public TreeMap<Station, Integer> getNachfolger(){
		return nachf;
	}
	//Setzt den Vorg�nger
	public void setVorg(Station s){
		vorg=s;
	}
	//Gibt namen zur�ck
	public String getName(){
		return name;
	}
	//Setz vorg�ngerlinie
	public void setVorgLinie(String n){
		vorglinie=n;
	}
	//Gibt zur�ck ob die Station ein umstieg ist
	public boolean getUmstieg(){
		return umstieg;
	}

	@Override
	public int compareTo(Station o) {
		// TODO Auto-generated method stub
		return (o.getName().compareTo(this.getName())*-1);
	}

}
