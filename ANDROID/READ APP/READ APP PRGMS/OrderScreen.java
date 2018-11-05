package com.example.nfc_ordering_system_readapp;




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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View.OnClickListener;;

public  class OrderScreen extends Activity{
	TextView orderitem,devidetextview,temp;
	EditText Quantity,devide_quanity;
	 Button Place_Order;
	 String tempstring;
	 Integer i;
	 String s;
	 String quanityforsoup;
	 StringBuilder orderdata=null;
	 String item="";
	 String qua="";
	  String price="";
	  String tableno="";
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);
      
        
        orderitem =(TextView)findViewById(R.id.orderitem);
        Quantity =(EditText)findViewById(R.id.Quantity);
        Place_Order =(Button)findViewById(R.id.Place_Order_btn);
        SharedPreferences sp1=this.getSharedPreferences("table",0);
    	tableno=sp1.getString("tableno", null);       
    		 			System.out.println("tableno is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tableno);
        
        s= getIntent().getStringExtra("order");
        Toast.makeText(getApplicationContext(), "s>>>>>>>>>>"+s, Toast.LENGTH_LONG).show();	
 qua= Quantity.getText().toString();
    System.out.println("quqntity is "+qua);
        String delimiter = "-";
        
       
        String[] temp= s.split(delimiter);
      
      
        String itemname=temp[0];
      price=temp[1];
       
         item=     itemname.replace("[", "");
       
       
       orderitem.setText("You have ordered "+item);
      
       
   Place_Order.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		
		
		RequestParams params = new RequestParams();
			
			
			
			
			
				params.put("itemname", item);
			
				params.put("quality", qua);
				params.put("price", price);
				
				params.put("tableno", "1");
				
				invokeWS(params,"data");
			
		
	
		
	}
});
      
      
     
      
     
      
      
   	}
	
	public void invokeWS(RequestParams params,String data)
	{
		// Show Progress Dialog
		// prgDialog.show();
		 // Make RESTful webservice call using AsyncHttpClient object
		 AsyncHttpClient client = new AsyncHttpClient();
         client.get(Global.URL+"order/item",params ,new AsyncHttpResponseHandler()
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
		
	}

	
}