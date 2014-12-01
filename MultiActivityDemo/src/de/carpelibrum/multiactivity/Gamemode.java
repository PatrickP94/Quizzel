package de.carpelibrum.multiactivity;


import de.carpelibrum.multiactivity.R;
import de.carpelibrum.multiactivity.R.id;
import de.carpelibrum.multiactivity.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Gamemode extends Activity implements OnClickListener {
private Button normalmode;
private Button timemode;
private Button survivalmode;
private Button helpus; 
private Button highscore;
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
        //Überlebensmodus
        survivalmode = (Button) this.findViewById(R.id.lifemode);
        survivalmode.setOnClickListener(this);
        //Helpus
        helpus = (Button) this.findViewById(R.id.helpus);
        helpus.setOnClickListener(this);
        //Highscore
        highscore = (Button) this.findViewById(R.id.highscore);
        highscore.setOnClickListener(this);
    }

	public void onClick(View v) {
		
		if(v == normalmode){
			Intent intent = new Intent(this, Normalquiz.class);
			startActivity(intent);
		}
		else if(v == timemode){
			Intent intent = new Intent (this, Timequiz.class);
			startActivity(intent);
		}
		else if(v == survivalmode){
			Intent intent = new Intent (this, SurvivalQuiz.class);
			startActivity(intent);
		}
		else if(v==helpus){
			Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://goo.gl/forms/rPvX0twdfO"));
			startActivity(browserIntent);
		}
		else if(v==highscore){
			 setContentView(R.layout.highscore);
		}
	
	}
}