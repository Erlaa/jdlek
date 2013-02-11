package john.daniel.lek;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPref extends Activity{
	String savedName, savedValue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_pref);
		
		Button kill, save, get;
		
		//save botton.
		save = (Button) findViewById(R.id.prefSave);
		save.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Hitta och namnge textEdit-rutorna
				EditText name, value;
				name = (EditText) findViewById(R.id.editText1);
				//det som står i textrutan "name" sparas till en variable vid namn "savedName"
				savedName = name.getText().toString();
				
				value = (EditText) findViewById(R.id.editText2);
				//det som står i textrutan "value" sparas till en variable vid namn "savedValue"
				savedValue = value.getText().toString();
				
				//Skapa SharedPreferneces. SharedPreferenses kan hålla namn och en "inställning" som hör ihop med det namnet. T.ex ScreenOn(namn) = true(inställning)
				SharedPreferences settings = getSharedPreferences("MyPrefFile", 0); //Sparas i filen "MePrefFile"
				SharedPreferences.Editor editor = settings.edit(); //Skapar en hanterare
				//Save the value and give it a name
				editor.putString(savedName, savedValue); //Hanteraren stoppar in variabeln "savedName" som namn på inställningen och "savedValue" som värde
				editor.commit(); //Lägg till förändringarna i inställningsfilen.
			}
		});
		
		
		
		//Hitta "getAll()" knappen och sök efter ett klick
		get = (Button) findViewById(R.id.getAllButton);
		get.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Hitta textfältet under knapparna
				TextView output;
				output = (TextView) findViewById(R.id.getAllOutP);
				
				//Skapa SharedPreferences hanterare.
				SharedPreferences settings = getSharedPreferences("MyPrefFile", 0);
				//Hämtar alla med .getAll() från SharedPreferences, alltså hämtar den alla "inställningar" och namn och lägger de i en sträng
				String AllPreferneces = settings.getAll().toString();
				
				//Ändra textfältet till det som fanns bland SharedPreferences
				output.setText(AllPreferneces);
			}
		});
		
		
		//Döda Aktiviteten-knappen. Sök efter ett tryck. 
		kill = (Button) findViewById(R.id.sharedPrefKill);
		kill.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Avsluta aktiviteten.
				finish();
			}
		});
		
	}
	
}
