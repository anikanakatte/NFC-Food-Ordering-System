<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.admin.Utility" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Hotel Management</title>
  <meta name="description" content="free website template" />
  <meta name="keywords" content="enter your keywords here" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=9" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  
  <style>
.button {
    background-color: #4CAF50; /* Green */
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

.button2 {background-color: #008CBA;} /* Blue */
.button3 {background-color: #f44336;} /* Red */ 
.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 
.button5 {background-color: #555555;} /* Black */
</style>
</head>

<% int no=	Utility.parse(request.getParameter("no"));

System.out.print("no is >>>>>>>>>>>>>"+no); %>
	
<body>

<div id="main">

    <div id="header">
   
	  <div id="banner">
	    <center><img alt="" src="title.png"></center>  
	    <div id="welcome">
	    
	 
	     
	    </div><!--close welcome-->
	  <!--   <div id="menubar">
          <ul id="menu">
            <li class="current"><a href="index.html">ADMIN LOGIN</a></li>
           
          </ul>
        </div>close menubar	   -->
	  </div><!--close banner-->	
    </div><!--close header-->	
    
	<div id="site_content">		

      <div class="slideshow">  
		<ul class="slideshow">
          <li class="show"><img width="900" height="250" src="images/hotel1.jpg" alt="&quot;Hotel Management System&quot;" /></li>
          <li ><img width="900" height="250" src="images/hotels-7.jpg" alt="&quot;Hotel Management Systemm&quot;" /></li>
        </ul> 
      </div><!--close slideshow-->		
	  <form  action="<%=request.getContextPath()%>/Adminlogin" method="get">    
	  <div class="ourwork">
	    <h3>Admin Login</h3>
	    <label>USERNAME:</label>
	    <input type="text" name="adminid"><br/><br/>
	    <label>PASSWORD:</label>
	    <input type="password" name="pass"><br/><br/>
	  <button class="button button5">LOGIN</button>
	    
		  
	  </div>
	  </form>
	   <form  action="<%=request.getContextPath()%>/Supportuserlogin" method="get"> 
	  <div class="testimonials">
	  
	  
	   <h3>Support User Login</h3>
	    <label>USERNAME:</label>
	    <input type="text" name="adminid"><br/><br/>
	    <label>PASSWORD:</label>
	    <input type="password" name="pass"><br/><br/>
	  <button class="button button5">LOGIN</button>
	  
	    
	  </div> 
	  </form> 
	  <div class="projects">
	     <h3>MENU</h3>
	<ul>
	<li><b>CHINESE FOOD</b></li>

	<li><b>SOUTH INDIAN FOOD</b></li>
		<li><b>NORTH INDIAN FOOD</b></li>
			<li><b>DESSERTS</b></li>
			<li><b>BUFFET</b></li>
				</ul>
		     
	  </div>	 
	 
	  
	
	</div>
   
 
  </div>
  
 
</body>

<% 



if(no==2)
{
	%>
	<script type="text/javascript">

	alert("Please Enter your Username and Password correctly")

	</script>
	<% 
}if(no==3)
{
	%>
	<script type="text/javascript">

	alert("Admin logout Successfully")

	</script>
	<% 
}

if(no==4)
{
	%>
	<script type="text/javascript">

	alert("Support Userid and password is wrong ")

	</script>
	<% 
}

if(no==5)
{
	%>
	<script type="text/javascript">

	alert("Support User Logout Successfully ")

	</script>
	<% 
}
%> 
</html>