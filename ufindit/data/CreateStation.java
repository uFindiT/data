package ufindit.data;



import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;
/**
 * Klasse liest aus der Datenbank ALLE Stationen aus der Datenbank aus und erstellt entsprechend Objekte 
 * dafür. Diese werden in einer ArrayList gespeichert. Anschließend werden alle Nachfolger initialisiert!
 * 
 * @author Daniel Reichmann
 * @version 04.06.12
 *
 */
public class CreateStation {
	private String pw="test";	
	//Verbindung zu DB
	private Connection verbindung;
	private Statement statement;
	//Hier werden dann die Ergebnisse gespeichert!
	private ResultSet rs;
	//Hier werden nun alle Relevanten Informationen gespeichert
	private String host="localhost";
	private String user="ufindit";
	//Hier werden alle Stationen gespeichert!
	ArrayList<Station> stationen = new ArrayList<Station>();
	
	public CreateStation(){
		try {
			 // Class.forName( DatabaseConstants.DRIVER );
			  //Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch (Exception e) {

			e.printStackTrace();
		} 
		try{
			int i = 0;
			verbindung = DriverManager.getConnection("jdbc:mysql://localhost/ufindit", user, pw);
			statement = verbindung.createStatement();
			rs = statement.executeQuery("SELECT distinct name from station  ;");
			while(rs.next()){
				String name=rs.getString("name");
				System.out.print(++i+"  "+name);
				String linie="";
				//Herausfinden aller Linien die in der Station vorkommen
				ResultSet linienrs=verbindung.createStatement().executeQuery("SELECT linie from station where name='"+name+"';");
				while(linienrs.next()){
					linie+=linienrs.getString("linie");
				}
				System.out.println(linie);
				//String linie =rs.getString("linie");
				//System.out.println(rs.getString("name") + " " +rs.getString("linie")) ;
				stationen.add(new Station(name,linie));
				//rs.getString("password");
			}
		}
		catch(Exception e){System.out.println(e);
		}
	}
	/**
	 * Hier wird für jede Station die Nachfolger herausgefunden und gespeichert
	 * Dafür muss auf die Datenbank zugegriffen werden!
	 * @throws SQLException 
	 */
	public void createNachfolger() throws SQLException{
		//Hier werden alle Nachfolgerstationen in einer TreeMap gespeichert
		TreeMap<Station, Integer> hm = new TreeMap<Station,Integer>();
		//Durchgehen aller Stationen aus der Stationenliste
		Iterator<Station> it = stationen.iterator();
		while(it.hasNext()){
			Station s =it.next();
			String name = s.getName();
			//Hier werden alle nachfolgerstationen gespeichert
			rs=statement.executeQuery("SELECT aname,dauer from strecke where ename='"+name+"';");
			while(rs.next()){
				String nname=rs.getString("aname");
				if(nname.equals(""))
					break;
				Integer dauer = new Integer(rs.getInt(2));
				Station nf = getStation(nname);
				hm.put(nf, dauer);
			}
			rs=statement.executeQuery("select ename,dauer from strecke where aname='"+name+"';");
			while(rs.next()){
				String nname=rs.getString("ename");
				if(nname.equals(""))
					break;
				Integer dauer = new Integer(rs.getInt(2));
				Station nf = getStation(nname);
				hm.put(nf, dauer);
			}
			
			
			s.setNachfolger(hm);
			hm=new TreeMap<Station,Integer>();
		}
		
	}
	/**
	 * Sucht zu einem gegebenen Stationennamen das Stationenobjekt aus der Liste raus
	 * @param		Name zu dem das Objekt gesucht werden soll
	 */
	public Station getStation(String name){
		Iterator<Station> it = stationen.iterator();
		while(it.hasNext()){
			Station s = it.next();
			if(s.getName().equals(name))
				return s;
		}
		return null;
	}
	/**
	 * Gibt alle Stationen aus die Umstiege sind
	 * 
	 */
	public void umstiegsStellen(){
		Iterator<Station> it = stationen.iterator();
		while(it.hasNext()){
			Station s = it.next();
			if(s.getUmstieg())
				System.out.println("Umstieg:" +s.getName());
		}
	}
	public ArrayList<Station> getStationen() {
		// TODO Auto-generated method stub
		return stationen;
	}
}
