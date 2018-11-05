package com.example.nfc_ordering_system_readapp;



import org.json.JSONException;
import org.json.JSONObject;

import com.HttpClient.Global;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Totalamount extends Activity {
	TextView  info;
	Button  customerr;
	Button  pin;
	String uid;
	String tableno="";
	String onum="";
	Button  tap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.totalamount);
		 SharedPreferences sp11=this.getSharedPreferences("table",0);
	 	    tableno=sp11.getString("tableno", null);       
	 	    		 			System.out.println("tableno is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tableno);
	 	    		 			
	 	    		 			
	 	    		 			
	 	    		 			
	 	    		 			 SharedPreferences sp111=this.getSharedPreferences("or",0);
	 	    		 			onum=sp111.getString("onum", null);       
	 	    			 	    		 			System.out.println("onum is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+onum);  		 			
	 	    		 			
	 	    		 			
	 	    		 	
	 	    			 	    		 			
	 	    			 	    		 			
	 	    			 	    		 		 SharedPreferences sp1111=this.getSharedPreferences("uidd",0);
	 	    			 	    		 		uid=sp1111.getString("uid", null);       
	 	    		 	    			 	    		 			System.out.println("uid is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+uid);  		 			
	 	    		 	    		 					 
	 	    		 			
		info=(TextView)findViewById(R.id.total);
		   RequestParams params = new RequestParams();
 			
				params.put("tableno", tableno);
				params.put("orderno", onum);
				params.put("uid", uid);
				invokeWS(params,"data");
		
	}

    public void invokeWS(RequestParams params,String data)
	{
		// Show Progress Dialog
		// prgDialog.show();
		 // Make RESTful webservice call using AsyncHttpClient object
		 AsyncHttpClient client = new AsyncHttpClient();
         client.get(Global.URL+"total/amount",params ,new AsyncHttpResponseHandler()
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
	                         
	                         boolean       flag=obj.getBoolean("status");
	                         System.out.println("flag is >>>>>>>"+flag);
	                         
	 	                 	   
	                     info.setText(type+" "+"Rs");
	                          
	                     
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
