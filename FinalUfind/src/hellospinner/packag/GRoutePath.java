package hellospinner.packag;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GRoutePath extends Activity {
	 Button save,newb,home;
	 String ausgabe;
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 Bundle extras = getIntent().getExtras();
		 ausgabe=extras.getString("1");
		 setContentView(R.layout.groutepath);
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
					String FILENAME = "routespeicher";
					String string = ausgabe;
					FileOutputStream fos = null;
					try {
						fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fos.write(string.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


					
					
				}
				 
			});
			newb.setOnClickListener(new OnClickListener() {
				 
				public void onClick(View arg0) {
					    Intent intent = new Intent(GRoutePath.this, Groute.class);
				        startActivity(intent);
					
				}
				 
			});
			home.setOnClickListener(new OnClickListener() {
				 
				public void onClick(View arg0) {
					    Intent intent = new Intent(GRoutePath.this,Gstart.class);
				        startActivity(intent);
					
				}
				 
			});

}
}