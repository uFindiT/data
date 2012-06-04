/**
 * 
 */
package ufindit.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author jklepp
 *
 */
public class DBInterface extends SQLiteOpenHelper{

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "uFindiT";
 
    // Contacts table name
    private static final String TABLE_STATION = "station";
    private static final String TABLE_STRECKE = "strecke";
 
    // Contacts Table Columns names
    //Table station
    private static final String KEY_NAME = "name";
    private static final String KEY_LINIE = "linie";
    //Table strecke
    private static final String KEY_ANAME = "aname";
    private static final String KEY_ENAME = "ename";
    private static final String KEY_DAUER = "dauer";
    
    
	public DBInterface(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	
}
