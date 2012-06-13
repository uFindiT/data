package hellospinner.packag;

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
			umstiegsvar=10;
		
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
			if(startStation.equals(endStation))
				s.setDuration(0);
			return;
		}
		if(s.getVorg()==null){ //Wenn es die allererste Staion ist, wird die Dauer automatisch zu 0!
			s.setDuration(0);
		}
		if(s.isLocked()){ //Wenn die Station bereits gesperrt ist, wurde mit ihr schon gerechet
			//System.out.println(s.getName() + "locked");
			return;
		}
		else{
			TreeMap<Station, Integer> nachf=s.getNachfolger(); //Alle Nachfolger gespeichert!
			//Nun werden alle Keys der TreeMap in einem gespeichert
			Set<Station> snamen = nachf.keySet();
			//Umstiegsaddition
			
			//Nun wird für jede einzelne Station die Wegzeit + weitere Stationen berechnet!
			Iterator<Station> it = snamen.iterator();
			while(it.hasNext()){
				int plusumst=0;
				//Speichern in ein StationenObject
				Station nf = it.next();
				/**
				 * ---------------------------------------
				 */
				if(s.getVorg()!=null){
					//System.out.println(s.getName());
					if(nf!=null){
						String[] nachLinien = nf.getLinie().split(" ");
						String[] vorLinien = s.getVorg().getLinie().split(" ");
						boolean noumst = false;
						for(int i = 0; i < nachLinien.length;i++){
							for( int j = 0; j<vorLinien.length;j++){
								if(nachLinien[i].equals(vorLinien[j]) && !nachLinien[i].equals(""))
									noumst=true;
							}
								
						}
						String linie="";
						vorLinien = s.getLinie().split(" ");
						if(!noumst){
							s.setUmstieg(true);
							plusumst=umstiegsvar;
						}
					}
				}
				//Schauen ob de Weg von dieser Station kürzer ist
				Integer altzeit = nf.getDuration();
				System.out.println(altzeit + nf.getName());
				if((s.getDuration()+nachf.get(nf)+plusumst) <= altzeit.intValue()){
					//Setzen des Vorgängers
					nf.setVorg(s);
					//Setzen der Dauer
					nf.setDuration(s.getDuration()+nachf.get(nf)+plusumst);
//					if(s.getVorg()!=null){ //Teste jz mal xd
//				//-.-'''''''''  Wieso? Mom welche Station is nf immer? xD Ähm... Das is bissi gschissen... Weil der algorithmus dann ja weiterrechnet -.-
//						String linie=s.getVorg().getLinie(); //Fuck warte überlege grad^^
//						if(!(nf.getLinie().equals(linie) || nf.getLinie().contains(linie) || linie.contains(nf.getLinie()))){
//							{
//								s.setUmstieg(true);
//							}
//						}
//						else{ //seriously? -.-.-.--.-.-hmm einen Versuch hab ich noch xD
//							s.setUmstieg(false);
//						}
//					}
//					if(s.getVorg()!=null){
//						String linie=s.getVorg().getLinie();
//						if(s.getLinie().length()>3){
//							if(!(nf.getLinie().equals(linie) || nf.getLinie().contains(linie) || linie.contains(nf.getLinie()))){
//								{
//									s.setUmstieg(true);
//								}
//							}
//							else{ //seriously? -.-.-.--.-.-hmm einen Versuch hab ich noch xD Asooo ja, weiß schon fast wieder xD Muss es anders angehen -.- Und zwar so:
//								s.setUmstieg(false);
//							}
//						}
//					}
					if(s.getVorg()!=null){
						if(s.getVorg().getVorg()!=null){
							String linie=s.getVorg().getVorg().getLinie();
							if(!(nf.getLinie().equals(linie) || nf.getLinie().contains(linie) || linie.contains(nf.getLinie()))){
								{
									s.setUmstieg(true);
								}
							}
							else{ 
								s.setUmstieg(false);//Das gibts ja nich -.-, ich kann jezt leider nicht wirklich helfen weil ich mich da grad mit dem code nicht auskenne ^^ Ich schon aberdas Problem is, dass derAlgorithmus immer weiterrechnet unddeswegen wieder auf false setz...
								//Weil im Nachhinein is es leivht die umstiege festzustellen. Wie wärs wir lassen das mit der zeit erstmals? ich überleg mir dann noch was k , dann probier ich mal das man 2 stationen grafisch auswählt und sie dann berechnen lässt.
								//Graphisch auswählen? Wie das? eclipse spinnt schon wiede rmom
							}
						}
					}
					//Testen ob es Umstieg ist
//					if(s.getVorg()!=null){
//						if(s.getLinie().length()>3){
//							if(!s.getVorg().getLinie().equals(nf.getLinie()) && nf.getLinie().length()<=3){
//								s.setUmstieg(true);
//								nf.setDuration(nf.getDuration()+umstiegsvar);
//							}
//						
//						}
//						else
//							s.setUmstieg(false);
//					}
					
				}
				//Sperren der Station
				s.lock();
			}
			
			berechneWeg(getShortest());
			
		}
	}
	/**
	 * Hier wird der berechnete Weg zurückgegeben. Als String für den Anfang
	 */
	public String createWeg(String language){
		String[] word =null;
		if(language.equals("d")){
			word = new String[]{"Von","nach","Dauer insgesamt","Umstieg von", "in"};
		}
		if(language.equals("e")){
			word = new String[]{"From", "to","Total Duration","Change metro from","to"};
		}
		String ret="";
		Station s = endStation;
		//Zum abziehen der Duratio 
		int gefahren=s.getDuration();
		
		//ret+= "End: " +s.getName()+" " + s.getLinie() +"\n";
		int anzUmst = 0;
		String linie=s.getLinie();
		Station nf = null;
		Station lastS = s; //Speichert wo der Letzte Umstieg war
		while(s.getVorg()!=null){
			System.out.println(s.getName());
			if(nf!=null){
				String[] nachLinien = nf.getLinie().split(" ");
				String[] vorLinien = s.getVorg().getLinie().split(" ");
				boolean noumst = false;
				for(int i = 0; i < nachLinien.length;i++){
					for( int j = 0; j<vorLinien.length;j++){
						if(nachLinien[i].equals(vorLinien[j]) && !nachLinien[i].equals(""))
							noumst=true;
					}
						
				}
				linie="";
				vorLinien = s.getLinie().split(" ");
				if(!noumst){
					anzUmst++;
					linie=s.getLinie();
					//ret +="\nFrom " + s.getName() + " to " + lastS.getName() + " : +" +  (nf.getDuration()) + "min\n"+"Change from " + s.getLinie().replace(linie, "") + " to" + linie;
					//Change feststellen: Von Line zu welcher Linie!
					
					//ret +="\nDuration: +" + (gefahren-nf.getDuration()) +" min\n" ;
					ret +="\n"+word[0] +" "+ s.getName() + " "+word[1] +" " + lastS.getName();
					
					//Wo bis wo?
					for(int i = 0; i < nachLinien.length;i++){
						for( int j = 0; j<vorLinien.length;j++){
							if(nachLinien[i].equals(vorLinien[j]) && !nachLinien[i].equals(""))
								linie=nachLinien[i];
						}
							
					}
					ret+="\n"+word[3] +" " + s.getName() + " " + word[4] +" " + linie + "\n" ; //" from" + s.getLinie().replace(linie, "") + +
					//Es werden für jeden Umstieg die Differenz auf 2 abgezogen, da für einen Umstieg in der anderen Variante mehr berechnet wird!
					linie=s.getLinie(); 
					//System.out.println(nf.getUmstieg());
					//gf += nf.getDuration();
					lastS=s;
				}
			}
//			
			nf=s;
			s=s.getVorg(); 
		}
		ret = turnString(ret );
		ret ="\n"+word[0]+" " + startStation.getName() + " " + word[1] + " " + lastS.getName() + " \n" + ret;//"Change from " + startStation.getLinie().replace(linie, "") + " to" + linie  +
		ret = "\nStart " + s.getName()+" " + s.getLinie() + ret;
		ret+= word[2]+": " + (endStation.getDuration()-anzUmst*(umstiegsvar-2)) + " min\n";
		return ret;
	}
	//Dreht die Ausgaben eines Strings zurück. Die Zeilen werden in unterschiedlicher Reihenfolge ausgegebn!
	public String turnString(String a){
		String turn = "";
		String[] splitted = a.split("\n");
		for(int i = splitted.length -1; i>=0; i--){
			turn += splitted[i]+"\n";
		}
		return turn;
	}
	//Was hast du geändert?
	 //turn string hinzugefügt und createWeg.
	//Vl passt was nicht mit dem Auswählen der station`? davor hats ja geklappt ^^ warte mal
	
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
	//Gibt dauer zurück
	public int getGesDauer(){
		return endStation.getDuration();
	}
}
