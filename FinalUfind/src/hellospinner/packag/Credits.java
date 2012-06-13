package hellospinner.packag;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Credits extends Activity {
	Button cancel;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);
		addListenerOnButton();
    }
	public void addListenerOnButton() {
	cancel = (Button) findViewById(R.id.button1);	
	cancel.setOnClickListener(new OnClickListener() {
		 
		public void onClick(View arg0) {
			finish();
			
		}
		 
	});
	}
}
