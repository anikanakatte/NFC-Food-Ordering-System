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
String id="";
String name="";
String mail="";
String phone="";
%>

<%
	username = (String)session.getAttribute("username");	

ResultSet rs=AdminDAO.Adminprofile(username); 


while(rs.next())
{
	
id=rs.getString(1);
	name=rs.getString(4);
	mail=	rs.getString(5);
 phone=rs.getString(6);
	
	
}
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:190px;">
	
			
	<font color="#ffffff" size="4"><b><h1>Admin Profile</h1></b></font>
	<table style="width: 500px;text-align: center;">
		
		<tr align="center">
	        <td><font color="#ffffff" size="4"><b>
	        		Admin ID
	       </b></font> </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="username" value="<%=id%>" class="easyui-validatebox" required="required" readonly="readonly" autofocus required pattern="[a-zA-Z0-9_-]{5,12}" title="Must be alphanumeric in 5-12 chars."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Admin Name
	       </b></font> </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="name" value="<%=name%>" class="easyui-validatebox"  readonly="readonly"  required="required" />
			</td>
			
   	    </tr>	
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Admin Email
	     </b></font>   </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="email"  value="<%=mail%>"  class="easyui-validatebox"   readonly="readonly" required="required" />
			</td>
			
   	    </tr>
		
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Admin Phone
	       </b></font> </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="text" name="phone"  value="<%=phone%>"  readonly="readonly" class="easyui-validatebox" required="required" />
			</td>
			
   	    </tr>
		
	
	</table>
	   
	
	
</section><!-- content -->



</body>
</html>