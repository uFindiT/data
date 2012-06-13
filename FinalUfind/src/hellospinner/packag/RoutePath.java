package hellospinner.packag;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RoutePath extends Activity {
	 Button save,newb,home;
	 String ausgabe;
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 Bundle extras = getIntent().getExtras();
		 ausgabe=extras.getString("1");
		 setContentView(R.layout.routepath);
		 addListenerOnButton();
		 TextView eingabe = (TextView) findViewById(R.id.textView2);
         eingabe.setText(ausgabe);
		 
		
	 }
	 public void addListenerOnButton() {
		 
		  	save = (Button) findViewById(R.id.button1);
			newb = (Button) findViewById(R.id.button2);
			home = (Button) findViewById(R.id.button3);

			save.setOnClickListener(new OnClickListener() {
	 
				public void onClick(View arg0) {
					  //  Intent intent = new Intent(Start.this, Options.class);
				      //  startActivity(intent);
					String FILENAME = "routespeicher";
					String string = ausgabe;
					FileOutputStream fOut = null;

					OutputStreamWriter osw = null;

					try{

					fOut = openFileOutput(FILENAME, Context.MODE_PRIVATE);

					osw = new OutputStreamWriter(fOut);

					osw.write(ausgabe);

					osw.close();

					fOut.close();

					}catch(Exception e){

					e.printStackTrace(System.err);

					}

					
					
				}
				 
			});
			newb.setOnClickListener(new OnClickListener() {
				 
				public void onClick(View arg0) {
					    Intent intent = new Intent(RoutePath.this, Route.class);
				        startActivity(intent);
					
				}
				 
			});
			home.setOnClickListener(new OnClickListener() {
				 
				public void onClick(View arg0) {
					    Intent intent = new Intent(RoutePath.this, Start.class);
				        startActivity(intent);
					
				}
				 
			});

}
}