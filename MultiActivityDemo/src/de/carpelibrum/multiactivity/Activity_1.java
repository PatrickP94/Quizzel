package de.carpelibrum.multiactivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity_1 extends Activity implements OnClickListener {
private Button normalmode;
private Button timemode;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playmode);
        //Normalmodus
        normalmode  = (Button) this.findViewById(R.id.normalmode);
        normalmode.setOnClickListener(this);
        //Timemodus
        timemode  = (Button) this.findViewById(R.id.timemode);
        timemode.setOnClickListener(this);
    }

	public void onClick(View v) {
		
		if(v==normalmode){
			Intent intent = new Intent(this, Normalquiz.class);
			startActivity(intent);
		}
		else if(v==timemode){
			Intent intent = new Intent (this, Timequiz.class);
			startActivity(intent);
		}
		
    }
	
}