package com.example.nfc_ordering_system_readapp;



import org.json.JSONException;
import org.json.JSONObject;

import com.HttpClient.Global;
import com.HttpClient.Utility;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QrCodeScanningPAge extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qr_code_scanning_page);
		
	Button btn=	(Button) findViewById(R.id.scan);
	final EditText txt=	(EditText) findViewById(R.id.uid);
		btn.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				
	String uid=		txt.getText().toString();
	
	System.out.println("uid is >>>>>>>>>>>>>>>>>"+uid);
	
	 SharedPreferences sp=getSharedPreferences("uidd", 0);
	 SharedPreferences.Editor Ed=sp.edit();
	 Ed.putString("uid",uid);              
	
	 Ed.commit();
	
	RequestParams params = new RequestParams();
	 
	 
	 
	if(Utility.isNotNull(uid)  )
	{
		
		
		
		
		
			params.put("name", uid);
		
		invokeWS(params,"data");
		
	} 
	// When any of the Edit View control left blank
	else
	{
		Toast.makeText(getApplicationContext(), "Please fill the form, don't leave any field blank", Toast.LENGTH_LONG).show();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		   
			}
		});
		
		
	}

	
	public void invokeWS(RequestParams params,String data)
	{
		
		 AsyncHttpClient client = new AsyncHttpClient();
         client.get(Global.URL+"cid/check",params ,new AsyncHttpResponseHandler()
         {
        	 
             @Override
             public void onSuccess(String response)
             {
            	 
                 try {
                	 		
                	       System.out.println("ur response is :"+response);
                	   
                	    
                        	JSONObject obj = new JSONObject(response);
                        
                       
	                         String type=obj.getString("type");
	                         System.out.println("type is >>>>>>>"+type);
	                     
	                         
	                         if(obj.getBoolean("status")==true && type.equals("success") )
	                         {
	                        	
	                        	 Toast.makeText(getApplicationContext(), "Dear Customer Scan Your QR code", Toast.LENGTH_LONG).show();
	                        	 
	                        	 Intent intent=new Intent(getApplicationContext(),Scan.class);
	                        	 startActivity(intent);
	                        	 
	                         } 
	                         else 
	                         {
	                        	 Toast.makeText(getApplicationContext(), "Error in generating QR code", Toast.LENGTH_LONG).show();
	                        	 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
	                        	 startActivity(intent);
	                         }
                         
                         
                         
                         
                         /*// Else display error message
                         else{
                        	// errorMsg.setText(obj.getString("error_msg"));
                        	 Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
                         }*/
                 } 
                 catch (JSONException e) {
                     // TODO Auto-generated catch block
                     Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                     e.printStackTrace();
                     
                 }
             }
             // When the response returned by REST has Http response code other than '200'
             @Override
             public void onFailure(int statusCode, Throwable error,
                 String content) {
                 // Hide Progress Dialog 
                 //prgDialog.hide();
                 // When Http response code is '404'
                 if(statusCode == 404){
                     Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                 } 
                 // When Http response code is '500'
                 else if(statusCode == 500){
                     Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                 } 
                 // When Http response code other than 404, 500
                 else{
                     Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                 }
             }
         });
		
	}

}
