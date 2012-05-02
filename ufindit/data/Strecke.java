/**
 * 
 */
package ufindit.data;

import java.util.ArrayList;

/**
 * @author Jakob Klepp
 * @version 02.05.2012
 *
 */
public class Strecke {
	protected ArrayList <Station> stationen;
	protected double dauer;
	/**
	 * 
	 */
	public Strecke(double dauer, ArrayList <Station> stationen) {
		this.dauer = dauer;
		this.stationen = stationen;
	}

}
