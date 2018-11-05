<%@page import="com.admin.*"%>

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
%>

<%
	username = (String)session.getAttribute("username");		
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:190px;">
	<form name="frm" action="<%=request.getContextPath()%>/ChangePassworduser">
			
	<font color="#ffffff" size="4"><b><h1>Do You Want to Change Password</h1></b></font>
	<table style="width: 500px;text-align: center;">
		
		<tr align="center">
	        <td><font color="#ffffff" size="4"><b>
	        		Support User
	       </b></font> </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="username" value="<%=username%>" class="easyui-validatebox" required="required" readonly="readonly" autofocus required pattern="[a-zA-Z0-9_-]{5,12}" title="Must be alphanumeric in 5-12 chars."/>
			</td>
			
			
			<td width="15px"></td>
		<tr>
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Old Password
	       </b></font> </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="password" name="oldpass" placeholder="Enter Your old Password" class="easyui-validatebox" required="required" />
			</td>
			
   	    </tr>	
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		New Password
	     </b></font>   </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="password" name="npass" placeholder="Enter Your Password" class="easyui-validatebox" required="required" />
			</td>
			
   	    </tr>
		
		
		<tr>	
			<td><font color="#ffffff" size="4"><b>
	        		Confirm Password
	       </b></font> </td>
	        
	        <td>:</td>
	        
			<td>
					<input type="password" name="cpass" placeholder="Enter Your Confirm Password" class="easyui-validatebox" required="required" />
			</td>
			
   	    </tr>
		
		
		<tr align="center">
				<td colspan="3" align="center">
						<input  type="submit"  value="Change Password" class="button button3" style="left:175px;width: 175px;"/>
				</td>
		</tr>
	</table>
	   
	</form><!-- form -->
	
</section><!-- content -->

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
    		
    		alert('Support User password changed Successfully.....!');
    		
    		</script>			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		
		
		<script type="text/javascript">
    		
    		alert('New and Confirm Password Must be Same!!!!!');
    		
    		</script>		
<%
	}if(Utility.parse(request.getParameter("no"))==4)
	{
%>
		
		
		<script type="text/javascript">
    		
    		alert('your old password is wrong!!!!!');
    		
    		</script>		
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>
		<script type="text/javascript">
    		
    		alert('opps something went wrong');
    		
    		</script>			
<%
	}
%>

</body>
</html>