package com.example.nfc_ordering_system_readapp;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.HttpClient.Global;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;


public class Temporvary extends Activity {
	String type="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temporvary);
		 SharedPreferences sp1=this.getSharedPreferences("table",0);
	    	String tableno=sp1.getString("tableno", null);       
	    		 			System.out.println("tableno is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tableno);
		
	    		 			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    		 			Date date = new Date();
	    		 			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
  
        String dt=dateFormat.format(date);
        RequestParams params = new RequestParams();
    	params.put("tableno", tableno);
    	params.put("dt", dt);
     invokeWS(params,"data");
 
	}
 	public void invokeWS(RequestParams params,String data)
 	{
 		 AsyncHttpClient client = new AsyncHttpClient();
          client.get(Global.URL+"fetch/category",params ,new AsyncHttpResponseHandler()
          {
         	
              @Override
              public void onSuccess(String response)
              {
             	 
                  try {
                 	 		
                	  
                	  
                 	       System.out.println("ur response is :"+response);
                 	    
                 	      
                         	JSONObject obj = new JSONObject(response);
                         	
                   boolean flag=     obj.getBoolean("status");
 	                        type=obj.getString("type");
 	                         System.out.println("type is >>>>>>>"+type);
 	                         
 	                    String    items=obj.getString("items");
 	                        
 	                  System.out.println("items is >>>>>>>>>>>>>>>>>>"+items);
 	                         
 	               
 	                      //   Toast.makeText(getApplicationContext(), "type"+type, Toast.LENGTH_LONG).show();
 	                     	System.out.println("Output "+type.trim());
 	                 		
 	                    	String	 dataaa= type.replace("[", "").replace("]", "");	
 	                 	 //  Toast.makeText(getApplicationContext(), "dataaa"+dataaa, Toast.LENGTH_LONG).show();
 	                 	
 	                 	 SharedPreferences sp=getSharedPreferences("dd", 0);
 	    				 SharedPreferences.Editor Ed=sp.edit();
 	    				 Ed.putString("dataaa",dataaa);              
 	    				 Ed.putString("items",items); 
 	    				 Ed.commit();
 	                 	   
 	                 	   
 	                 	   
 	                 	   Intent intent=new Intent(getApplicationContext(),MenuDetails.class);
 	                      startActivity(intent);
 	                      
                  } 
                  catch (JSONException e) {
                  
                      Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                      e.printStackTrace();
                      
                  }
              }
              // When the response returned by REST has Http response code other than '200'
              @Override
              public void onFailure(int statusCode, Throwable error,
                  String content) {
                 
                  if(statusCode == 404){
                      Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                  } 
                 
                  else if(statusCode == 500){
                      Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                  } 
                 
                  else{
                      Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                  }
              }
          });
 	
 		
 		
 		
 	}
        
        
        
        
        
        
        
        
        
        
        
	}

	

