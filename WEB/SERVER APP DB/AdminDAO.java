package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;






public class AdminDAO
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	private static AdminDAO daoProcess=null;
	
	public static AdminDAO getInstance()
	{
		if(daoProcess == null)
		{
			daoProcess= new AdminDAO();
		}
		return daoProcess;
	}
	
	public static ArrayList<String> fetchcategory()
	{
		
		ArrayList<String> dd=new ArrayList<String>();
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select cat_name from m_category";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				
				System.out.println("ddddddddd");
				dd.add(resultSet.getString(1));
			}
			System.out.println("fetchcategory "+dd);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return dd;
	}
	
	public static ArrayList<String> fetchcid()
	{
		
		ArrayList<String> dd=new ArrayList<String>();
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select c_id from m_category";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				
				System.out.println("ddddddddd");
				dd.add(resultSet.getString(1));
			}
			System.out.println("fetchcategory "+dd);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return dd;
	}
	
	
	
	public static ArrayList<String> paticularitemlist(String cid)
	{
		
		ArrayList<String> dd=new ArrayList<String>();
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select item_name from m_items where c_id='"+cid+"'";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				
				System.out.println("ddddddddd");
				dd.add(resultSet.getString(1));
			}
			System.out.println("fetchcategory "+dd);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return dd;
	}
	
	public static boolean checkitemExistance(String item,String cat)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select * from m_items where c_id='"+cat+"' and item_name='"+item+"'";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("checkitemExistance "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean checkcategoryuserExistance(String cat)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select * from m_category where cat_name='"+cat+"'";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("checkcategoryuserExistance(String cat) "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	public static boolean checkvehivleExistance(String vregno)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select * from m_vehicledetails where v_regno='"+vregno+"'";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("vehcile Existance : "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static ResultSet fetchcrdnumbers()
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select v_cardno from m_vehicledetails";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet fetchvehicletypenumbers()
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select * from m_vtype ";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static boolean checkadminexistance(String username,String pass)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select * from m_admin where admin_id='"+username+"' and admin_password='"+pass+"'";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("ADMIN Existance : "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	public static boolean checksupportuserexistance(String username,String pass)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select * from  m_supportuser where s_name='"+username+"' and s_pass='"+pass+"'";
			statement=	connection.createStatement();
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Existance : "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	
	
	
	public static boolean addsupportuserDetails(String name,
			String pass, String age, String sex,
			String role, String phone, String mail) {
		
		System.out.println("its acme inside addsupportuserDetails >>>>>>>>>>>>>>>>>>");
		
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "insert into m_supportuser(s_name,s_pass,s_age,s_sex,s_role,s_phone,s_mail) values('"+name+"','"+pass+"','"+age+"','"+sex+"','"+role+"','"+phone+"','"+mail+"')";
			statement=	connection.createStatement();
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
		
		
	}

	public static boolean insertordernumber(String tno,
			String dt) {
		
		System.out.println("its acme inside insertordernumber >>>>>>>>>>>>>>>>>>");
		
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "insert into m_order(datee_timee,table_no) values('"+dt+"','"+tno+"')";
			statement=	connection.createStatement();
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
		
		
	}
	
	
	public static boolean additemDetails(String cat,
			String item, String price) {
		
		
		
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "insert into m_items(c_id,item_name,price) values('"+cat+"','"+item+"','"+price+"')";
			statement=	connection.createStatement();
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
		
		
	}
	
	public static boolean addcategoryDetails(String name) {
		
	
		
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "insert into m_category(cat_name) values('"+name+"')";
			statement=	connection.createStatement();
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
		
		
	}

	
	public static boolean checkadmin(String admin_id,String pass)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select * from m_admin where admin_id='"+admin_id+"' and admin_password='"+pass+"'";
		statement=	connection.createStatement();
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}

	
	public static boolean checksupportuser(String admin_id,String pass)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select * from m_supportuser where s_name='"+admin_id+"' and s_pass='"+pass+"'";
		statement=	connection.createStatement();
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			flg = true;
		}
		//System.out.println("Search status:"+flg);
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	public static int gettotal(String fname)
	{
		int total=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select weightage from t_count where f_no=(select f_no from m_file where f_name='"+fname+"')";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=total+resultSet.getInt(1);
		}
		System.out.println("Total:"+total);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}

	public static ResultSet getKeyword_Weight()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select t_no,f_no,key_word,weightage,key_rank from t_count ";
		statement=	connection.createStatement();
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}

	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	





	

	public static ResultSet getsupportUserdetails() 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement=	connection.createStatement();
			resultSet = statement.executeQuery("select * from m_supportuser");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	public static ResultSet getitemsdetails() 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement=	connection.createStatement();
			resultSet = statement.executeQuery("select * from m_items");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getcategorydetails() 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement=	connection.createStatement();
			resultSet = statement.executeQuery("select * from m_category");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet getsupportUserdetails(String id) 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement=	connection.createStatement();
			resultSet = statement.executeQuery("select * from m_supportuser where s_no='"+id+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getitemsdetails(String id) 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement=	connection.createStatement();
			resultSet = statement.executeQuery("select * from m_items where item_no='"+id+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet getcategorydetails(String id) 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement=	connection.createStatement();
			resultSet = statement.executeQuery("select * from m_category where c_id='"+id+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	public static ResultSet getcategory() 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement=	connection.createStatement();
			resultSet = statement.executeQuery("select * from m_category");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	
	public static boolean updatesupportusersDetails(ArrayList<String> list) {
		
			boolean flag=false;
			String sql = "";
			int i=0;
			try
			{
				DAO dao=DAO.getInstance();
				connection=dao.connector();
				sql = "update m_supportuser set s_name='"+list.get(1)+"',s_age='"+list.get(3)+"',s_sex='"+list.get(4)+"' ,s_role='"+list.get(6)+"',s_phone='"+list.get(2)+"',s_mail='"+list.get(5)+"' where s_no='"+list.get(0)+"'";
				statement=	connection.createStatement();
				System.out.println(sql);
				i = statement.executeUpdate(sql);
				if(i>0)
				{
					flag=true;
				}
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
			return flag;
		}
	public static boolean updateitemsDetails(ArrayList<String> list) {
		
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "update m_items set c_id='"+list.get(1)+"',item_name='"+list.get(2)+"',price='"+list.get(3)+"' where item_no='"+list.get(0)+"'";
			statement=	connection.createStatement();
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}

	
	public static boolean updatecategoryDetails(ArrayList<String> list) {
		
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "update m_category set cat_name='"+list.get(1)+"' where c_id='"+list.get(0)+"'";
			statement=	connection.createStatement();
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
	}

	
	
 




}