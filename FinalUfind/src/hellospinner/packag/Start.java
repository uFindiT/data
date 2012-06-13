package hellospinner.packag;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class Start extends Activity {
    /** Called when the activity is first created. */
	Boolean sound=false;
	String []a;
	private ArrayList<Station> stationen = new ArrayList<Station>();
	String dbname="kleinedb400";
	Button load,button,start,credit;
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.start);
	    super.onCreate(savedInstanceState);
	    addListenerOnButton();
	    SQLiteDatabase checkDB = null;
	    try {
	        checkDB = SQLiteDatabase.openDatabase("/data/data/hellospinner.packag/databases/"+dbname, null,
	                SQLiteDatabase.OPEN_READONLY);
	        checkDB.close();
	        System.out.println("existiert");
	    } catch (SQLiteException e) {
	    	SQLiteDatabase db = openOrCreateDatabase(dbname,MODE_PRIVATE,null);
	    	 db.execSQL("CREATE TABLE IF NOT EXISTS station(name VARCHAR,linie VARCHAR,PRIMARY KEY(name,linie));");
	 	    db.execSQL("CREATE TABLE IF NOT EXISTS strecke(aname VARCHAR,ename VARCHAR," +
	 	    		   "dauer INTEGER,PRIMARY KEY(aname,ename),FOREIGN KEY (aname) REFERENCES station (name)," +
	 	    		   "FOREIGN KEY (ename) REFERENCES station (name));");
	 db.execSQL("INSERT INTO station VALUES ('Reumannplatz','U1')");
	 db.execSQL("INSERT INTO station VALUES ('Keplerplatz', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Suedtiroler Platz', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Taubstummengasse', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Karlsplatz', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Stephansplatz', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Schwedenplatz', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Nestroyplatz', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Praterstern', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Vorgartenstrasse', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Donauinsel', 'U1');");
	 db.execSQL("INSERT INTO station VALUES ('Kaisermuehlen-VIC', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Alte Donau', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Kagran', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Kagraner Platz', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Rennbahnweg', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Aderklaaer Strasse', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Grossfeldsiedlung', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Leopoldau', 'U1')");
	 db.execSQL("INSERT INTO station VALUES ('Karlsplatz', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Museumsquartier', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Volkstheater', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Rathaus', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Schottentor', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Schottenring', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Taborstrasse', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Praterstern', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Messe-Prater', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Krieau', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Stadion', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Donaumarina', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Donaustadtbruecke', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Stadlau', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Hardeggasse', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Donauspital', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Aspernstrasse', 'U2')");
	 db.execSQL("INSERT INTO station VALUES ('Simmering', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Enkplatz U/Grillgasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Zippererstrasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Gasometer', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Erdberg', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Schlachthausgasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Kardinal-Nagl-Platz', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Rochusgasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Landstrasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Stubentor', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Stephansplatz', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Herrengasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Volkstheater', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Neubaugasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Zieglergasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Westbahnhof', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Schweglerstrasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Johnstrasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Huetteldorfer Strasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Kendlerstrasse', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Ottakring', 'U3')");
	 db.execSQL("INSERT INTO station VALUES ('Huetteldorf', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Ober St Veit', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Unter St Veit', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Braunschweiggasse', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Hietzing, Kennedybruecke', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Schoenbrunn', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Meidling Hauptstrasse', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Laengenfeldgasse', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Margaretenguertel', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Pilgramgasse', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Kettenbrueckengasse', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Karlsplatz', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Stadtpark', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Landstrasse', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Schwedenplatz', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Schottenring', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Rossauer Laende', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Friedensbruecke', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Spittelau', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Heiligenstadt', 'U4')");
	 db.execSQL("INSERT INTO station VALUES ('Floridsdorf', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Neue Donau', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Handelskai', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Dresdner Strasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Jaegerstrasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Spittelau', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Nussdorfer Strasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Waehringer Strasse-Volksoper', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Michelbeuern-AKH', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Alser Strasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Josefstaedter Strasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Thaliastrasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Burggasse-Stadthalle', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Westbahnhof', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Gumpendorfer Strasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Laengenfeldgasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Niederhofstrasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Philadelphiabruecke', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Tscherttegasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Am Schoepfwerk', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Alterlaa', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Erlaaer Strasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Perfektastrasse', 'U6')");
	 db.execSQL("INSERT INTO station VALUES ('Siebenhirten', 'U6')");
	 db.execSQL("INSERT INTO strecke VALUES ('Reumannplatz', 'Keplerplatz', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Keplerplatz', 'Suedtiroler Platz',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Suedtiroler Platz', 'Taubstummengasse',1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Taubstummengasse', 'Karlsplatz',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Karlsplatz', 'Stephansplatz',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Stephansplatz', 'Schwedenplatz',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Schwedenplatz', 'Nestroyplatz',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Nestroyplatz', 'Praterstern', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Praterstern', 'Vorgartenstrasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Vorgartenstrasse', 'Donauinsel',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Donauinsel', 'Kaisermuehlen-VIC',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Kaisermuehlen-VIC', 'Alte Donau',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Alte Donau', 'Kagran', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Kagran', 'Kagraner Platz',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Kagraner Platz', 'Rennbahnweg',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Rennbahnweg', 'Aderklaaer Strasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Aderklaaer Strasse', 'Grossfeldsiedlung',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Grossfeldsiedlung', 'Leopoldau', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Karlsplatz', 'Museumsquartier',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Museumsquartier', 'Volkstheater',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Volkstheater', 'Rathaus', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Rathaus', 'Schottentor',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Schottentor', 'Schottenring',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Schottenring', 'Taborstrasse', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Taborstrasse', 'Praterstern', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Praterstern', 'Messe-Prater',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Messe-Prater', 'Krieau',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Krieau', 'Stadion',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Stadion', 'Donaumarina', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Donaumarina', 'Donaustadtbruecke',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Donaustadtbruecke', 'Stadlau',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Stadlau', 'Hardeggasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Hardeggasse', 'Donauspital',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Donauspital', 'Aspernstrasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Simmering', 'Enkplatz U/Grillgasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Enkplatz U/Grillgasse', 'Zippererstrasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Zippererstrasse', 'Gasometer', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Gasometer', 'Erdberg',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Erdberg', 'Schlachthausgasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Schlachthausgasse', 'Kardinal-Nagl-Platz',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Kardinal-Nagl-Platz', 'Rochusgasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Rochusgasse', 'Landstrasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Landstrasse', 'Stubentor',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Stubentor', 'Stephansplatz',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Stephansplatz', 'Herrengasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Herrengasse', 'Volkstheater',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Volkstheater', 'Neubaugasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Neubaugasse', 'Zieglergasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Zieglergasse', 'Westbahnhof',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Westbahnhof', 'Schweglerstrasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Schweglerstrasse', 'Johnstrasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Johnstrasse', 'Huetteldorfer Strasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Huetteldorfer Strasse', 'Kendlerstrasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Kendlerstrasse', 'Ottakring',1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Huetteldorf', 'Ober St Veit', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Ober St Veit', 'Unter St Veit',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Unter St Veit', 'Braunschweiggasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Braunschweiggasse', 'Hietzing, Kennedybruecke',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Hietzing, Kennedybruecke', 'Schoenbrunn',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Schoenbrunn', 'Meidling Hauptstrasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Meidling Hauptstrasse', 'Laengenfeldgasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Laengenfeldgasse', 'Margaretenguertel',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Margaretenguertel', 'Pilgramgasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Pilgramgasse', 'Kettenbrueckengasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Kettenbrueckengasse', 'Karlsplatz',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Karlsplatz', 'Stadtpark',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Stadtpark', 'Landstrasse', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Landstrasse', 'Schwedenplatz',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Schwedenplatz', 'Schottenring', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Schottenring', 'Rossauer Laende',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Rossauer Laende', 'Friedensbruecke',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Friedensbruecke', 'Spittelau',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Spittelau', 'Heiligenstadt',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Floridsdorf', 'Neue Donau', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Neue Donau', 'Handelskai', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Handelskai', 'Dresdner Strasse', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Dresdner Strasse', 'Jaegerstrasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Jaegerstrasse', 'Spittelau',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Spittelau', 'Nussdorfer Strasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Nussdorfer Strasse', 'Waehringer Strasse-Volksoper',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Waehringer Strasse-Volksoper', 'Michelbeuern-AKH',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Michelbeuern-AKH', 'Alser Strasse', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Alser Strasse', 'Josefstaedter Strasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Josefstaedter Strasse', 'Thaliastrasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Thaliastrasse', 'Burggasse-Stadthalle', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Burggasse-Stadthalle', 'Westbahnhof', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Westbahnhof', 'Gumpendorfer Strasse', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Gumpendorfer Strasse', 'Laengenfeldgasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Laengenfeldgasse', 'Niederhofstrasse',1 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Niederhofstrasse', 'Philadelphiabruecke', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Philadelphiabruecke', 'Tscherttegasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Tscherttegasse', 'Am Schoepfwerk', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Am Schoepfwerk', 'Alterlaa', 2)");
	 db.execSQL("INSERT INTO strecke VALUES ('Alterlaa', 'Erlaaer Strasse',2 )");
	 db.execSQL("INSERT INTO strecke VALUES ('Erlaaer Strasse', 'Perfektastrasse', 1)");
	 db.execSQL("INSERT INTO strecke VALUES ('Perfektastrasse', 'Siebenhirten',1 )");
	 db.close();	    
	 
	        // database doesn't exist yet.
	    }
	  }

	  /**
	     * Auslesen der Stationen
	     * */
	   public void readDataBase() throws IOException{
		   		
	       		//myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	        	//AUslesen der Stationen
		        // Alle Querys auswählen 
		        String selectQuery = "SELECT distinct name from station  ORDER BY name;";
		        SQLiteDatabase db = openOrCreateDatabase(dbname,MODE_PRIVATE,null);
		        //SQLiteDatabase db = this.getWritableDatabase();
		        Cursor cursor = db.rawQuery(selectQuery, null);
		 
		        // eine Schleife durch durch alle querys 
		        if (cursor.moveToFirst()) {
		            do {
		            	//Element der Lsite, Crusor.getSrting(jeweilige Spallte) 
		            	String name=cursor.getString(0);
		            	Cursor cursor2 = db.rawQuery("SELECT linie from station where name='"+name+"';",null);
		                // Hinzufügen zur Liste
		            	String linie="";
		            	if(cursor2.moveToFirst())            			
		            	do {
		            		linie+= "  " + cursor2.getString(0);
		            	}while (cursor2.moveToNext());
		            	stationen.add(new Station(name,linie));
		            	cursor2.close();
		            } while (cursor.moveToNext());
		        }
		        cursor.close();
		        
		        db.close();
		    }
	   /**
		 * Hier wird für jede Station die Nachfolger herausgefunden und gespeichert
		 * Dafür muss auf die Datenbank zugegriffen werden!
		 * @throws SQLException 
		 */
		public void createNachfolger() throws SQLException{
			 SQLiteDatabase db = openOrCreateDatabase(dbname,MODE_PRIVATE,null);
			//Hier werden alle Nachfolgerstationen in einer HashMap gespeichert
			TreeMap<Station, Integer> hm = new TreeMap<Station,Integer>();
			//Durchgehen aller Stationen aus der Stationenliste
			Iterator<Station> it = stationen.iterator();
			while(it.hasNext()){
				Station s =it.next();
				String name = s.getName();
				//Hier werden alle nachfolgerstationen gespeichert
				/**
				 * Bekommen der Nachfolgerstationen
				 * 
				 */
				Cursor cursor = db.rawQuery("SELECT aname,dauer from strecke where ename='"+name+"';",null);
				if(cursor.moveToFirst()){
					do{
						String nname=cursor.getString(0);
						if(nname.equals(""))
							break;
						Integer dauer = new Integer(cursor.getInt(1));
						Station nf = getStation(nname);
						hm.put(nf, dauer);
					}while (cursor.moveToNext());
				}
				cursor = db.rawQuery("select ename,dauer from strecke where aname='"+name+"';", null);
				if(cursor.moveToFirst()){
					do{
						String nname=cursor.getString(0);
						if(nname.equals(""))
							break;
						Integer dauer = new Integer(cursor.getInt(1));
						Station nf = getStation(nname);
						hm.put(nf, dauer);
					}while (cursor.moveToNext());
				}
				s.setNachfolger(hm);
				hm=new TreeMap<Station,Integer>();
				cursor.close();
			}
			
			db.close();
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
	  public void addListenerOnButton() {
		    load = (Button) findViewById(R.id.button4); 
		  	credit = (Button) findViewById(R.id.button3);
			button = (Button) findViewById(R.id.button2);
			start = (Button) findViewById(R.id.button1);

			button.setOnClickListener(new OnClickListener() {
	 
				public void onClick(View arg0) {
					    Intent intent = new Intent(Start.this, Options.class);
				        startActivity(intent);
				        finishActivity(5);
				        System.out.println("wird noch ausgeführt");
				        //finish();
				        


					
					
				}
				 
			});
			load.setOnClickListener(new OnClickListener() {
				 
				public void onClick(View arg0) {
					    Intent intent = new Intent(Start.this,LoadRoute.class);
				        startActivity(intent);
				        //finishActivity(5);
				        //System.out.println("wird noch ausgeführt");
				        //finish()

					
					
				}
				 
			});
			credit.setOnClickListener(new OnClickListener() {
				 
				public void onClick(View arg0) {
					Intent intent = new Intent(Start.this, Credits.class);
			        startActivity(intent);
					
					
					
				}
				 
			});
			
	  start.setOnClickListener(new OnClickListener() {
			 
			public void onClick(View arg0) {
				    Intent intent = new Intent(Start.this, Route.class);
			        startActivity(intent);
			}
	  });
	  }
}