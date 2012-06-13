package hellospinner.packag;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * 
 * http://www.zentus.com/sqlitejdbc/ Von dieser Website 
 * sqlitejdbc-v056.jar runterladen 
 * Die jar Datei in Refenrenced Libraries einbinden 
 * Da ich nicht genau weiß wie dein Algorithmus funktioniert habe ich ein 
 * paar Sample Methoden geschreiben.
 *
 */

public class SqlTest  {
	//Sql Datenbank 
	 SQLiteDatabase db;
	 
	 //Alle Stationen als String liste zurückgeben 
	 public List<String> getLinie() {
	        List<String> linienList = new ArrayList<String>();
	        // Alle Querys auswählen 
	        String selectQuery = "SELECT  * FROM station";
	 
	        //SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	 
	        // eine Schleife durch durch alle querys 
	        if (cursor.moveToFirst()) {
	            do {
	            	//Element der Lsite, Crusor.getSrting(jeweilige Spallte) 
	            	String element=cursor.getString(0)+cursor.getString(1);
	                // Hinzufügen zur Liste
	            	linienList.add(element);
	            } while (cursor.moveToNext());
	        }
	 
	        // return contact list
	        return linienList;
	    }
	 //Strecken zurückgeben
	//Alle Stationen als String liste zurückgeben 
	 public List<String> getStrecke() {
	        List<String> streckenList = new ArrayList<String>();
	        // Alle Querys auswählen 
	        String selectQuery = "SELECT  * FROM strecke";
	 
	        //SQLiteDatabase db = this.getWritableDatabase();
	        Cursor cursor = db.rawQuery(selectQuery, null);
	 
	        // eine Schleife durch durch alle querys 
	        if (cursor.moveToFirst()) {
	            do {
	            	//Element der Lsite, Crusor.getSrting(jeweilige Spallte) 
	            	String element=cursor.getString(0)+"\n"+cursor.getString(1)+"\n"+cursor.getString(2);
	                // Hinzufügen zur Liste
	            	streckenList.add(element);
	            } while (cursor.moveToNext());
	        }
	 
	        // return contact list
	        return streckenList;
	    }
	 //Eine Gewisse Station oder Linie zurückgeben 
}
