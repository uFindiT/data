package hellospinner.packag;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GLoadRoute extends Activity {
	Spinner s;
	String selected;
	Button load;
	TextView eingabe;
    String data = null;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gloadroute);
		addListenerOnButton();
       /* s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.Route, android.R.layout.simple_spinner_item);
        s.setAdapter(adapter);
        */
		eingabe = (TextView) findViewById(R.id.textView3);
		String FILENAME = "routespeicher";
		FileInputStream fIn = null;

		InputStreamReader isr = null;

		try{

		char[] inputBuffer = new char[1024];


		fIn = openFileInput(FILENAME);

		isr = new InputStreamReader(fIn);

		isr.read(inputBuffer);

		data = new String(inputBuffer);

		isr.close();

		fIn.close();

		}catch(IOException e){

		e.printStackTrace(System.err);

		}
		eingabe.setText(data);
	}
	public void addListenerOnButton() {
		 
		load = (Button) findViewById(R.id.button2);
		
		load.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//selected =s.getSelectedItem().toString();
				Intent intent = new Intent(GLoadRoute.this, Gstart.class);
			    startActivity(intent);
			}
			
			 
		});

}
}
