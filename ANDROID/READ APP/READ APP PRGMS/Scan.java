package com.example.nfc_ordering_system_readapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class Scan extends Activity
{
	TextView result;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan);

	
		//result = (TextView)findViewById(R.id.res);
		Intent intent1 = new Intent("com.google.zxing.client.android.SCAN");
        intent1.putExtra("SCAN_MODE", "QR_CODE_MODE");
         
        /* Use PRODUCT_MODE for reading Bar Code
         * intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
         */
         
         startActivityForResult(intent1, 0);
	}
	
	@Override
    public void onActivityResult(int requestCode, int resultCode,Intent intent) 
    {
    	 if (requestCode == 0)
    	 {
             if (resultCode == RESULT_OK) 
             {
                 String contents = intent.getStringExtra("SCAN_RESULT");
                 String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                 // Handle successful scan
               //  result.setText(contents);
                 Toast toast = Toast.makeText(this, "YOUR PIN IS :" + contents + " Format:" + format , Toast.LENGTH_LONG);
                 
             	
				 SharedPreferences sp=getSharedPreferences("Login", 0);
				 SharedPreferences.Editor Ed=sp.edit();
				 Ed.putString("pin",contents);              
				
				 Ed.commit();
                 
                 toast.setGravity(Gravity.TOP, 25, 400);
                 
                 toast.show();
                // String link="http://www.drivehq.com/file/DFPublishFile.aspx/FileID3094943766/Keyxurl02w78ab0/housephoto2.jpg";
                 Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                 intent1.putExtra("password", contents);
                
 				   startActivity(intent1);	
 				
             } 
             else 
             {
                 // Handle cancel
                 Toast toast = Toast.makeText(this, "Scan was Cancelled!", Toast.LENGTH_LONG);
                 toast.setGravity(Gravity.TOP, 25, 400);
                 toast.show();
             }
         }
    }
}
