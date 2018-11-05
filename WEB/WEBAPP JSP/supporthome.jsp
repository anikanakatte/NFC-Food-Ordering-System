<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.admin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Management System</title>
  <meta name="description" content="free website template" />
  <meta name="keywords" content="enter your keywords here" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=9" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
</head>

<% int no=	Utility.parse(request.getParameter("no"));

String username=(String)session.getAttribute("username");

System.out.print("username is >>>>>>>>>>>>>"+username);
System.out.print("no is >>>>>>>>>>>>>"+no); %>
<body>
<div id="main">
    <div id="header">
	  <div id="banner">
	    <div id="welcome">
	      <h1>Welcome  <%=username%></h1>
	    </div><!--close welcome-->
	    <div id="menubar">
          <ul id="menu">
           
            <li><a href="<%=request.getContextPath()%>/jsp/viewordereditems.jsp" target="myFrame">View Ordered Details</a></li>
    
            <li><a href="<%=request.getContextPath()%>/jsp/change_passwordsupport.jsp" target="myFrame">Change Pass</a></li>
            <li><a href="<%=request.getContextPath()%>/index.jsp?no=5">Logout</a></li>
          </ul>
        </div>
	  </div>
    </div>
    
	<div id="site_content">		

      <div class="slideshow">  
		<ul class="slideshow">
          <li class="show"><img width="900" height="250" src="images/hotel1.jpg" alt="&quot;Hotel Management System&quot;" /></li>
          <li><img width="900" height="250" src="images/hotels-7.jpg" alt="&quot;Hotel Management System&quot;" /></li>
        </ul> 
      </div>	
	  
	  <div class="ourwork" style="width:860px;height: 250px;">
	  
	  
	  <iframe frameborder="0" scrolling="auto" name="myFrame" height="250" width="860" top="500"  src="<%=request.getContextPath()%>/jsp/Supportuser.jsp">
		</iframe>
	  
	  
	   
	  </div>
	   
	 		 
	  
	
	</div>
    
	
 
  </div>
  
 
</body>

<% 



if(no==1)
{
	%>
	<script type="text/javascript">

	alert("Support User  Login Successfull")

	</script>
	<% 
}
%> 
</html>