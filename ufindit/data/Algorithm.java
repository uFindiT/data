package ufindit.data;

import java.util.*;

/**
 * Berechnet den schnellsten Weg zwischen 2 Stationen. 
 * Es handelt sich um eine Version von Dijkstra
 * 
 * @author Daniel Reichmann
 * @version 09.05.2012
 */
public class Algorithm {
	private Station startStation, endStation;
	//private ArrayList<Station> stationen;
	/**
	 * Konstruktor setzt die Start- und die Endstation. 
	 */
	public Algorithm(Station s, Station e){ //, ArrayList<Station> stat)
		startStation = s;
		endStation = e;
		//stationen=stat;
	}
	/**
	 * Hier wird der eigentliche Weg berechnet. Am Ende wurde allen Stationen ein Vorg�nger hinzugef�gt
	 * Es wird somit allen Stationen ein Vorg�nger und eine Zeit um dies zu erreichen zugewiesen.
	 * Anschlie�end muss noch eine Methode aufgerufen werden, damit der Weg zur�ckgegeben wird!!
	 * 
	 * @param s		Station von der der Weg berechnet wird!
	 */
	public void berechneWeg(Station s){
		if(s.isLocked()) //Wenn die Station bereits gesperrt ist, wurde mit ihr schon gerechet
			return;
		if(s.equals(endStation)){ //Bei der Endstation muss nichtmehr gerechnet werden
			return;
		}
		if(s.getVorg().equals(null)){ //Wenn es die allererste Staion ist, wird die Dauer automatisch zu 0!
			s.setDuration(0);
		}
		else{
			HashMap<Station, Integer> nachf=s.getNachfolger(); //Alle Nachfolger gespeichert!
			//Nun werden alle Keys der Hashmap in einem gespeichert
			Set<Station> snamen = nachf.keySet();
			//Nun wird f�r jede einzelne Station die Wegzeit + weitere Stationen berechnet!
			Iterator<Station> it = snamen.iterator();
			while(it.hasNext()){
				//Sperren der Station
				s.lock();
				//Speichern in ein StationenObject
				Station nf = it.next();
				//Schauen ob de Weg von dieser Station k�rzer ist
				Integer altzeit = nf.getDuration();
				if(s.getDuration()+nachf.get(nf) < altzeit){
					//Setzen des Vorg�ngers
					nf.setVorg(s);
					//Setzen der Dauer
					nf.setDuration(s.getDuration()+nachf.get(nf));
					//Berechnen des Wegens von dieser Station nun ausgehen!
					berechneWeg(nf);
				}
			}
		}
	}
}
