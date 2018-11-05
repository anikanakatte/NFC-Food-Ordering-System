package com.example.nfc_ordering_system_readapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class InfoScreen extends Activity {
	//used to displya info of app
	Button backk;
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //load layout
	        setContentView(R.layout.activity_info_screen);
	        backk=(Button)findViewById(R.id.back);
	        backk.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//starting new activity on button click
					Intent i=new Intent(getApplicationContext(),MainActivity.class);
					startActivity(i);
					
				}
			});

}
}