package hellospinner.packag;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class Gstart extends Activity {
    /** Called when the activity is first created. */
	Boolean sound=false;
	Button options,start,credits,load;
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gstart);
	    addListenerOnButton();
	  }
	  public void addListenerOnButton() {
			 
			start = (Button) findViewById(R.id.button1);
			options = (Button) findViewById(R.id.button2);
			credits = (Button) findViewById(R.id.button3);
			load = (Button) findViewById(R.id.button4); 

			options.setOnClickListener(new OnClickListener() {
	 
				public void onClick(View arg0) {
					    Intent intent = new Intent(Gstart.this, Goptions.class);
				        startActivity(intent);


					
					
				}
				 
			});
					start.setOnClickListener(new OnClickListener() {
					 
					public void onClick(View arg0) {
						    Intent intent = new Intent(Gstart.this, Groute.class);
					        startActivity(intent);


						
						
					}
			  });
					credits.setOnClickListener(new OnClickListener() {
						 
						public void onClick(View arg0) {
							    Intent intent = new Intent(Gstart.this, gCredits.class);
						        startActivity(intent);


							
							
						}
				  });
					load.setOnClickListener(new OnClickListener() {
						 
						public void onClick(View arg0) {
							    Intent intent = new Intent(Gstart.this,GLoadRoute.class);
						        startActivity(intent);
						        //finishActivity(5);
						        //System.out.println("wird noch ausgeführt");
						        //finish();
						        


							
							
						}
						 
					});
	  }
}
