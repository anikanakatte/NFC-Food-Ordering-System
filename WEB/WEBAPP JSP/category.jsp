<%@page import="com.admin.*"%>

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
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
%> 

<body onload="startTimer()">

<section id="content">
<form name="myForm" action="<%=request.getContextPath()%>/Category">	
<div style="position: relative;top: 50px;left: 50px;">
<font color="#00CED1" size="3"><b> <h1>CATEGORY DETAILS </h1></b></font>
</div>

<div style="position:relative;width:600px;height:375px;">

<div style="position: relative;top: -15px;left: 325px;">
	 
	<input type="submit" name="action" value="Add" class="button button3" id="button" style="width:100px; "/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Edit" class="button button3" id="button" style="width:100px;"/>&nbsp;&nbsp;
	<input type="submit" name="action" value="Delete" class="button button3" id="button" style="width:100px;"  />&nbsp;&nbsp;
	
	<input type="hidden" name="action" value="Delete"/>
</div>

<table id="results" class="tab" align="center" cellspacing="10">
	<tr>
		<th><font color="#00CED1" size="4"><b>Select</b></font></th></br>
		<th><font color="#00CED1" size="4"><b>Category</b></font></th>
		
		
	</tr>
 <%
	if(rs!=null)
		while(rs.next())
		{
%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=rs.getInt(1)%>"></td>
				
				<td><b><%=rs.getString(2)%></b></td>
		      
				
			</tr>
<%
		}
%>  
</table>

</div>	
	
<div class="footer" id="pageNavPosition" style="cursor:hand"></div>
	
<script type="text/javascript"><!--
       var pager = new Pager('results',5); 
       pager.init(); 
       pager.showPageNav('pager', 'pageNavPosition'); 
       pager.showPage(1);
   //--></script>
   
</form><!-- form -->   
</section>

 <%
	if(Utility.parse(request.getParameter("no"))==1)
    {
%>
    	
    		
    		<script type="text/javascript">
    		
    		alert('Category Details Added Successfully.....!');
    		
    		</script>
    		
<%
    }
	if(Utility.parse(request.getParameter("no"))==-1)
	{
%>
		
			
			<script type="text/javascript">
    		
    		alert('something went wrong.....!');
    		
    		</script>
			
<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		
			
			
			<script type="text/javascript">
    		
    		alert('select atleast one record ....!');
    		
    		</script>
				
	<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>
		
			<script type="text/javascript">
    		
    		alert('Category Details Deleted Successfully.....!');
    		
    		</script>
				
<%
	}
	if(Utility.parse(request.getParameter("no"))==4)
	{
%>
		
			<script type="text/javascript">
    		
    		alert(' Select only one record ....!!');
    		
    		</script>
				
<%
	}
	if(Utility.parse(request.getParameter("no"))==5)
	{
%>
		
			
			<script type="text/javascript">
    		
    		alert('Category Details Updated Successfully....!');
    		
    		</script>
				
<%
	}
	if(Utility.parse(request.getParameter("no"))==6)
	{
%>
		
			
			<script type="text/javascript">
    		
    		alert(' Opps Something Went Wrong!!!!!');
    		
    		</script>
				
<%
	}
%>		

</body>
</html>