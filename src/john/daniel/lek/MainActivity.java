package john.daniel.lek;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = (ListView) findViewById(R.id.mylist);
        String[] values = new String[] { "Aktiviteter", "SharedPreferences" };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter); 
        
        listView.setOnItemClickListener(new OnItemClickListener() {
        	  @Override
        	  public void onItemClick(AdapterView<?> parent, View view,
        	    int position, long id) {
        	    Toast.makeText(getApplicationContext(),
        	      "Click ListItem Number " + position, Toast.LENGTH_LONG)
        	      .show();
        	    
        	    if (position == 0){
        	    	Intent intent = new Intent(MainActivity.this, NewScreen.class);
        	    	startActivity(intent);
        	    }
        	    else if (position == 1){
        	    	Intent intent = new Intent(MainActivity.this, SharedPref.class);
        	    	startActivity(intent);
        	    }
        	  }
        	}); 
    }
}