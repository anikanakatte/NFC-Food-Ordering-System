package com.example.nfc_ordering_system_readapp;





import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.HttpClient.Global;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.AlertDialog;
import android.app.ExpandableListActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class MenuDetails extends ExpandableListActivity {
	
	
	//Expandable list is used to display data
	public String cat[];
	 String     item="";
	 String type2="";
	 String tableno="";
	 String    price="";
	public static Context context;
public String [][] result;
	ExpandableListAdapter mAdapter;
	List<String[]> multiDimArray = new ArrayList<String[]>();
	List<String[]> twoDimension = new ArrayList<String[]>();
	//DatabaseHelper menuHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp1=this.getSharedPreferences("dd",0);
    	String ddd=sp1.getString("dataaa", null);       
    		 			System.out.println("ddd is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ddd);	
    		 		 	String items=sp1.getString("items", null); 		
    		 			
    		 		 	System.out.println("items is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+items);	
    		 		 	 SharedPreferences sp11=this.getSharedPreferences("table",0);
    		 	    tableno=sp11.getString("tableno", null);       
    		 	    		 			System.out.println("tableno is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+tableno);
    		 		//   Toast.makeText(getApplicationContext(), "items>>>>>>>>>>"+items, Toast.LENGTH_LONG).show();	
    	cat=		ddd.split(",");
    		//Toast.makeText(getApplicationContext(), "cat"+cat, Toast.LENGTH_LONG).show();	
    		
    		String [][] theArray = twoDimension.toArray( new String[twoDimension.size()][] );
    		
    		// String[] planets =ddd.replace("[", "").replace("]", "").trim().split(",");
    		String [] parts = items.replaceAll("\\[\\[|\\]\\]","") 
                    .split("\\],\\[");


for( String s : parts ){
 multiDimArray.add(  s.split(",") ) ;
}
result = multiDimArray.toArray( new String[multiDimArray.size()][]);


        mAdapter = new MyExpandableListAdapter();
        setListAdapter(mAdapter);
        registerForContextMenu(getExpandableListView());
        getExpandableListView().setCacheColorHint(5);
        getExpandableListView().setBackgroundResource(R.drawable.red_bg);
        
       // getExpandableListView().set
        
        
       
        
        getExpandableListView().setOnGroupClickListener(new OnGroupClickListener() {
			
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				Toast.makeText(MenuDetails.this, ((TextView)v).getText().toString(), Toast.LENGTH_SHORT).show();
				return false;
			}
		});
        
        getExpandableListView().setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Toast.makeText(MenuDetails.this, ((TextView)v).getText().toString().replace("[", "").replace("]", ""), Toast.LENGTH_LONG).show();
				String s=((TextView)v).getText().toString();
				showChangeLangDialog(s);
				/*Intent i =new Intent (MenuDetails.this, OrderScreen.class);
				i.putExtra("order", s);
				startActivity(i);*/
				return false;
			}
		});

    }
    
   
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Sample menu");
        menu.add(0, 0, 0, R.string.app_name);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) item.getMenuInfo();

        String title = ((TextView) info.targetView).getText().toString();

        int type = ExpandableListView.getPackedPositionType(info.packedPosition);
        if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition); 
            int childPos = ExpandableListView.getPackedPositionChild(info.packedPosition); 
            Toast.makeText(this, title + ": Child " + childPos + " clicked in group " + groupPos,
                    Toast.LENGTH_SHORT).show();
            return true;
        } else if (type == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
            int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition); 
            Toast.makeText(this, title + ": Group " + groupPos + " clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }

    
    public class MyExpandableListAdapter extends BaseExpandableListAdapter {
        // Sample data set.  children[i] contains the children (String[]) for groups[i].
        //items are defined here
    	
    	
    	
 
        
 
       /* private String[][] children = {
                { "Veg Manchurian Dry- 85Rs","Veg Roll- 80Rs","Paneer Manchurian- 95Rs"},
                {"Tomato- 75Rs","Veg Manchaw- 85Rs"},
                {"Veg Handi- 115Rs","Veg Makhanwala- 155Rs","Paneer Kadai- 165Rs","Butter Nan-110Rs","Cheese Kulcha- 60Rs","Paratha- 50Rs"},
                {"Hakka Noodles- 95Rs","Veg Noodles- 85Rs"},
                {"Cheez Grilled- 55Rs","Chatni Cheese- 45Rs" },
                { "Thums UP- 15Rs","Sprite- 15Rs","Maza- 15Rs" },
                { "Mango Juice- 55Rs","Orange Juice- 45Rs","Grap Juice- 65Rs","Apple Juice- 75Rs"},
                {"Black forest- 65Rs","White Forest- 65Rs","Pina Strawbery- 55Rs"}
              
                
        };*/

        public Object getChild(int groupPosition, int childPosition) {
        	
        	
            return result[groupPosition][childPosition];
        }

        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        public int getChildrenCount(int groupPosition) {
            return result[groupPosition].length;
        }

        public TextView getGenericView() {
            // Layout parameters for the ExpandableListView
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, 64);

            TextView textView = new TextView(MenuDetails.this);
            textView.setLayoutParams(lp);
            // Center the text vertically
            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
            // Set the text starting position
            textView.setPadding(36, 0, 0, 0);
           
            return textView;
        }

        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                View convertView, ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        public Object getGroup(int groupPosition) {
            return cat[groupPosition];
        }

        public int getGroupCount() {
            return cat.length;
        }

        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                ViewGroup parent) {
            TextView textView = getGenericView();
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        public boolean hasStableIds() {
            return true;
        }

    }
    
    
    public void showChangeLangDialog(String s) {
    	
    	  String delimiter = "-";
          
          
          String[] temp= s.split(delimiter);
        
        
         
    price=temp[1];
         
          item=     temp[0].replace("[", "");
          item=  temp[0].replace("]", "");
         
        
    	
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);

        dialogBuilder.setTitle("You have ordered "+item);
        dialogBuilder.setMessage("Enter the Quantity");
        dialogBuilder.setPositiveButton("AddOrder", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) 
            {
            	  String qua=     edt.getText().toString();
                  
                  System.out.println("quqntity is"+qua);
            	
                  RequestParams params = new RequestParams();
      			
      			
      			
      			
      			
  				params.put("itemname", item);
  			
  				params.put("quality", qua);
  				params.put("price", price);
  				
  				params.put("tableno", tableno);
  				
  				invokeWS(params,"data");
        
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton)
            {
            	
            	
            	


            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
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
	                         
	                         String orderno=obj.getString("orderno");
	                         
	                    	 SharedPreferences sp=getSharedPreferences("or", 0);
	 	    				 SharedPreferences.Editor Ed=sp.edit();
	 	    				 Ed.putString("listt",type);              
	 	    				 Ed.putString("onum",orderno);   
	 	    				 Ed.commit();
	 	                 	   
	                       /*  Toast.makeText(getApplicationContext(), "from web server>>>>>"+type, Toast.LENGTH_LONG).show();*/
	                         
	                       /*  if(obj.getBoolean("status") && type.equals("success") )
	                         {
	                        	
	                        	 Toast.makeText(getApplicationContext(), "Customer Registered Successfully", Toast.LENGTH_LONG).show();
	                        	 
	                        	 Intent intent=new Intent(getApplicationContext(),MainActivity.class);
	                        	 startActivity(intent);
	                        	 
	                         } 
	                         else if(type.equals("exists"))
	                         {
	                        	 Toast.makeText(getApplicationContext(), "User Already Exists", Toast.LENGTH_LONG).show();
	                        	 
	                         }
                         */
                         
                         
                         
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

    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.homemenu, menu);
        return true;
    }
     
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.orderdetails:
           
            Toast.makeText(MenuDetails.this, "Dear Customer Your Ordered list is", Toast.LENGTH_SHORT).show();
           
		   Intent i = new Intent(getApplicationContext(), OrderList.class);
       
            startActivity(i);
            return true;
            
      
 
        case R.id.tamount:
            Toast.makeText(MenuDetails.this, "Dear Customer Your Total Amount is", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(getApplicationContext(), Totalamount.class);
            startActivity(intent1);
            return true;
 
       
 
        case R.id.logout:
            Toast.makeText(MenuDetails.this, "Thank For Visiting Our Hotel,Come Again:)", Toast.LENGTH_SHORT).show();
          
            Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
           
          
            
            startActivity(intent2);
            return true;
            
    
       
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }   
    
    @Override
	public void onBackPressed()
	{
		Intent intent1 = new Intent(this,MenuDetails.class);
		startActivity(intent1);
		
	}
  
		
	
}