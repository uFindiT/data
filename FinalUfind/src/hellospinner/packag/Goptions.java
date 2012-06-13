package hellospinner.packag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Goptions extends Activity {
    /** Called when the activity is first created. */
	Button cancel,accept;
	Boolean sound=false;
	String  selected;
	Spinner s,s2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goptions);
		addListenerOnButton();
        s = (Spinner) findViewById(R.id.spinner);
      //  s2 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.Sprachen, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(
//                this, R.array.Soundg, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
 //       s2.setAdapter(adapter2);


    }
	public void addListenerOnButton() {
		 

		accept = (Button) findViewById(R.id.button2);
		cancel = (Button) findViewById(R.id.button3);
		


		accept.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				selected =s.getSelectedItem().toString();
				if(selected.equals("Englisch")){
					 Intent intent = new Intent(Goptions.this, Start.class);
				     startActivity(intent);
				}
				else{
					Intent intent = new Intent(Goptions.this, Gstart.class);
				    startActivity(intent);
				}
				
			}
			 
		});
		cancel.setOnClickListener(new OnClickListener() {
			 
			public void onClick(View arg0) {
				finish();
				
			}
			 
		});
 
	}
 

}