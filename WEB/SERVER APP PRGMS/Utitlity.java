package  com.server;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Utitlity {
	/**
	 * Null check Method
	 * 
	 * @param txt
	 * @return
	 */
	public static boolean isNotNull(String txt) {
		// System.out.println("Inside isNotNull");
		return txt != null && txt.trim().length() >= 0 ? true : false;
	}

	/**
	 * Method to construct JSON
	 * 
	 * @param tag
	 * @param status
	 * @return
	 */
	public static String constructJSON1(String tag, boolean status,String atttype) 
	{
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("type", atttype);
			obj.put("status", new Boolean(status));
		} 
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}
	public static String constructJSON2(String atttype,boolean status) 
	{
		JSONObject obj = new JSONObject();
		try {
		
			obj.put("type", atttype);
			obj.put("status", new Boolean(status));
			
		} 
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}
	
	public static String constructJSON5(String atttype,boolean status) 
	{
		JSONObject obj = new JSONObject();
		try {
		
			obj.put("type", atttype);
			obj.put("status", new Boolean(status));
			
		} 
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}
	public static String constructJSON3(String atttype,String items,boolean status) 
	{
		JSONObject obj = new JSONObject();
		try {
			obj.put("items", items);
			obj.put("type", atttype);
			obj.put("status", new Boolean(status));
			
		} 
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}
	
	public static String constructJSON4(String atttype,String orderno,boolean status) 
	{
		JSONObject obj = new JSONObject();
		try {
			obj.put("orderno", orderno);
			obj.put("type", atttype);
			obj.put("status", new Boolean(status));
			
		} 
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}
	
	public static String constructJSON44(String atttype,boolean status) 
	{
		JSONObject obj = new JSONObject();
		try {
		
			obj.put("type", atttype);
			obj.put("status", new Boolean(status));
			
		} 
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}
	public static String constructJSON1(String tag, String files) 
	{
		JSONObject obj = new JSONObject();
		try 
		{
			obj.put("tag", tag);
			obj.put("files",files);
		} 
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}
	
	public static String constructJSON(String tag, String list) 
	{
		JSONObject obj = new JSONObject();
		try
		{
			obj.put("tag", tag);
			obj.put("status", list);
		}
		catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}
	

	/**
	 * Method to construct JSON with Error Msg
	 * 
	 * @param tag
	 * @param status
	 * @param err_msg
	 * @return
	 */
	public static String constructJSON(String tag, boolean status,String err_msg) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("status", new Boolean(status));
			obj.put("error_msg", err_msg);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return obj.toString(); 
	}
	
}
