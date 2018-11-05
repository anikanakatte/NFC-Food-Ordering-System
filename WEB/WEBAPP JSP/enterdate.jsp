<%@page import="com.admin.*"%>
  <%@ page import="com.database.*" %>

<%@page import="java.sql.ResultSet"%>
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

<link rel="stylesheet" href="<%=request.getContextPath() %>/pagenationcss.css" />
<script src="<%=request.getContextPath() %>/pagenation.js"></script>
</head>


<body onload="startTimer()">

<section id="content">
<form name="myForm" action="<%=request.getContextPath()%>/ViewTransactions"      method="post">	


<div style="position:relative;width:600px;height:375px;">
<h4> <font color="white">SELECT DATE</font></h4>

<table id="results" class="tab" align="center" cellspacing="10">
	
 	<tr align="center">
	      
	      <label>DATE :</label>
	       <input  type="date" name="dte"  style="left:201px;width: 120px;"/>
	        
			<td colspan="3" align="center">
			
						<input  type="submit" name="ok"  value="Ok" class="button button3" style="left:201px;width: 120px;"/>
						
				</td>
				
				
			
				
			</tr>
</table>

</div>	
	

   
</form><!-- form -->   
</section>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
    		
    		alert('There is no transaction for this Particular Day');
    		
    		</script>		
<%
	}
	

%>

</body>
</html>