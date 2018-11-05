package com.example.nfc_ordering_system_readapp;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.HttpClient.CustomHttpClient;
import com.HttpClient.Global;
import com.HttpClient.Utility;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerRegistration extends Activity {
	EditText cust_name,cust_email,cust_phone,cust_address; 
	Button save;
String sttus="";
	public static String c_name="",c_mail="",c_addrs="", c_phone="" ;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_customer_registration);
      
        if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
			        new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			}
        save=(Button)findViewById(R.id.Save);
        cust_name = (EditText)findViewById(R.id.cust_name);
        cust_email =(EditText)findViewById(R.id.cust_email);
        cust_phone =(EditText)findViewById(R.id.cust__number);
        cust_address =(EditText)findViewById(R.id.cust_adress);
        
        
        
       save.setOnClickListener(new OnClickListener() {
		
    	   @Override
			public void onClick(View v) {
    		 
		    		 c_name = cust_name.getText().toString();
		    		 		System.out.println(c_name);
		    		 c_mail = cust_email.getText().toString();
		    			System.out.println(c_mail);
		    		 c_phone = cust_phone.getText().toString();
		    		 System.out.println(c_phone);
		    		 c_addrs = cust_address.getText().toString();
		    		 System.out.println(c_addrs);
		    		 
		    		 
		    			RequestParams params = new RequestParams();
    		 
    		 
    		 
		    			if(Utility.isNotNull(c_name) && Utility.isNotNull(c_mail) && Utility.isNotNull(c_phone) && Utility.isNotNull(c_addrs) )
						{
							
							
							
							
							
								params.put("name", c_name);
								// Put Http parameter password with value of Password Edit Value control
								params.put("mail", c_mail);
								params.put("phone", c_phone);
								
								params.put("add", c_addrs);
								// Invoke RESTful Web Service with Http parameters
								String att_type=invokeWS(params,"data");
							
						} 
						// When any of the Edit View control left blank
						else
						{
							Toast.makeText(getApplicationContext(), "Please fill the form, don't leave any field blank", Toast.LENGTH_LONG).show();
						
						}
						
    		 
    		 
    		  
			}
    	   	
       });
     
      
	}
	
	public String invokeWS(RequestParams params,String data)
	{
		// Show Progress Dialog
		// prgDialog.show();
		 // Make RESTful webservice call using AsyncHttpClient object
		 AsyncHttpClient client = new AsyncHttpClient();
         client.get(Global.URL+"custdetails/empupdate",params ,new AsyncHttpResponseHandler()
         {
        	 // When the response returned by REST has Http response code '200'
             @Override
             public void onSuccess(String response)
             {
            	 // Hide Progress Dialog
            	// prgDialog.hide();
                 try {
                	 		System.out.println("=============================");
                	       System.out.println("ur response is :"+response);
                	    /*   Toast.makeText(getApplicationContext(), "##"+response, 1500).show();*/
                	       System.out.println("=============================");
                	       // JSON Object
                        	JSONObject obj = new JSONObject(response);
                        	// When the JSON response has status boolean value assigned with true
                       
	                         String type=obj.getString("type");
	                         System.out.println("type is >>>>>>>"+type);
	                       /*  Toast.makeText(getApplicationContext(), "from web server>>>>>"+type, Toast.LENGTH_LONG).show();*/
	                         
	                         if(obj.getBoolean("status") && type.equals("success") )
	                         {
	                        	
	                        	 Toast.makeText(getApplicationContext(), "Customer Registered Successfully", Toast.LENGTH_LONG).show();
	                        	 
	                        	 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
	                        	 startActivity(intent);
	                        	 
	                         } 
	                         else if(type.equals("exists"))
	                         {
	                        	 Toast.makeText(getApplicationContext(), "User Already Exists", Toast.LENGTH_LONG).show();
	                        	 
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
		return sttus;
	}

	
}
