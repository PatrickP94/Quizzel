package de.carpelibrum.multiactivity;

import de.carpelibrum.multiactivity.R.id;
import android.app.Activity;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Button;


class Frage {
	private String frage;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private int lösung;
	
	public Frage (String f, String o1, String o2, String o3, String o4, int l){
		frage =f;
		option1 = o1;
		option2 = o2;
		option3 = o3;
		option4 = o4;
		lösung = l;
	}
	
	public void anzeigen(Activity quizActivity){
		
	
		((TextView) quizActivity.findViewById(id.frage)).setText(frage);
		((Button) quizActivity.findViewById(id.antwortA)).setText(option1);
		((Button) quizActivity.findViewById(id.antwortB)).setText(option2);	
		((Button) quizActivity.findViewById(id.antwortC)).setText(option3);
		((Button) quizActivity.findViewById(id.antwortD)).setText(option4);	
	}
	
	public boolean richtig (int ausgewählt, Activity quizActivity){
		switch (lösung){
		case 1: 
			((Button) quizActivity.findViewById(id.antwortA)).setBackgroundColor(Color.GREEN);
			break;
		case 2: 
			((Button) quizActivity.findViewById(id.antwortB)).setBackgroundColor(Color.GREEN);
			break;
		case 3: 
			((Button) quizActivity.findViewById(id.antwortC)).setBackgroundColor(Color.GREEN);
			break;
		case 4: 
			((Button) quizActivity.findViewById(id.antwortD)).setBackgroundColor(Color.GREEN);
			break;
		}
		
		if (ausgewählt == this.lösung)
			return true;
		else
			return false;
	}
}