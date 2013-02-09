package john.daniel.lek;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int toggle;
	Button button1, sharedPref;
	TextView text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Skapa lite variabler och koppla ihop dem med saker i xml
        toggle = 0;
        button1 = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
        sharedPref = (Button) findViewById(R.id.sharedPref);
        
        //Sök efter ett knapptryck på "button1"
        button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Ignorera det som har med toggle att göra. 
				toggle++;
				text.setText("" + toggle);
				//Starta aktiviteten "NewScreen.class"
				Intent intent = new Intent(MainActivity.this, NewScreen.class); 
				startActivity(intent);
			}
		});
        
        //Knapp SharedPreferences och knapp ontrycksökare.
        sharedPref.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Starta aktiviteten "SharedPrefs.class"
				Intent intent = new Intent(MainActivity.this, SharedPref.class);
				startActivity(intent);
			}
		});
    }
    @Override
    //Jag vet inte vad det här är. 
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
