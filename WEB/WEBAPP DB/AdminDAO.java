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
	
	public static boolean checksupportuserExistance(String name)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "select * from m_supportuser where s_name='"+name+"'";
			
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("checksupportuserExistance(String name) "+flag);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return flag;
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
			sql = "insert into m_items(c_id,item_name,price) values('"+cat+"','"+item+"-"+price+"','"+price+"')";
			
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
	/*public static boolean addvehicleDetails(int con,
			String vt, String vm, String vr,
			String vo, String va, String ve) {
		
		System.out.println("its acme inside addvehicleDetails >>>>>>>>>>>>>>>>>>");
		
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "insert into m_vehicledetails(v_cardno,v_type,v_model,v_regno,v_owner,v_address,v_cardexp) values('"+con+"','"+vt+"','"+vm+"','"+vr+"','"+vo+"','"+va+"','"+ve+"')";
			
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
		
		
	}*/
	public static boolean checkadmin(String admin_id,String pass)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select * from m_admin where admin_id='"+admin_id+"' and admin_password='"+pass+"'";
		
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
	public static boolean clear(String tno)
	{
		int j=0;
		int orderno=0;
		boolean gg =false;
		boolean flg = false;
		try
		{
			
			String sttaus1="process";
			String sttaus="done";
			
		
			
			DAO dao1=DAO.getInstance();
			connection=dao1.connector();
			statement = connection.createStatement();
		String sql1 = "select order_no from m_order where table_no='"+Integer.parseInt(tno)+"' and status='"+sttaus1+"'";
		
		System.out.println(sql1);
		resultSet = statement.executeQuery(sql1);
		
		while(resultSet.next())
		{
			
			orderno=	resultSet.getInt(1);
			
			
			
		}
		String sql11 = "delete from t_order  where order_no='"+orderno+"'";
		
		System.out.println(sql11);
		j= statement.executeUpdate(sql11);
		if(j>0)
		{
			gg = true;
		}
		if(gg)
		{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "update  m_order  set status='"+sttaus+"' where table_no='"+Integer.parseInt(tno)+"'";
	
	System.out.println(sql);
	int i = statement.executeUpdate(sql);
	
	if(i>0)
	{
		flg = true;
	}
		
		
		}
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}
	public static ResultSet tabledetails()
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select tid from m_tabledetails";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	
	
	

	public static String gettotalamount(int tno)
	{
		ResultSet resultSett=null;
		String sttaus="process";
		String total="";
		try
		{
			String status="process";
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select amount from m_order where table_no='"+tno+"' and status='"+sttaus+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=resultSet.getString(1);
		}
		System.out.println("Total:"+total);
		
		
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}
	
	

	public static int gettotalamountss(String dte)
	{
		int tt=0;
		int ttt=0;
		ResultSet resultSett=null;
		String sttaus="process";
		String quant="";
		String price="";
		try
		{
			String status="process";
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select quantity,price from t_order where dte='"+dte+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			quant=resultSet.getString(1);
			price=resultSet.getString(2);
			
		String dd[]=	price.split(" ");
			
		price=	dd[0];
		
	ttt=	Integer.parseInt(quant)*Integer.parseInt(price);
		
	tt=	ttt+tt;
			
			
			
		}
		
		
		
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return tt;
	}
	
	
	
	
	
	public static ResultSet getorder(int tno)
	{
		ResultSet resultSett=null;
		int total=0;
		try
		{
			String status="process";
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select order_no from m_order where table_no='"+tno+"' and status='"+status+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		System.out.println("Total:"+total);
		
		
		
				DAO daoo=DAO.getInstance();
		connection=daoo.connector();
		statement = connection.createStatement();
	String sql1 = "select * from t_order where order_no='"+total+"'";
	
	
	resultSett = statement.executeQuery(sql1);
	
	
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSett;
	}

	public static ResultSet getKeyword_Weight()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select t_no,f_no,key_word,weightage,key_rank from t_count ";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}

	
	
	public static int getFile_total(String fname)
	{
		int total=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select total from m_file where f_name='"+fname+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		System.out.println("Total:"+total);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}
	// taking s_no of the grades
	
	public static ResultSet getUserdetails(int sno)
	{
		//ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select u_id,u_email,u_pass,grade from m_user where grade='"+sno+"' ";
			
			resultSet = statement.executeQuery(sql);
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	/*public static ResultSet getUserdetails(int sno)
	{
		//ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select u_id,u_email,u_pass,grade from m_user where grade='"+sno+"' ";
			
			resultSet = statement.executeQuery(sql);
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}*/
	public static ResultSet Adminprofile(String adminname)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select * from m_admin where admin_id='"+adminname+"'";
			
			resultSet = statement.executeQuery(sql);
			System.out.println("Retrieving Process Completed......");
			
		
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet Supportuser(String username)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select * from m_supportuser where s_name='"+username+"'";
			
			resultSet = statement.executeQuery(sql);
			System.out.println("Retrieving Process Completed......");
			
		
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static int gets_no(String s_no)
	{
		int s_num=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select s_no from m_grade where hash_key='"+s_no+"' ";
		
		System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			 s_num=resultSet.getInt(1);
		}
		System.out.println("s_no:"+s_no);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return s_num;
	}
	public static boolean insertHashcode(String code,String filecode,String keyno,String rank)
	{
		boolean flag=false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			int k = statement.executeUpdate("insert into m_hashtable (key_word, fileno,key_no,rank_val) value ('"+code+"','"+filecode+"','"+keyno+"','"+rank+"')");
			if(k>0)
			{
				flag=true;
			}
			System.out.println("Hash Key Insert Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->insert Hashkey: "+ e);
		}
		return flag;
	}
	
	public static ResultSet keyNo(String keyword,String filecode)
	{
		int k=0;
		boolean flag=false;
		ResultSet rs=null;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			
			rs = statement.executeQuery("select t_no,key_rank from t_count where f_no='"+filecode+"' and key_word='"+keyword+"'");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->insert Hashkey: "+ e);
		}
		return rs;
	}
	
	
	
	
	
	public static ResultSet getGrade()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select * from m_grade";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return resultSet;
	}
	
	public static int getFileno(String fname)
	{
		int total=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "select f_no from m_file where f_name='"+fname+"'";
		
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		System.out.println("file NO:"+total);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return total;
	}

	
	public static boolean updatetotal(String fname,int tot)
	{
		boolean flg = false;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
		String sql = "update m_file set total='"+tot+"' where f_name='"+fname+"'";
		
		//System.out.println(sql);
		 statement.executeUpdate(sql);
		
		 flg=true;
		System.out.println("STatus:"+flg);
		
				
		}
		catch(Exception e)
		{
			
			System.out.println("Execption:"+e.toString());
		}
		return flg;
	}


