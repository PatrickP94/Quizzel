package de.carpelibrum.multiactivity;

import de.carpelibrum.multiactivity.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Timequiz extends Activity implements OnClickListener {
	Spiellogik spiel;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private ProgressBar progress1;
    private TextView tview1;
    private TextView tview2;
    int zähler = 0;
    int leben =-1;
    
    	public void onClick(View v){
    		int id = v.getId();
    		
    		if (id == R.id.antwortA){
    			spiel.auswerten(1, this,leben);
    		}
    		else if (id == R.id.antwortB){
    			spiel.auswerten(2,this,leben);
    		}
    		else if (id == R.id.antwortC){
    			spiel.auswerten(1, this,leben);
    		}
    		else if (id == R.id.antwortD){
    			spiel.auswerten(1, this,leben);
    		}
    		
    		    			
    }
    	
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timequiz);
        
        spiel = new Spiellogik();
        
       btnA =(Button) findViewById(R.id.antwortA);
       btnA.setOnClickListener(this);
       btnB =(Button) findViewById(R.id.antwortB);
       btnB.setOnClickListener(this);
       btnC =(Button) findViewById(R.id.antwortC);
       btnC.setOnClickListener(this);
       btnD =(Button) findViewById(R.id.antwortD);
       btnD.setOnClickListener(this);
       progress1 =(ProgressBar) findViewById(R.id.progressBar1);
       tview1 = (TextView) findViewById(R.id.textView2);
       
       spiel.fragen[spiel.aktFrage].anzeigen(this);
    }



	
}

