package com.example.nfc_ordering_system_readapp;

import java.util.ArrayList;
import java.util.Arrays;



import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class OrderList extends Activity {
	  ArrayAdapter <String> adapter ;
	  ArrayList<String> ll=new ArrayList<String> ();
	  ArrayList<String> planetList = new ArrayList<String>(); 
	  static String s1;
	  static String s2;
	  String tableno="";
	  Button gotomenu,placedorder;
	  ListView mainListView ;  
	  private ArrayAdapter<String> listAdapter ;  
	  static String s;
	  String cust_name,phone,email,order,address;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.orderlist);  
	     
	        SharedPreferences sp1=this.getSharedPreferences("or",0);
	    	String ddd=sp1.getString("listt", null);       
	    	 SharedPreferences sp11=this.getSharedPreferences("table",0);
		 	    tableno=sp11.getString("tableno", null);       
		 	    		 			System.out.println("tableno is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tableno);			
	    	
	    	    
	    	 
	    	   
	    	      
	    	    // Find the ListView resource.   
	    	    mainListView = (ListView) findViewById(R.id.mainListView );  
	    	  
	    	    // Create and populate a List of planet names.  
	    	    String[] planets =ddd.replace("[", "").replace("]", "").trim().split(",");
	    	    
	    	    planetList.addAll( Arrays.asList(planets) );  
	    	      
	    	    // Create ArrayAdapter using the planet list.  
	    	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, planetList);  
	    	      
	    	   
	    	    // Set the ArrayAdapter as the ListView's adapter.  
	    	    mainListView.setAdapter( listAdapter );        
	        if(planets.length==0)
	        {
	        	Toast.makeText(this, "Yet no order Is placed Please go to menu section and add order", Toast.LENGTH_LONG).show();
	        	
	        }
	       /* else{
	        	
	        	
	        	s2 = ll.get(0).toString();
	        }*/
	      /*  mainListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0,
						View view, final int position,
						long id) {
					// TODO Auto-generated method stub
					
					//order remove functioanlity on alert box button
					AlertDialog.Builder builder =new AlertDialog.Builder(OrderList.this);
					builder.setTitle("Order Remove");
					builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							s=(String)mainListView.getItemAtPosition(position);
							
							adapter.notifyDataSetChanged();
						}
					});
					builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
					AlertDialog alt=builder.create();
					alt.show();
				}
			});*/
	       
	    
	 }
	 
	    // Initiating Menu XML file (menu.xml)
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu)
	    {
	        MenuInflater menuInflater = getMenuInflater();
	        menuInflater.inflate(R.menu.orderlist, menu);
	        return true;
	    }
	     
	   
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item)
	    {
	         
	        switch (item.getItemId())
	        {
	        case R.id.ok:
	           
	            Toast.makeText(OrderList.this, "Dear Customer Your Ordered list is", Toast.LENGTH_SHORT).show();
	           
			   Intent i = new Intent(getApplicationContext(), MenuDetails.class);
	       
	            startActivity(i);
	            return true;
	            
	      
	 
	       
	 
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    } 
}