package hellospinner.packag;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MyOnItemSelectedListener implements OnItemSelectedListener {
	String g;
    public void onItemSelected(AdapterView<?> parent,
        View view, int pos, long id) {
        g = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView parent) {
      // Do nothing.
    }
    public String getSelectedString(){
    	return g;
    	
    
    }
}
