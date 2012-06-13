package hellospinner.packag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;



public class Route extends Activity {
	
		String selected,selected2;
		Spinner s,s2;
		Button go;
	    // declare a WebView object first
		WebView mWebView = null;
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.wview);
	        // load view
	        mWebView = (WebView)findViewById(R.id.web);
	        // (*) this line make uses of the Zoom control
	        mWebView.getSettings().setBuiltInZoomControls(true);
	        // simply, just load an image
	        mWebView.loadUrl("file:///android_asset/wien.png");
	        mWebView.getZoomControls();
	        mWebView.getSettings().setSupportZoom(true); 
	        mWebView.getSettings().setBuiltInZoomControls(true) ; 
	        mWebView.getSettings().setLoadWithOverviewMode(true);
	        addListenerOnButton();
	        s = (Spinner) findViewById(R.id.spinner1);
	        s2 = (Spinner) findViewById(R.id.spinner2);
	        ArrayAdapter adapter = ArrayAdapter.createFromResource(
	                this, R.array.UBahn, android.R.layout.simple_spinner_item);
	       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(
	                this, R.array.UBahn, android.R.layout.simple_spinner_item);
	        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        s.setAdapter(adapter);
	        s2.setAdapter(adapter2);

	    }
	    public void addListenerOnButton() {
	    	go = (Button) findViewById(R.id.button1);
	    	go.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					selected =s.getSelectedItem().toString();
					selected2 =s2.getSelectedItem().toString();
					Intent intent = new Intent(Route.this, NewRoute.class);
					intent.putExtra("1",selected);
					intent.putExtra("2",selected2);
				    startActivity(intent);
					
				}
				 
			});
	    	
	    }
	    
	}
