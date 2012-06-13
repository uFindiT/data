package hellospinner.packag;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class NewRoute extends Activity{
	 Spinner s,s2;
	 Button b1;
	 ArrayAdapter adapter,adapter2;
	 private ArrayList<Station> stationen = new ArrayList<Station>();
	 String dbname="kleinedb400";
	 String ub,ub2;
	 String  selected,selected2;
	 SimpleDateFormat t = new SimpleDateFormat("HH:mm");
	 boolean umst = false;
	 Date now;
	 EditText et ;
	 ToggleButton toggle;
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
			Bundle extras = getIntent().getExtras();
			ub= extras.getString("1");
			ub2= extras.getString("2");
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.newroute);
	        s = (Spinner) findViewById(R.id.spinner1);
	        s2 = (Spinner) findViewById(R.id.spinner2);
	        addListenerOnButton();
	        et = (EditText)findViewById(R.id.editText1);
	        et = (EditText)findViewById(R.id.editText1);
	        toggle = (ToggleButton)findViewById(R.id.ToggleButton01);
	        

	        now = new Date();
	        et.setText(t.format(now));

	        //Überprüfen Welche Linien ausgewählt wurden
	        if(ub.equals("U6")){
	        	adapter = ArrayAdapter.createFromResource(
		                this, R.array.U6, android.R.layout.simple_spinner_item);
		       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        if(ub.equals("U4")){
	        	adapter = ArrayAdapter.createFromResource(
	                this, R.array.U4, android.R.layout.simple_spinner_item);
	       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        }

	        if(ub.equals("U3")){
	        	adapter = ArrayAdapter.createFromResource(
		                this, R.array.U3, android.R.layout.simple_spinner_item);
		       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        if(ub.equals("U2")){
		        adapter = ArrayAdapter.createFromResource(
		                this, R.array.U2, android.R.layout.simple_spinner_item);
		       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        if(ub.equals("U1")){
		        adapter = ArrayAdapter.createFromResource(
		                this, R.array.U1, android.R.layout.simple_spinner_item);
		       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        if(ub2.equals("U6")){
	        	   adapter2 = ArrayAdapter.createFromResource(
	   	                this, R.array.U6, android.R.layout.simple_spinner_item);
	   	        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        if(ub2.equals("U4")){
	        	   adapter2 = ArrayAdapter.createFromResource(
	   	                this, R.array.U4, android.R.layout.simple_spinner_item);
	   	        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        if(ub2.equals("U3")){
	        	   adapter2 = ArrayAdapter.createFromResource(
	   	                this, R.array.U3, android.R.layout.simple_spinner_item);
	   	        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        if(ub2.equals("U2")){
	        	   adapter2 = ArrayAdapter.createFromResource(
	   	                this, R.array.U2, android.R.layout.simple_spinner_item);
	   	        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        if(ub2.equals("U1")){
	        	   adapter2 = ArrayAdapter.createFromResource(
	   	                this, R.array.U1, android.R.layout.simple_spinner_item);
	   	        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
	        s.setAdapter(adapter);
	        s2.setAdapter(adapter2);
	        
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
		            cursor.close();
		        }
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
				 
			  	b1 = (Button) findViewById(R.id.button1);
				b1.setOnClickListener(new OnClickListener() {
					 
					public void onClick(View arg0) {
						try {
							readDataBase();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							createNachfolger();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Algorithm alg = new Algorithm(getStation(s.getSelectedItem().toString()),getStation(s2.getSelectedItem().toString()),stationen,toggle.isChecked());
						alg.berechneWeg(getStation(s.getSelectedItem().toString()));
						String ausgabe=alg.createWeg("e");
						Intent intent = new Intent(NewRoute.this, RoutePath.class);
						now = new Date();
						int alt=0;
						String start="";
						//alt=now.getMinutes()+now.getHours()*60 + alg.getGesDauer();

						
							String[] time = et.getText().toString().split(":");
							alt=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]) + alg.getGesDauer();
							start=et.getText().toString();
						//System.out.println(alt);
						String zeit = alt/60+":"+alt%60;
						intent.putExtra("1","Starttime: " +start+"\n"+ausgabe + "\nEndtime: "+zeit);
						startActivity(intent);
						//System.out.println(string); sec
						
					}
					 
				});
		  }
		
	 }
	    


