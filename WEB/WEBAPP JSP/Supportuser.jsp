<%@page import="com.admin.*"%>
<%@page import="com.database.*"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>

<style>
.button {
    background-color: #00CED1; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

.button1 {border-radius: 2px;}
.button2 {border-radius: 4px;}
.button3 {border-radius: 8px;}
.button4 {border-radius: 12px;}
.button5 {border-radius: 50%;}
</style>

</head>

<%!
	String username = "";
String Nmae="";
String age="";
String role="";
String phone="",mail="",sex="";
%>

<%
	username = (String)session.getAttribute("username");	

ResultSet rs=AdminDAO.Supportuser(username); 


while(rs.next())
{
	
Nmae=rs.getString(2);
	age=rs.getString(4);
	sex=	rs.getString(5);
 role=rs.getString(6);
 phone=rs.getString(7);
 mail=rs.getString(8);
	
	
}
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:190px;">
	
			
	<font color="#ffffff" size="4"><b><h1>Support User Profile</h1></b></font>
	<table style="width: 500px;text-align: center;">
		
		<tr align="center">
	        <td><font color="#ffffff" size="4"><b>
	        		Name
	       </b></font> </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="Nmae" value="<%=Nmae%>" class="easyui-validatebox" required="required" readonly="readonly" autofocus required pattern="[a-zA-Z0-9_-]{5,12}" title="Must be alphanumeric in 5-12 chars."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Age
	       </b></font> </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="name" value="<%=age%>" class="easyui-validatebox"  readonly="readonly"  required="required" />
			</td>
			
   	    </tr>	
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Sex
	     </b></font>   </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="email"  value="<%=sex%>"  class="easyui-validatebox"   readonly="readonly" required="required" />
			</td>
			
   	    </tr>
		
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Role
	       </b></font> </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="phone"  value="<%=role%>"  readonly="readonly" class="easyui-validatebox" required="required" />
			</td>
			
   	    </tr>
		
	
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Phone
	       </b></font> </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="phone"  value="<%=phone%>"  readonly="readonly" class="easyui-validatebox" required="required" />
			</td>
			
   	    </tr>
   	    
   	    <tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Mail
	       </b></font> </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="phone"  value="<%=mail%>"  readonly="readonly" class="easyui-validatebox" required="required" />
			</td>
			
   	    </tr>
	</table>
	   
	
	
</section><!-- content -->



</body>
</html>