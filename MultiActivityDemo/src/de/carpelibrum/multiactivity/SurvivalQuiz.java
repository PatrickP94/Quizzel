package de.carpelibrum.multiactivity;

import de.carpelibrum.multiactivity.R;
import de.carpelibrum.multiactivity.R.id;
import de.carpelibrum.multiactivity.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SurvivalQuiz extends Activity implements OnClickListener {

    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private ProgressBar progress1;
    private TextView tview1;
    private TextView tview2;
    int z�hler = 0;
    
    private OnClickListener btnListener = new OnClickListener(){
    	public void onClick(View v){
    		String text="";
    		if (progress1.getProgress()>0){
    		if (v==btnA){
    			text="Falsche Antwort";
    			btnD.setBackgroundColor(Color.GREEN);
    			btnA.setBackgroundColor(Color.RED);
    			progress1.setProgress(progress1.getProgress()-1);
    		}
    		if (v==btnB){
    			text="Falsche Antwort";
    			btnD.setBackgroundColor(Color.GREEN);
    			btnB.setBackgroundColor(Color.RED);
    			progress1.setProgress(progress1.getProgress()-1);
    		}
    		if (v==btnC){
    			text="Falsche Antwort";
    			btnD.setBackgroundColor(Color.GREEN);
    			btnC.setBackgroundColor(Color.RED);
    			progress1.setProgress(progress1.getProgress()-1);

    		}
    		if (v==btnD) {
    			text="Richtige Antwort";
    			btnD.setBackgroundColor(Color.GREEN);
    			z�hler=z�hler+1; 			
    		}
    		
    		
    		tview1.setText("Sie haben nur noch "+progress1.getProgress()+" Leben");
    		Toast einToast = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);
    		einToast.show();
    	}
    	else{
    		progress1.setBackgroundColor(Color.RED);
    		tview1.setText("Du hast keine Leben mehr! GAME OVER");
    		text="Richtig beantwortete Fragen: "+z�hler;
    		Toast einToast = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);
    		einToast.show();
    		}
    	}
    
    };
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survivalquiz);
        
       btnA =(Button) findViewById(R.id.antwortA);
       btnA.setOnClickListener(btnListener);
       btnB =(Button) findViewById(R.id.antwortB);
       btnB.setOnClickListener(btnListener);
       btnC =(Button) findViewById(R.id.antwortC);
       btnC.setOnClickListener(btnListener);
       btnD =(Button) findViewById(R.id.antwortD);
       btnD.setOnClickListener(btnListener);
       progress1 =(ProgressBar) findViewById(R.id.progressBar1);
       tview1 = (TextView) findViewById(R.id.textView2);
       tview2 = (TextView) findViewById(R.id.high);
    }
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}


	
}

