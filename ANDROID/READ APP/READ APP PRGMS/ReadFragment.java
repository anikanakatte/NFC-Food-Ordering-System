package com.example.nfc_ordering_system_readapp;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import com.Database.AES_Encryption;
import com.Database.DataBaseHelper;
import com.Database.GenerateRandomNumber;
import com.Database.KeySet;
import com.Database.User;
import com.Database.XOR_Operation;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.IntentFilter.MalformedMimeTypeException;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.AsyncTask;
import android.os.Bundle;

import android.telephony.SmsManager;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ReadFragment extends Activity
{

	public static final String MIME_TEXT_PLAIN = "text/plain";
	public static final String TAG = "NfcDemo";
	public static TextView testMag,textencry,otptextview;
	private NfcAdapter mNfcAdapter;
	
	EditText editText,otppassword;
	ImageButton button;
	 String qrcodepin="";
	String tag_data="";
	
	DataBaseHelper baseHelper;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.read);
		SharedPreferences sp1=this.getSharedPreferences("Login",0);
	qrcodepin=sp1.getString("pin", null);       
		 			System.out.println("qrcodepin is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+qrcodepin);	
		Intent intent = getIntent();
		
	editText = (EditText) findViewById(R.id.encrypteddata);
		button = (ImageButton) findViewById(R.id.readdata);
		
		//Validation
		testMag = (TextView) findViewById(R.id.validate);
		
		
		textencry = (TextView) findViewById(R.id.encrypt);
	
		otptextview = (TextView) findViewById(R.id.otppass);
		
		//EditText for OTP
		otppassword = (EditText) findViewById(R.id.otp);
		
		mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
		
		 // Intent intent = getIntent();
        //  String patientid= intent.getStringExtra("patientid");
          
         
          
          //Toast.makeText(getApplicationContext(),"patient id is recieved in read fragment "+patientid,Toast.LENGTH_LONG).show();
			
		 try
		 {
			 if (mNfcAdapter == null) 
		        {
		            // Stop here, we definitely need NFC
		            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
		            //finish();
		            //return;
		        }
		     
		        if (!mNfcAdapter.isEnabled()) 
		        {
		        	testMag.setText("NFC is disabled.");
		        }
		        else 
		        {
		        	testMag.setText("Detected NFC TAG Content :\n");
		        }
		         
		        handleIntent(getIntent());
		        
		        button.setOnClickListener(new OnClickListener()
		        {
					
					@Override
					public void onClick(View v)
					{
						
						String tag_data = editText.getText().toString();
						
						// Split NFC Datas
		            	String[] empInfo = tag_data.split("~");
		            	
		            	String empno = empInfo[0];
		            	String empname = empInfo[1];
		            	String frommobile = empInfo[2];
		            	String tomobile = empInfo[3];
		            	
		            	String user_otp = otppassword.getText().toString();
		            	
		            	baseHelper = new DataBaseHelper(getApplicationContext());
		            	KeySet k = baseHelper.Get_OTP(Integer.parseInt(empno));
		            	
		            	String otp = k.getEmpOtp();
		            	
		            	if(user_otp.trim().equals(otp.trim()))
		            	{

		            		Calendar currentDate = Calendar.getInstance();
		         			SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
		         			String date = formatter.format(currentDate.getTime());
		         			
		         			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm");
		         			String time = formatter1.format(currentDate.getTime());
		         			
		         			String dt = date+" "+time;
		         			
		         			// MSG Sending to Manager
			            	SmsManager smsManager = SmsManager.getDefault();
			            	String sms = " Employee No: "+empno+" Employee Name :"+empname+" Date and Time :"+dt;
							//System.out.println("smsManager " + smsManager);
							smsManager.sendTextMessage(tomobile, null, sms, null,null);
							Toast.makeText(getApplicationContext(),"SMS has been Sent to Manager ",Toast.LENGTH_LONG).show();
						
							
		            	}
		            	else
		            	{
		            	Toast.makeText(getApplicationContext(), "OTP Invalid  Please Try Again",5000).show();
		            	}
		            	
					}
				});
		        
		 }catch(Exception exception)
		 {
			
			 Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show();
			 testMag.setText(exception.toString());
		 }
	}

	public void showCustomAlert() {

		Context context = getApplicationContext();
		// Create layout inflator object to inflate toast.xml file
		LayoutInflater inflater = getLayoutInflater();

		// Call toast.xml file for toast layout
		View toastRoot = inflater.inflate(R.layout.success, null);

		Toast toast = new Toast(context);

		// Set layout to toast
		toast.setView(toastRoot);
		toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,
				0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();

	}
	
	@Override
    protected void onResume() {
        super.onResume();
         
       /*//**
         It's important, that the activity is in the foreground (resumed). Otherwise
          an IllegalStateException is thrown. 
         //*
*/        setupForegroundDispatch(this, mNfcAdapter);
    }
     
    @Override
    protected void onPause() 
    {
        /**
         * Call this before onPause, otherwise an IllegalArgumentException is thrown as well.
         */
        stopForegroundDispatch(this, mNfcAdapter);
         
        super.onPause();
    }
     
    @Override
    protected void onNewIntent(Intent intent) { 
        /**
         * This method gets called, when a new Intent gets associated with the current activity instance.
         * Instead of creating a new activity, onNewIntent will be called. For more information have a look
         * at the documentation.
         * 
         * In our case this method gets called, when the user attaches a Tag to the device.
         */
        handleIntent(intent);
    }
    
    @SuppressLint("NewApi")
	private void handleIntent(Intent intent) 
    {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action))
        {
             
            String type = intent.getType();
            if (MIME_TEXT_PLAIN.equals(type)) 
            {
     
                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
               new NdefReaderTask().execute(tag);
                 
            } else 
            {
                Log.d(TAG, "Wrong mime type: " + type);
            }
        } 
        else if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action))
        {
             
            // In case we would still use the Tech Discovered Intent
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            String[] techList = tag.getTechList();
            String searchedTech = Ndef.class.getName();
             
            for (String tech : techList) 
            {
                if (searchedTech.equals(tech))
                {
                   new NdefReaderTask().execute(tag);
                    break;
                }
            }
        }
        
        System.out.println(".....");
        
    }
    
    /**
     * Background task for reading the data. Do not block the UI thread while reading. 
     * 
     * @author Ralf Wondratschek
     *
     */
    private class NdefReaderTask extends AsyncTask<Tag, Void, String> 
    {
     
        @SuppressLint("NewApi")
		@Override
        protected String doInBackground(Tag... params)
        {
            Tag tag = params[0];
             
            Ndef ndef = Ndef.get(tag);
            if (ndef == null) {
                // NDEF is not supported by this Tag. 
                return null;
            }
     
            NdefMessage ndefMessage = ndef.getCachedNdefMessage();
     
            NdefRecord[] records = ndefMessage.getRecords();
            for (NdefRecord ndefRecord : records) 
            {
                if (ndefRecord.getTnf() == NdefRecord.TNF_WELL_KNOWN && Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
                    try 
                    {
                    	tag_data = readText(ndefRecord);
                    	
                        return readText(ndefRecord);
                    } catch (UnsupportedEncodingException e)
                    {
                        Log.e(TAG, "Unsupported Encoding", e);
                    }
                }
            }
     
            return tag_data;
        }
         
        @SuppressLint("NewApi")
		private String readText(NdefRecord record) throws UnsupportedEncodingException 
        {
            /*
             * See NFC forum specification for "Text Record Type Definition" at 3.2.1 
             * 
             * http://www.nfc-forum.org/specs/
             * 
             * bit_7 defines encoding
             * bit_6 reserved for future use, must be 0
             * bit_5..0 length of IANA language code
             */
     
            byte[] payload = record.getPayload();
     
            // Get the Text Encoding
            String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
     
            // Get the Language Code
            int languageCodeLength = payload[0] & 0063;
             
            // String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
            // e.g. "en"
             
            // Get the Text
            return new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
        }
         
        @SuppressWarnings("unused")
		@SuppressLint("NewApi")
		@Override
        protected void onPostExecute(String result) 
        {
            if (result != null)
            {
            	//editText.setText(result.trim());
            	textencry.setVisibility(1);
            	editText.setVisibility(1);
            	baseHelper = new DataBaseHelper(getApplicationContext());
            	
            	try 
            	{
            		
            		 Intent intent = getIntent();
                     String patientid= intent.getStringExtra("patientid");
                //  Toast.makeText(getApplicationContext(),"result is >>>>>>>>>>>>>>>>>"+result,Toast.LENGTH_LONG).show();
            		System.out.println("result is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+result);
            		
            		
            	
            	
            	
            		System.out.println("its came inside the post exicute method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            		
            		//Toast.makeText(getApplicationContext(), "XOR Process Start", 5000).show();
					
            		//String decrypteddata = AES_Encryption.decrypt(result, "1111111111aaaaaa");
            		String s1="Bangalore is a Garden City in India";
            		byte out1[]=XOR_Operation.xorWithData(s1.getBytes(), result.getBytes());
            		
            		String s4=new String(out1);
            		System.out.println("Output  is<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<:"+s4.trim());
            		
            		//Toast.makeText(getApplicationContext(), "XOR Process End"+s4, 5000).show();
            		
           

				
				 
				 editText.setText(s4);
				 
				 
				 editText.setKeyListener(null); 
				 editText.setEnabled(false);
            		String s = editText.getText().toString().trim();
            		
            		String dd[]=	s.split("~");
            		
                	String pin=	dd[0];
                	System.out.println("pin is >>>"+pin);
                	String tno=	dd[1];	
                	System.out.println("tno is >>>"+tno);
                	
                	 SharedPreferences sp=getSharedPreferences("table", 0);
    				 SharedPreferences.Editor Ed=sp.edit();
    				 Ed.putString("tableno",tno);              
    				
    				 Ed.commit();
    				// Toast.makeText(getApplicationContext(),"YOUR qrcodepin IS VALIDATED"+qrcodepin,Toast.LENGTH_LONG).show();
    				 
    				// Toast.makeText(getApplicationContext(),"YOUR PIN IS VALIDATED"+pin,Toast.LENGTH_LONG).show();
            		if(pin.equals(qrcodepin)) 
            		{
            			
            			
            			  Toast.makeText(getApplicationContext(),"YOUR PIN IS VALIDATED",Toast.LENGTH_LONG).show();
            			Intent intentdata=new Intent(getApplicationContext(),Temporvary.class);
            		
            			startActivity(intentdata);
            			
            		}
            		
            		else
            		{
            			
            			
            			 Toast.makeText(getApplicationContext(),"YOUR PIN IS NOT MATCHING",Toast.LENGTH_LONG).show();
            			Intent intentdata=new Intent(getApplicationContext(),ReadFragment.class);
            			
            			startActivity(intentdata);
            			
            			
            			
            		}
            		 
            		 
            		
            		/*
					int otp = GenerateRandomNumber.generatePin();
					
					
					
					String[] empInfo = s4.split("~");
					// Split NFC Datas
	            	//String[] empInfo = s.split("~");
	            	//Toast.makeText(getApplicationContext(), "Length "+empInfo.length, 5000).show();
					
	            	String empno = empInfo[0];
	            	//Toast.makeText(getApplicationContext(), "empno "+empno, 5000).show();
					
	            	String empname = empInfo[1];
	            	//Toast.makeText(getApplicationContext(), "empname "+empname, 5000).show();
					
	            	String frommobile = empInfo[2];
	            	//Toast.makeText(getApplicationContext(), "frommobile "+frommobile, 5000).show();
	            	
	            	String tomobile = empInfo[3];
	            	
	            	//Toast.makeText(getApplicationContext(), "tomobile "+tomobile, 5000).show();
	            	
	            	boolean flag = baseHelper.Check_Empno(empno);
	            	
	            	//Toast.makeText(getApplicationContext(), "Employee No "+flag, 5000).show();
	            	
	            	if(flag)
	            	{
	            		//Toast.makeText(getApplicationContext(),"Update OTP",Toast.LENGTH_LONG).show();
		            	
	            		int flg= baseHelper.Update_OTP(""+otp,empno);
	            		
	            		//System.out.println("Update Status :"+flg);
	            		
	            		//Toast.makeText(getApplicationContext(),"OTP Start to Send",Toast.LENGTH_LONG).show();
		            	
		            	// OTP Sending Start
		            	SmsManager smsManager = SmsManager.getDefault();
		            	String sms = "Your One Time Password is "+otp;
						//System.out.println("smsManager " + smsManager);
						smsManager.sendTextMessage(frommobile, null, sms, null,null);
						
						Toast.makeText(getApplicationContext(),"OTP has been Sent to Employee ",Toast.LENGTH_LONG).show();
					
		            	otptextview.setVisibility(1);
		            	otppassword.setVisibility(1);
		            	button.setVisibility(1);
		            	
	            	}
	            	else
	            	{

	            		//Toast.makeText(getApplicationContext(),"Insert OTP",Toast.LENGTH_LONG).show();
		            	
	            		
		            	boolean flg= baseHelper.inserKey(new KeySet(empno, ""+otp));
		            	
		            	//Toast.makeText(getApplicationContext(),"OTP Insertion "+flg,Toast.LENGTH_LONG).show();
		            	
		            	//Toast.makeText(getApplicationContext(),"OTP Start to Send",Toast.LENGTH_LONG).show();
		            	
		            	// OTP Sending Start
		            	SmsManager smsManager = SmsManager.getDefault();
		            	String sms = "Your One Time Password is "+otp;
						//System.out.println("smsManager " + smsManager);
						smsManager.sendTextMessage(frommobile, null, sms, null,null);
						Toast.makeText(getApplicationContext(),"OTP has been Sent to Employee ",Toast.LENGTH_LONG).show();
					
		            	otptextview.setVisibility(1);
		            	otppassword.setVisibility(1);
		            	button.setVisibility(1);
		            	
	            	}
	            	*/
					
				}
            	catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	
            }
        }
    }
    
    /**
     * @param activity The corresponding {@link Activity} requesting the foreground dispatch.
     * @param adapter The {@link NfcAdapter} used for the foreground dispatch.
     */
    @SuppressLint("NewApi")
	public static void setupForegroundDispatch(final Activity activity, NfcAdapter adapter) 
    {
        final Intent intent = new Intent(activity.getApplicationContext(), activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
 
        final PendingIntent pendingIntent = PendingIntent.getActivity(activity.getApplicationContext(), 0, intent, 0);
 
        IntentFilter[] filters = new IntentFilter[1];
        String[][] techList = new String[][]{};
 
        // Notice that this is the same filter as in our manifest.
        filters[0] = new IntentFilter();
        filters[0].addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filters[0].addCategory(Intent.CATEGORY_DEFAULT);
        try
        {
            filters[0].addDataType(MIME_TEXT_PLAIN);
        }
        catch (MalformedMimeTypeException e)
        {
            throw new RuntimeException("Check your mime type.");
        }
         
        adapter.enableForegroundDispatch(activity, pendingIntent, filters, techList);
    }
 
    /**
     * @param activity The corresponding {@link BaseActivity} requesting to stop the foreground dispatch.
     * @param adapter The {@link NfcAdapter} used for the foreground dispatch.
     */
    @SuppressLint("NewApi")
	public static void stopForegroundDispatch(final Activity activity, NfcAdapter adapter) 
    {
        adapter.disableForegroundDispatch(activity);
    }
    

}
