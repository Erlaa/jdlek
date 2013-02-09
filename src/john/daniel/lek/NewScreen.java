package john.daniel.lek;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_screen);
		
		Button kill = (Button) findViewById(R.id.kill);
		
		//Sšk efter knapptryck
		kill.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//Avsluta aktiviteten
				finish();
			}
		});
	}

}
