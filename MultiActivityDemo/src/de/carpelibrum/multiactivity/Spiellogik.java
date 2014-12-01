package de.carpelibrum.multiactivity;

import de.carpelibrum.multiactivity.R.id;
import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.TextView;


class Spiellogik {
	int ANZAHL_FRAGEN =10;
	
	Frage[] fragen = new Frage[ANZAHL_FRAGEN];
	int aktFrage =0;
	int gewinnstufe =0;
	int fortschritt=0;
	
	
	Spiellogik(){
		//Fragen erzeugen
		
		fragen[0] =
				new Frage("Wie heißt die Quiz-App, die Sie gerade spielen?","Quiz","Qu!zzel","Qu!z","Puzzle",2);
		
		fragen[1]=
				new Frage("Wer war die erste Bundeskanzlerin der Bundesrepublik Deutschland?", "Claudia Roth", "Andrea Nales", "Angela Merkel", "Gudrun Kohl",3);
		
		fragen[2]=
				new Frage("Welches Element hat die Ordnungszahl 1?", "Helium", "Sauerstoff", "Natrium", "Wasserstoff",4);
		
		fragen[3]=
				new Frage("Wie viele Jünger hatte Jesus Christus um sich versammelt?", "Zwei", "Zwölf", "Zwanzig", "Zweiunddreißig",2);
		
		fragen[4]=
				new Frage ("Was feiern die Deutschen am 1.Mai?", "Tag der Arbeit", "Tag der Deutschen Einheit", "Allerheiligen", "Christi Himmelfahrt",1);
		
		fragen[5]=
				new Frage ("Was ist das flächenmäßig größte Organ des Menschen?", "Leber", "Lunge", "Haut", "Magen",3);
		
		fragen[6]=
				new Frage ("Wer schrieb die Bücher 'Der kleine Hobbit' und 'Der Herr der Ringe?'", "Dan Brown", "Charlotte Link", "Ken Follet", "J.R.R Toliken",4);
		
		fragen[7]=
				new Frage ("Welches ist KEIN Album der Toten Hosen",  "Krach der Republik", "Atlantis", "Ballast der Republik", "Bis zum Bitteren Ende", 2);
		
		fragen[8]=
				new Frage ("Was bedeutet 'Carpe diem'?", "Nutze den Tag", "Lebe dein Leben", "Stirb langsam", "Gott segne dich", 1);
		
		fragen[9]=
				new Frage ("Welche Fußballnationalmannschaft gewann die WM 2014?", "England", "Argentinien", "Brasilien", "Deutschland",4);
		
	}
	
	
	void auswerten (int schalter, final Activity quizActivity, int leben){  //schalter = gedrückter Button

			
		if (!fragen[aktFrage].richtig(schalter, quizActivity)){ //falsche Antwort
			fortschritt++;
			leben--;
			switch (schalter){
			case 1: 
				
				((Button) quizActivity.findViewById(id.antwortA)).setBackgroundColor(Color.RED);
				break;
			case 2: 
				((Button) quizActivity.findViewById(id.antwortB)).setBackgroundColor(Color.RED);
				break;
			case 3: 
				((Button) quizActivity.findViewById(id.antwortC)).setBackgroundColor(Color.RED);
				break;
			case 4: 
				((Button) quizActivity.findViewById(id.antwortD)).setBackgroundColor(Color.RED);
				break;
			}
			if (aktFrage < ANZAHL_FRAGEN-1 && leben !=0 ){ //keine Fragen oder kein Leben mehr
				((Button) quizActivity.findViewById(id.antwortA)).setEnabled(false);
				((Button) quizActivity.findViewById(id.antwortB)).setEnabled(false); //damit keiner einen Button drückt bevor Frage kommt
				((Button) quizActivity.findViewById(id.antwortC)).setEnabled(false);
				((Button) quizActivity.findViewById(id.antwortD)).setEnabled(false);
				
				Handler handler = new Handler(); 
				handler.postDelayed(new Runnable() { 
			         public void run() { 
			        	 fragen[++aktFrage].anzeigen(quizActivity);
			        	 ((Button) quizActivity.findViewById(id.antwortA)).setEnabled(true);
						((Button) quizActivity.findViewById(id.antwortB)).setEnabled(true);
						((Button) quizActivity.findViewById(id.antwortC)).setEnabled(true);
						((Button) quizActivity.findViewById(id.antwortD)).setEnabled(true);
			        	((Button) quizActivity.findViewById(id.antwortA)).setBackgroundColor(Color.GRAY);
			     		((Button) quizActivity.findViewById(id.antwortB)).setBackgroundColor(Color.GRAY);
			     		((Button) quizActivity.findViewById(id.antwortC)).setBackgroundColor(Color.GRAY);
			     		((Button) quizActivity.findViewById(id.antwortD)).setBackgroundColor(Color.GRAY);
			         } 
			    }, 2000); 
			}
			
			Toast.makeText(quizActivity, "Falsche Antwort", Toast.LENGTH_LONG).show();
		}
		
		else {
			if (aktFrage < ANZAHL_FRAGEN-1 && leben !=0){
				gewinnstufe++;
				fortschritt++;
				//((ProgressBar) quizActivity.findViewById(id.progressBar1)).setProgress(fortschritt);
				//((TextView) quizActivity.findViewById(id.textView2)).setText("Verbleibende Fragen " + (10-fortschritt));
				((Button) quizActivity.findViewById(id.antwortA)).setEnabled(false);
				((Button) quizActivity.findViewById(id.antwortB)).setEnabled(false);
				((Button) quizActivity.findViewById(id.antwortC)).setEnabled(false);
				((Button) quizActivity.findViewById(id.antwortD)).setEnabled(false);
				Handler handler = new Handler(); 
				handler.postDelayed(new Runnable() { 
			         public void run() { 
			        	 fragen[++aktFrage].anzeigen(quizActivity);
					((Button) quizActivity.findViewById(id.antwortA)).setEnabled(true);
						((Button) quizActivity.findViewById(id.antwortB)).setEnabled(true);
						((Button) quizActivity.findViewById(id.antwortC)).setEnabled(true);
						((Button) quizActivity.findViewById(id.antwortD)).setEnabled(true);
			        	((Button) quizActivity.findViewById(id.antwortA)).setBackgroundColor(Color.GRAY);
			     		((Button) quizActivity.findViewById(id.antwortB)).setBackgroundColor(Color.GRAY);
			     		((Button) quizActivity.findViewById(id.antwortC)).setBackgroundColor(Color.GRAY);
			     		((Button) quizActivity.findViewById(id.antwortD)).setBackgroundColor(Color.GRAY);
			         } 
			    }, 2000); 
				String str = "Richtige Antwort :-)";
				Toast.makeText(quizActivity, str, Toast.LENGTH_LONG).show();
			}
				else {
					fortschritt++;
					gewinnstufe++;
					//((ProgressBar) quizActivity.findViewById(id.progressBar1)).setProgress(fortschritt);
					//((TextView) quizActivity.findViewById(id.textView2)).setText("Alle Fragen beantwortet. Das Spiel ist vorbei");
					String str = "Super, "+gewinnstufe+" von 10 Fragen richtig beantwortet";
					Toast.makeText(quizActivity, str, Toast.LENGTH_LONG).show();
					
					((Button) quizActivity.findViewById(id.antwortA)).setEnabled(false);
					((Button) quizActivity.findViewById(id.antwortB)).setEnabled(false);
					((Button) quizActivity.findViewById(id.antwortC)).setEnabled(false);
					((Button) quizActivity.findViewById(id.antwortD)).setEnabled(false);
			}
		
		}
	}
	
}
