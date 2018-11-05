package com.example.nfc_ordering_system_readapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	Button  info;
	Button  customerr;
	Button  pin;
	Button  tap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		info=(Button)findViewById(R.id.Info);
		customerr=(Button)findViewById(R.id.customer);
		pin=(Button)findViewById(R.id.pin);
		tap=(Button)findViewById(R.id.tap);
		
		 info.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					//starting new activity on button click
					Intent i =new Intent(getApplicationContext(),InfoScreen.class);
					startActivity(i);
				}
			});
		

		 customerr.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					//starting new activity on button click
					Intent j =new Intent(getApplicationContext(),CustomerRegistration.class);
					startActivity(j);
				}
			});
		 
		 
		 
		 pin.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					//starting new activity on button click
					Intent j =new Intent(getApplicationContext(),QrCodeScanningPAge.class);
					startActivity(j);
				}
			});
		 
		 tap.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					//starting new activity on button click
					Intent j =new Intent(getApplicationContext(),ReadFragment.class);
					startActivity(j);
				}
			});
	}

   
}