public static boolean count_word(String wor,int count,String fname)
{
	boolean flg = false;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "insert into t_count(f_no,key_word,weightage) values((select f_no from m_file where f_name='"+fname+"'),'"+wor+"','"+count+"')";
	
	//System.out.println(sql);
	statement.executeUpdate(sql);
	flg=true;
	System.out.println("Search status:"+flg);
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}

public static ArrayList getkey_word(String fname)
{
	ArrayList list = new ArrayList();
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "select *from t_count where f_no=(select f_no from m_file where f_name='"+fname+"')";
	
	
	resultSet = statement.executeQuery(sql);
	
	while(resultSet.next())
	{
		
		list.add(resultSet.getString(3)+"@"+resultSet.getString(4));
		
	}
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return list;
}

public static boolean update_rank(String keyword,String fname,String rank)
{
	boolean flg =false;
	
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
	String sql = "update t_count set key_rank='"+rank+"' where f_no=(select f_no from m_file where f_name='"+fname+"') and key_word='"+keyword+"'";
	
	
	int i=statement.executeUpdate(sql);
	
	if(i!=0)
	{
		flg=true;
	}
	
	}
	catch(Exception e)
	{
		
		System.out.println("Execption:"+e.toString());
	}
	return flg;
}

	public static boolean checkAdmin(String name,String pwd)
	{
		boolean flg = false;
		
		try
		{
			DAO dao=DAO.getInstance();
			
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_admin where admin_id = '"+name+"' and admin_password = '"+pwd+"' ";
			
			resultSet = statement.executeQuery(sql);
			 while(resultSet.next())
			 {
				 flg=true; 
			 }
			connection.close();
			statement.close();
			resultSet.close();
		}
		catch(Exception e)
		{
			//System.out.println("Exception in --> "+ e);
		}
		return flg;
	}
	
	public static boolean upload1(String filename, String keyword) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			statement.executeUpdate("insert into m_file (f_name,key_word) values('"+filename+"','"+keyword+"')");
			
			flag=true;
			
			System.out.println("File Insertion Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-uploadS()....."+e);
		}
		return flag;
	}
	
	
	public static ResultSet selectCloud() 
	{
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_cloud");
			//resultSet = statement.executeQuery("select a.gm_code,b.g_name,a.gm_loginid,a.gm_pwd,a.gm_name from m_groupmanager a join m_group b on a.g_code=b.g_code");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getUsers()....."+e);
		}
		return resultSet;
	}
	
	
	public static boolean updateCloud(int code,String url,String name,String pass) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_cloud set c_url='"+url+"',c_uname='"+name+"',c_pwd='"+pass+"' where c_code='"+code+"'");
			
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUser()....."+e);
		}
		return flag;
	}
	
	
	
	public static ResultSet getProfile(String name)
	{
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			String sql = "select * from m_admin where admin_id='"+name+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getProfile()....."+e);
		}
		return resultSet;
	}
	public static boolean editProfile(String [] s) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			int i=statement.executeUpdate("update m_admin set name='"+s[1]+"',admin_id='"+s[2]+"',email='"+s[3]+"',phone='"+s[4]+"' where id='"+s[0]+"'");
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editProfile()....."+e);
		}
		return flag;
	}
	public static ResultSet getGroup()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group ";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet viewGroup_manager()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			//String sql = "select gm_code,g_code,gm_loginid,gm_pwd,gm_name from m_groupmanager ";
			
			String sql = "select a.gm_code,b.g_name,a.gm_loginid,a.gm_pwd,a.gm_name from m_groupmanager a join m_group b on a.g_code=b.g_code";
			
			resultSet = statement.executeQuery(sql);
			
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static ResultSet selectGroupCode()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group where g_code not in (select g_code from m_groupmanager)";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	public static ResultSet selectGroupCode1()
	{
		ArrayList list = new ArrayList();
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select g_code,g_name from m_group";
			
			resultSet = statement.executeQuery(sql);
			
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static boolean insertgroup_mnger(String gcode,String gmlogin,String pwd,String gmname)
	{
		boolean flag=false;
	try
	{
		
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		statement = connection.createStatement();
		String sqlquery="insert into m_groupmanager(g_code,gm_loginid,gm_pwd,gm_name) values('"+gcode+"','"+gmlogin+"','"+pwd+"','"+gmname+"')" ;
		System.out.println(sqlquery);
		statement.executeUpdate(sqlquery);	
		flag = true;
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
	public static ResultSet getCloud()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select c_code,c_url,c_uname,c_pwd from m_cloud ";
			
			resultSet = statement.executeQuery(sql);
			
			 
			System.out.println("Retrieving Process Completed......");
			
			//connection.close();
			//statement.close();
			//resultSet.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
	}
	
	public static boolean loginCHK(String name, String pass) 
	{
		boolean flag=false;
		try
		{
			DAO database=DAO.getInstance();
			connection=database.connector();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_admin where admin_id='"+name+"' and admin_password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO.loginCHK()....."+e);
		}
		return flag;
	}
	
	public static boolean ChangePass(String name,String pwd)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "update m_admin set admin_password = '"+pwd+"' where admin_id = '"+name+"' ";
			
		 statement.executeUpdate(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return true;
		
	}
	
	public static ResultSet getprofile(String name)
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select *from m_admin where adminid = '"+name+"' ";
			
		resultSet =  statement.executeQuery(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
		
	}
	
	public static ResultSet getUserDetails()
	{
		
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			String sql = "select userid,uname,email,phone,city,state,country from digreform1 ";
			
		resultSet =  statement.executeQuery(sql);
			
			
			 
			System.out.println("Password Updated Successfully......");
		}
		catch(Exception e)
		{
			System.out.println("Exception in --> "+ e);
		}
		return resultSet;
		
	}
	
	public boolean editUserDetails(String [] s) 
	{
		boolean flag=false;
		String sql = "";
		String url = "";
		try
		{   
			
			
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql = "update digreform1 set uname='"+s[1]+"',email='"+s[2]+"',phone='"+s[3]+"',city='"+s[4]+"',state='"+s[5]+"',country='"+s[6]+"' where userid='"+s[0]+"'";
			System.out.println("******* Edit User Details Info *********\n");
			System.out.println(sql);
			int i=statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Admin Edit User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-editUserDetails(String [] s)  :");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static ResultSet getSpecificUserDetails(int userId)
	{
		String sql="";
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			statement = connection.createStatement();
			sql="select * from digreform1 where userid='"+userId+"'";
			System.out.println("******* Get Specific User Info *********\n");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("UserDAO-getServerSpecificDetails(int userId): ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static boolean deletesupportDetails(String id) 
	{
		boolean flag=false;
		String sqlChild = "",sqlRoot = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			
			statement = connection.createStatement();
			
			sqlRoot = "delete from m_supportuser where s_no='"+Integer.parseInt(id)+"'";
			
			
			
				System.out.println(sqlRoot);
				i = statement.executeUpdate(sqlRoot);
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
	
	
	
	public static boolean deleteitemDetails(String id) 
	{
		boolean flag=false;
		String sqlChild = "",sqlRoot = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			
			statement = connection.createStatement();
			
			sqlRoot = "delete from m_items where item_no='"+Integer.parseInt(id)+"'";
			
			
			
				System.out.println(sqlRoot);
				i = statement.executeUpdate(sqlRoot);
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
	public static boolean deletecategoryDetails(String id) 
	{
		boolean flag=false;
		String sqlChild = "",sqlRoot = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			
			statement = connection.createStatement();
			
			sqlRoot = "delete from m_category where c_id='"+Integer.parseInt(id)+"'";
			
			
			
				System.out.println(sqlRoot);
				i = statement.executeUpdate(sqlRoot);
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

	public static boolean deletevehicleDetails(String cardnum) 
	{
		boolean flag=false;
		String sqlChild = "",sqlRoot = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			
			statement = connection.createStatement();
			
			sqlRoot = "delete from m_vehicledetails where v_cardno='"+Integer.parseInt(cardnum)+"'";
			
			
			
				System.out.println(sqlRoot);
				i = statement.executeUpdate(sqlRoot);
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


	public static ResultSet getUserdetail() {
		
		
		
		
				try
				{
					DAO dao=DAO.getInstance();
					connection=dao.connector();
					statement = connection.createStatement();
					String sql = "select u_id from m_user ";
					
					resultSet = statement.executeQuery(sql);
					System.out.println("Retrieving Process Completed......");
					
					
				}
				catch(Exception e)
				{
					System.out.println("Exception in --> "+ e);
				}
				return resultSet;


		


	}

	public static ResultSet getsupportUserdetails() 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
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
			resultSet = statement.executeQuery("select * from m_items");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	public static ResultSet gettransactiondetails(String dte) 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			resultSet = statement.executeQuery("select * from t_order where dte='"+dte+"'");
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
			resultSet = statement.executeQuery("select * from m_category");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	public static ResultSet getvehicledetails(String id) 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			resultSet = statement.executeQuery("select * from m_vehicledetails where v_cardno='"+id+"'");
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return resultSet;
	}

	
	public static ResultSet getvehiclerec(String crdnum) 
	{
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			resultSet = statement.executeQuery("select  * from m_vehicledetails where v_cardno='"+crdnum+"'");
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
	public static boolean updateVehicleDetails(ArrayList<String> list) {
		
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "update m_vehicledetails set v_type='"+list.get(1)+"',v_model='"+list.get(2)+"',v_regno='"+list.get(3)+"' ,v_owner='"+list.get(4)+"',v_address='"+list.get(5)+"',v_cardexp='"+list.get(6)+"',v_regdte ='"+list.get(7)+"',v_chasisno='"+list.get(8)+"' ,v_engineno='"+list.get(9)+"',mob_no='"+list.get(10)+"', v_color ='"+list.get(11)+"'  where v_cardno ='"+list.get(0)+"'";
		
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

	public static boolean changePasswordadmin(String username, String npass) {
		
			boolean flag=false;
			String sql="";
			int i=0;
			try
			{
				DAO dao=DAO.getInstance();
				connection=dao.connector();
				sql = "update m_admin set admin_password='"+npass+"' where admin_id='"+username+"'";
				
				System.out.println(sql);
				i = statement.executeUpdate(sql);
				if(i!=0)
				{
					flag=true;
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Exception in AdminDAO==> changePasswordadmin(String username,String newPassword): "+ e);
			}
			return flag;
		}
	
	public static boolean changePassworsupportuser(String username, String npass) {
		
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "update m_supportuser set s_pass='"+npass+"' where s_name='"+username+"'";
			
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==> changePasswordadmin(String username,String newPassword): "+ e);
		}
		return flag;
	}

	
	public static boolean rechargeamount(String cardnum, String amount) {
		
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			sql = "update m_vehicledetails set v_balance='"+amount+"' where v_cardno='"+cardnum+"'";
			
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==> changePasswordadmin(String username,String newPassword): "+ e);
		}
		return flag;
	}
	public static boolean checkcardnum(int cardnum) {
		String data="";
		boolean flag=false;
		try
		{
			
		
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			resultSet = statement.executeQuery("select * from m_vehicledetails where v_cardno='"+cardnum+"'");
			
			while(resultSet.next())
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

	public static String checkvehicle() {
		String data="";
		boolean flag=false;
		try
		{
			
		
			DAO dao=DAO.getInstance();
			connection=dao.connector();
			resultSet = statement.executeQuery("select v_cardno from m_vehicledetails");
			
			while(resultSet.next())
			{
				
				 data=resultSet.getString(1);
				
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return data;
	}

public static String checktoll() {
	String data="";
	boolean flag=false;
	try
	{
		
	
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		resultSet = statement.executeQuery("select t_no from m_tolldetails");
		
		while(resultSet.next())
		{
			
			 data=resultSet.getString(1);
			
		}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return data;
}

public static boolean addvehicleDetails(int con, String type, String model,
		String regno, String owner, String string, String expdte,
		String regdte, String chasisno, String engineno, String mobileno2,
		String color) {

	System.out.println("its acme inside addvehicleDetails >>>>>>>>>>>>>>>>>>");
	
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		DAO dao=DAO.getInstance();
		connection=dao.connector();
		sql = "insert into m_vehicledetails(v_cardno,v_type,v_model,v_regno,v_owner,v_address,v_cardexp,v_regdte,v_chasisno,v_engineno,mob_no,v_color) values('"+con+"','"+type+"','"+model+"','"+regno+"','"+owner+"','"+string+"','"+expdte+"','"+regdte+"','"+chasisno+"','"+engineno+"','"+mobileno2+"','"+color+"')";
		
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