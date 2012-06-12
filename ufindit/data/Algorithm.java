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
	private ArrayList<Station> al = new ArrayList<Station>();
	private int umstiegsvar = 2;
	//private ArrayList<Station> stationen;
	/**
	 * Konstruktor setzt die Start- und die Endstation. 
	 */
	public Algorithm(Station s, Station e, ArrayList<Station> ald, boolean umst){ //, ArrayList<Station> stat)
		startStation = s;
		endStation = e;
		al =ald;
		if(umst)
			umstiegsvar=30;
		//stationen=stat;
	}
	/**
	 * Hier wird der eigentliche Weg berechnet. Am Ende wurde allen Stationen ein Vorgänger hinzugefügt
	 * Es wird somit allen Stationen ein Vorgänger und eine Zeit um dies zu erreichen zugewiesen.
	 * Anschließend muss noch eine Methode aufgerufen werden, damit der Weg zurückgegeben wird!!
	 * 
	 * @param s		Station von der der Weg berechnet wird!
	 */
	public void berechneWeg(Station s){
		
		if(s.equals(endStation)){ //Bei der Endstation muss nichtmehr gerechnet werden
			return;
		}
		if(s.getVorg()==null){ //Wenn es die allererste Staion ist, wird die Dauer automatisch zu 0!
			s.setDuration(0);
		}
		if(s.isLocked()){ //Wenn die Station bereits gesperrt ist, wurde mit ihr schon gerechet
			System.out.println(s.getName() + "locked");
			return;
		}
		else{
			TreeMap<Station, Integer> nachf=s.getNachfolger(); //Alle Nachfolger gespeichert!
			//Nun werden alle Keys der TreeMap in einem gespeichert
			Set<Station> snamen = nachf.keySet();
			//Nun wird für jede einzelne Station die Wegzeit + weitere Stationen berechnet!
			Iterator<Station> it = snamen.iterator();
			while(it.hasNext()){
				
				//Speichern in ein StationenObject
				Station nf = it.next();
				//Schauen ob de Weg von dieser Station kürzer ist
				Integer altzeit = nf.getDuration();
				System.out.println(altzeit + nf.getName());
				if((s.getDuration()+nachf.get(nf)) <= altzeit.intValue()){
					//Setzen des Vorgängers
					nf.setVorg(s);
					//Setzen der Dauer
					nf.setDuration(s.getDuration()+nachf.get(nf));
					//Testen ob es Umstieg ist
					if(s.getVorg()!=null){
						if(s.getLinie().length()>3){
							if(!s.getVorg().getLinie().equals(nf.getLinie()) && nf.getLinie().length()<=3){
								s.setUmstieg(true);
								nf.setDuration(nf.getDuration()+umstiegsvar);
							}
						}
						else
							s.setUmstieg(false);
					}
					
				}
				//Sperren der Station
				s.lock();
			}
			
//			it = snamen.iterator();
//			//Suchen der kürzesten Station und berechnen des Weges
//			while(it.hasNext()){
//				
//				//Speichern in ein StationenObject
//				Station nf = it.next();
//				berechneWeg(nf);
//				//Sperren der Station
//				//s.lock();
//				
//			}
			System.out.println("KÜÜÜÜZERST!"+ getShortest().getName());
			berechneWeg(getShortest());
			
		}
	}
	/**
	 * Hier wird der berechnete Weg zurückgegeben. Als String für den Anfang
	 */
	public void createWeg(CreateStation cs){
		ArrayList<Station> al = cs.getStationen();
		Station s = endStation;
		System.out.println("WEG!!");
		System.out.println(s.getName()+" " + s.getLinie() + "  " + s.getDuration());
		//Berechnen Anzahl umst
		int u=0;
		while(s.getVorg()!=null){
			//Testen ob Umstieg!
			if(s.getUmstieg())
				u++;
			s=s.getVorg();
		}
		s=endStation;
		while(s.getVorg()!=null){
			
			//Testen ob Umstieg!
			if(s.getUmstieg())
				System.out.println(s.getName() + " "+s.getLinie() + " "+(s.getDuration()));
			s=s.getVorg();
		}
		System.out.println(s.getName()+" " + s.getLinie());
	}
	/**
	 * Gibt Station zurück die kürzeste Wegzeit hat undfrei ist
	 */
	public Station getShortest(){
		int mindauer=1000;
		Station next=null;
		Iterator<Station> it = al.iterator();
		while(it.hasNext()){
			Station nf = it.next();
			if(nf.getDuration()<mindauer && !nf.isLocked()){
				mindauer=nf.getDuration();
				next=nf;
			}
		}
		return next;
	}
}
