package de.carpelibrum.multiactivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity_1 extends Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playmode);
        Button activity2Button  = (Button) this.findViewById(R.id.normalmode);
        activity2Button.setOnClickListener(this);
    }

	public void onClick(View v) {

		//  Activity 2 starten
		Intent intent = new Intent(this, Activity_2.class);
		this.startActivity(intent);
	}


    
}