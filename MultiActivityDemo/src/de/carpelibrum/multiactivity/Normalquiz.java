package de.carpelibrum.multiactivity;

import de.carpelibrum.multiactivity.R;
import de.carpelibrum.multiactivity.R.id;
import de.carpelibrum.multiactivity.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Normalquiz extends Activity implements OnClickListener {
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
    			spiel.auswerten(1, this, leben);
    			//progress1.setProgress(progress1.getProgress()+1);
    			//tview1.setText("Verbleibende Fragen " + (10-progress1.getProgress()));
    		}
    		else if (id == R.id.antwortB){
    			spiel.auswerten(2,this, leben);
    			//progress1.setProgress(progress1.getProgress()+1);
    			//tview1.setText("Verbleibende Fragen " + (10-progress1.getProgress()));
    		}
    		else if (id == R.id.antwortC){
    			spiel.auswerten(3,this,leben);
    			//progress1.setProgress(progress1.getProgress()+1);
    			//tview1.setText("Verbleibende Fragen " + (10-progress1.getProgress()));
    			
    		}
    		else if (id == R.id.antwortD){
    			spiel.auswerten(4,this,leben);
    			//progress1.setProgress(progress1.getProgress()+1);
    			//tview1.setText("Verbleibende Fragen " + (10-progress1.getProgress()));
    		}
    		if (progress1.getProgress()>=progress1.getMax()-1){
    			progress1.setProgress(progress1.getProgress()+1);
    			tview1.setText("Alle Fragen beantwortet. Das Spiel ist vorbei");
    		}
    		else {
	    			progress1.setProgress(progress1.getProgress()+1);
	    			tview1.setText("Verbleibende Fragen " + (10-progress1.getProgress()));
    		}
   }
    		
    		    			
 
    	
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normalquiz);
        
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

