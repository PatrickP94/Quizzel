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
        //Normalmodus
        Button normalmode  = (Button) this.findViewById(R.id.normalmode);
        normalmode.setOnClickListener(this);
        //Timemodus
        Button timemode  = (Button) this.findViewById(R.id.timemode);
        timemode.setOnClickListener(this);
    }

	public void onClick(View v) {

		Intent intent = new Intent(this, Normalquiz.class);
		this.startActivity(intent);
	}


    
}