package ufindit.data;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractStation {
	//-name: String
	/**
	 * -String name
	 * - list<Station, Integer> nachf(ALLE nachfolgerstationen werden gespeichert)
	 * - Station vorg (Der Vorg�nger von dem gekommen wird 
	 * - Int Duration
	 * - boolean locked
	 * - boolean umstieg
	 * - Strign linie
	 * @param a
	 */
	public abstract void changePrevious(Station a);
	public abstract void setDuration(int t); 
	public abstract int getDuration();
	public abstract void lock(); //Setzt Attribut lock auf true!
	public abstract boolean isLocked();
	public abstract boolean isUmstieg();//Pr�ft ob vom Vorg�nger zu dieser Station sich die line(String) ge�ndert hat. Wenn ja wird Umstieg auf true gesetzt!
	public abstract String getLinie();//returnt linie;
	public abstract Station getVorg();
	public abstract HashMap<Station, Integer> getNachfolger();
	/**
	 * Im Konstruktor werden die ganzen Attribute aus der Datenbank gelesen. 
	 * Vorg. wird am Anfang null gelassen. locked ist false umstieg ist false ges. ist 10000!
	 */
}
