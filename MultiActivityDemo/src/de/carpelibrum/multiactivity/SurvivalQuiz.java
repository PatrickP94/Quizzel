package de.carpelibrum.multiactivity;

import de.carpelibrum.multiactivity.R;
import de.carpelibrum.multiactivity.R.id;
import de.carpelibrum.multiactivity.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.sax.EndElementListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SurvivalQuiz extends Activity implements OnClickListener {
	Spiellogik spiel;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private ProgressBar progress1;
    private TextView tview1;
    private TextView tview2;
    int leben = 3;
    int zähler =0;
    private View mainLayout; 
	MediaPlayer mediaplayer = new MediaPlayer();
	
    	public void onClick(View v){
    		int id = v.getId();
    		int stufe = spiel.gewinnstufe;
    		zähler++;
    		
    		if (id == R.id.antwortA){
    			spiel.auswerten(1, this,leben);
    		}
    		else if (id == R.id.antwortB){
    			spiel.auswerten(2,this,leben);
    		}
    		else if (id == R.id.antwortC){
    			spiel.auswerten(3,this,leben);
    		}
    		else if (id == R.id.antwortD){
    			spiel.auswerten(4,this,leben);
    		}
    		if(stufe==spiel.gewinnstufe){
    			leben=leben-1;
    			tview2.setText(" "+leben);
    		}
    		if(leben == 0){
				btnA.setEnabled(false);
				btnB.setEnabled(false); //damit keiner einen Button drückt bevor Frage kommt
				btnC.setEnabled(false);
				btnD.setEnabled(false);
				String str = "Du hast keine Leben mehr. Game Over. Gespielte Fragen "+zähler;
				Toast.makeText(this, str, Toast.LENGTH_LONG).show();
				mainLayout.setBackgroundResource(R.drawable.skull);
				mediaplayer  = MediaPlayer.create(this, R.raw.scream);
				mediaplayer.start();
    		}
    		    			
    }
    	
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survivalquiz);
        
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
       tview2 = (TextView) findViewById(R.id.leben);
       mainLayout = (View) findViewById(R.id.SurvivalQuizView); 
       
       spiel.fragen[spiel.aktFrage].anzeigen(this);
    }



	
}

