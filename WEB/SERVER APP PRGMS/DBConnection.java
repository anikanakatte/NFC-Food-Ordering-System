package  com.server;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBConnection {
	/**
	 * Method to create DB Connection
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public static Connection createConnection() throws Exception {
		Connection con = null;
		try {
			Class.forName(Constants.dbClass);
			con = DriverManager.getConnection(Constants.dbUrl, Constants.dbUser, Constants.dbPwd);
		} catch (Exception e) {
			throw e;
		} finally {
			return con;
		}
	}
    
	public static boolean insertEmployeeDetails(String name, String phn,String mail,String add,String pin) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "INSERT into m_customer(name,phone,mail,address,pin) values('"+name+ "','"+phn+"','"+mail+"','"+add+"','"+pin+"')";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//When record is successfully inserted
			if (records > 0) 
			{
				insertStatus = true;
			}
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	
	public static boolean updateamount(int price, String tno,int orderno,String stsus,String itemname,String qua,String prr) throws SQLException, Exception {
		boolean insertStatus = false;
		boolean insertStatus1 = false;
		Connection dbConn = null;
		int total=0;
		String st="yes";
		int amount=0;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			Statement stmt = dbConn.createStatement();
			String query = "update m_order set amount='"+price+"' where table_no='"+Integer.parseInt(tno)+"' and order_no='"+orderno+"' and status='"+stsus+"' ";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//When record is successfully inserted
			if (records > 0) {
				insertStatus = true;
			}
		if(insertStatus)
		{
		String gg=	itemname.replace("[", "");
		String ina=	gg.replace("[", "");
			Statement stmt1 = dbConn.createStatement();
			String query1 = "update t_order set status_order='"+st+"' where item_name='"+ina.trim()+"' and order_no='"+orderno+"' and quantity='"+Integer.parseInt(qua)+"' and price='"+prr.trim()+"'";
			System.out.println(query1);
			int records1 = stmt1.executeUpdate(query1);
			//System.out.println(records);
			//When record is successfully inserted
			if (records1 > 0) {
				insertStatus1 = true;
			}
			
			
			
			
		}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} 
		catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus1;
	}
	/*public static boolean updateTotalWork() throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "update m_employee set logout_time='"+time+"' where emp_id='"+empno+"' and emp_name='"+empName+"' and date='"+date+"' ";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//When record is successfully inserted
			if (records > 0) {
				insertStatus = true;
			}
		} 
		catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	*/
	public static boolean checkcustDetails(String user) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select * from m_customer where name='"+user+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				insertStatus = true;
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return insertStatus;
	}
	public static int selecttotalamount(String tno,String ono) throws SQLException, Exception {
		boolean insertStatus = false;
		int price=0;
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select amount from m_order where order_no='"+tno+"' and table_no='"+ono+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
			price=	records.getInt(1);
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return price;
	}
	
	public static String getusermailid(String uid) throws SQLException, Exception {
		boolean insertStatus = false;
		String mail="";
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select mail from m_customer where name='"+uid+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				mail=	records.getString(1);
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return mail;
	}
	
	public static ArrayList<String> selectitems(String ono) throws SQLException, Exception {
		boolean insertStatus = false;
		ArrayList<String> data=new ArrayList<String>();
		StringBuffer sb=new StringBuffer();
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select * from t_order where order_no='"+ono+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				data.add(records.getString(3)+"           "+records.getString(4)+"      "+records.getString(5));
		
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return data;
	}
	
	
	
	
	
	
	
	public static int takeamount(String tno,int ordernum,String ssttus) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		int amount=0;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt1 = dbConn.createStatement();
			String query1 = "select amount from m_order where order_no='"+ordernum+"' and table_no='"+Integer.parseInt(tno)+"' and status='"+ssttus+"'";
			System.out.println(query1);
			ResultSet rs = stmt1.executeQuery(query1);
			while(rs.next())
			{
				
			amount=	rs.getInt(1);
				
			}
		
		System.out.println("amount amount is >>>>>>>>>>>>>>>>>>>"+amount);
			//System.out.println(records);
			//When record is successfully inserted
			
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return amount;
	}
	
	public static ArrayList<String> getordereddetails(int ordernum) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		ResultSet rs=null;
		int amount=0;
		ArrayList<String> ll=new ArrayList<String> ();
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt1 = dbConn.createStatement();
			String query1 = "select * from t_order where order_no='"+ordernum+"'";
			System.out.println(query1);
			 rs = stmt1.executeQuery(query1);
			 while(rs.next())
				{
					ll.add(rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5));
					
					
					
				}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return ll;
	}
	
	public static int selectordernum(String tno) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		int i=0;
		String sts="process";
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select order_no from m_order where table_no='"+tno+"' and status='"+sts+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				i=records.getInt(1);
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return i;
	}
	
	public static String getpinuser(String user) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		String pin="";
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select pin from m_customer where name='"+user+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				
			pin=	records.getString(1);
				
			
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return pin;
	}
	public static String getmailuser(String user) throws SQLException, Exception {
		boolean insertStatus = false;
		Connection dbConn = null;
		String mail="";
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "select mail from m_customer where name='"+user+"'";
			System.out.println(query);
			ResultSet records = stmt.executeQuery(query);
			//System.out.println(records);
			//When record is successfully inserted
			while(records.next())
			{
				
			mail=	records.getString(1);
				
			
			}
		
		} catch (SQLException sqle) {
			//sqle.printStackTrace();
			throw sqle;
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			if (dbConn != null) {
				dbConn.close();
			}
			throw e;
		} finally {
			if (dbConn != null) {
				dbConn.close();
			}
		}
		return mail;
	}
	
	public static double getCompLatitude()
	{
		String sql="";
		double latitude = 0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select latitude from m_complocation where lo_code='1'";
			System.out.println("********** Getting Bus Latitude By busRouteNumber **********");
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				latitude = resultSet.getDouble(1);
				
			}
			System.out.println(" Latitude : [1]: "+latitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusStatus(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return latitude;
	}
	
	public static double getCompLongitude()
	{
		String sql="";
		double longitude = 0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select longitude from m_complocation where lo_code='1'";
			System.out.println("********** Getting Bus Longitude By busRouteNumber **********");
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				longitude = resultSet.getDouble(1);
			}
			System.out.println("comp Longitude : [1]: "+longitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusLongitude(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return longitude;
	}
	
	public static double getEmpLatitude(String emp_id)
	{
		String sql="";
		double latitude = 0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select latitude from m_emplylocation where emp_code='"+emp_id+"' order by lo_code desc limit 1";
			System.out.println("********** Getting Bus Latitude By busRouteNumber **********");
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				latitude = resultSet.getDouble(1);
				
			}
			System.out.println(" Latitude : [1]: "+latitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusStatus(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return latitude;
	}
	
	public static double getEmpLongitude(String emp_id)
	{
		String sql="";
		double longitude = 0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select longitude from m_emplylocation where emp_code='"+emp_id+"' order by lo_code desc limit 1";
			System.out.println("********** Getting Bus Longitude By busRouteNumber **********");
			System.out.println(sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while(resultSet.next())
			{
				longitude = resultSet.getDouble(1);
			}
			System.out.println("comp Longitude : [1]: "+longitude);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getBusLongitude(String busRouteNumber) : ");
			e.printStackTrace();
		}
		return longitude;
	}
	
	
	public static ResultSet selectitems(int i)
	{
		String sql="";
		
		String statsu="no";
		double longitude = 0;
		ResultSet resultSet =null;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "select * from t_order where order_no='"+i+"' and status_order='"+statsu+"'";
			
			System.out.println(sql);
		 resultSet = stmt.executeQuery(sql);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>selectitems : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	public static boolean insertorderdetails(int oid,String item,String qua,String price,String dte)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		Connection dbConn = null;
		try
		{
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			sql = "insert into t_order(order_no,item_name,quantity,price,dte) values('"+oid+"','"+item+"','"+Integer.parseInt(qua)+"','"+price+"','"+dte+"')";
		
			System.out.println(sql);
			i = stmt.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in insertorderdetails: ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
