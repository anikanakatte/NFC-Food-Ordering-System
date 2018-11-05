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

 <%
 
 String tno=(String)session.getAttribute("tno");
 
String totalamount=AdminDAO.gettotalamount(Integer.parseInt(tno)); 
 ResultSet rs=AdminDAO.getorder(Integer.parseInt(tno)); 
%> 

<body onload="startTimer()">

<form name="frm" action="<%=request.getContextPath()%>/Clear">
<section id="content">

<!-- <input  type="submit" name="bill"  value="Bill" class="button button3" style="left:201px;width: 120px;"/> -->
	   		<input  type="submit" name="clear"  value="Clear" class="button button3" style="left:201px;width: 120px;"/>

<div style="position:relative;width:600px;height:375px;">



	   		<div class="CSSTableGenerator"  style="width:200px;height:150px; left:100px; position:absolute; top:90px">
      <table id="results" style="border:5px solid #FFFFFF" class="pretty-table" border="5" width="200%" cellpadding="5" c id="user" style="position:absolute;">
  <font size="3" style="font-family: cursive; color: #FFFFFF;"><b>TABLE  ORDER DETAILS</b></font><br/><br/>
<th scope="col"><font size="2" style="font-family: cursive; color: #DC7633;"><b>ITEM NAME</b></font></th>
    <th scope="col"><font size="2" style="font-family: cursive; color: #DC7633;"><b>QUANTITY</b></font></th>
     <th scope="col"><font size="2" style="font-family: cursive; color: #DC7633;"><b>PRICE</b></font></th>
   
   <%
   
 
			
			while(rs.next())
			{
			%>
		  		<tr>
		  			
		  			<td align="center"><font size="2" style="font-family: cursive; color: #DC7633;"><b><%=rs.getString(3) %></b></font></td>
		  			<td align="center"><font size="2" style="font-family: cursive; color: #DC7633;"><b><%=rs.getInt(4) %></b></font></td>
		  		  	<td align="center"><font size="2" style="font-family: cursive; color: #DC7633;"><b><%=rs.getString(5) %></b></font></td>
		  		</tr>
		  	<%} %>
	   
	   		
	
	   		
	   		
	   		
	   		</table></br>
	   		<label style="color: white;">Total Amount of ordered items <%=totalamount%> rs</label>
	   		
	   		
	 	
	 
		
	   
	  </div>

</div>	
	

   
  
</section>

</form>
	
<div class="footer" id="pageNavPosition" style="cursor:hand"></div>
	
<script type="text/javascript"><!--
       var pager = new Pager('results',3); 
       pager.init(); 
       pager.showPageNav('pager', 'pageNavPosition'); 
       pager.showPage(1);
   //--></script>
</body>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
%>
		<script type="text/javascript">
    		
    		alert('This Table is Empty,No customer in this table As of now');
    		
    		</script>		
<%
	}
	

%>
</html>