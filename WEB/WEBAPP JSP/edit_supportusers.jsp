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
<link href="<%=request.getContextPath() %>/res/CSS/form1.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />

<%-- Easy UI Validation (Starts) --%>	
<link href="<%=request.getContextPath() %>/res/CSS/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/res/CSS/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.easyui.min.js"></script>
<%-- Easy UI Validation (Ends) --%>	

<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/script.js"></script>
<script type="text/javascript">


function Validate() 
{
    var val = document.getElementById('ids').value;
    
    if (!val.match(/^[a-zA-Z]+$/)) 
    {
        alert('Company Name  shouldnot contain Integers');
        return false;
    }
    
    return true;
}


</script>
<script type="text/javascript">


function validatePassword(fld) {
    var error = "";
    var illegalChars = /[\W_]/; // allow only letters and numbers
 
    if (fld.value == "") {
        fld.style.background = 'white';
        error = "You didn't enter a password.\n";
        alert(error);
        return false;
 
    } else if ((fld.value.length < 7) || (fld.value.length > 15)) {
        error = "The password is the wrong length. \n";
        fld.style.background = 'white';
        alert(error);
        return false;
 
    } else if (illegalChars.test(fld.value)) {
        error = "The password contains illegal characters.\n";
        fld.style.background = 'white';
        alert(error);
        return false;
 
    } else if ( (fld.value.search(/[a-zA-Z]+/)==-1) || (fld.value.search(/[0-9]+/)==-1) ) {
        error = "The password must contain at least one numeral.\n";
        fld.style.background = 'white';
        alert(error);
        return false;
 
    } else {
        fld.style.background = 'White';
    }
   return true;
}
</script>
<script type="text/javascript">




function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}



</script>

 <script>
        function validateEmail(emailField)
        {
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

        if (reg.test(emailField.value) == false) 
        {
            alert('Invalid Email Address');
            emailField.value = null;
            return false;
        }

        return true;

}
        
        </script>

<script>
   

    	function ValidateAlpha(evt)
        {
    		 var keyCode = (evt.which) ? evt.which : evt.keyCode
    			        if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && keyCode != 32)
    			        	{
    			        	
    			        	alert('Numbers not allowed');
    			        	 return false;
    			        	}    			        	
    			       
    			            return true;
        }


    	
    </script>


   <script type="text/javascript">

function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    	alert('Only Numbers should be filled out');
        return false;
    }
    
    
    
    
    
    
    return true;
}
</script>

<script>
        function validatePhone(PhoneField)
        {
      
       var reg = /[7-9]{1}\d{9}/;

        if (reg.test(PhoneField.value) == false) 
        {
            alert('Invalid Phone Number');
            PhoneField.value = null;
            return false;
        }

        return true;

}
        </script>




</head>

<%!
	ResultSet rs = null;
	String farebus="";
	String name="",age="",sex="",role="",phone="",email="";
	int id=0;
	
%>

<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	if(rs != null)
	{
		if(rs.next())
		{
			  id = rs.getInt(1);
			  name = rs.getString(2);
	   		 age = rs.getString(4);
	   		 sex = rs.getString(5);

	   		role = rs.getString(6);
	   		 phone = rs.getString(7);
	   		 email = rs.getString(8);
	   	
	   		
	   		
	   		
		}
	}
%>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:35;left:190px;">
	<form name="frm" action="<%=request.getContextPath()%>/SupportUsers">
			
	<font color="#00CED1" size="4"><b><h1>Update Support Users Details</h1></b></font>
	<table style="width: 500px;text-align: center;">
		
		
		<tr align="center">
	        <td><font color="#00CED1" size="4"><b>
	        		NAME
	       </b></font> </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="name" value="<%=name%>"  class="easyui-validatebox" required="required" autofocus required   readonly="readonly"/>
			</td>
			
			
			<td width="15px"></td>
		
	        <td><font color="#00CED1" size="4"><b>
	        	AGE
	       </b></font> </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text"  id="tp" name="age" value="<%=age%>"  class="easyui-validatebox" required="required" autofocus required  />
			</td>
			
			
			<td width="15px"></td>
		</tr>	
		
		<tr align="center">
	        <td><font color="#00CED1" size="4"><b>
	        		SEX
	      </b></font>  </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="sex" value="<%=sex%>" class="easyui-validatebox"  required="required" />
			</td>
			
			
			<td width="15px"></td>
		
	        <td><font color="#00CED1" size="4"><b>
	        		ROLE</b></font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="role" value="<%=role%>"     class="easyui-validatebox" required="required" />
			</td>
			
			
			<td width="15px"></td>
		</tr>	
		
		
		<tr align="center">
	        <td><font color="#00CED1" size="4"><b>
	        		PHONE</b></font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="phone" value="<%=phone%>" id="txtChar" onkeypress="return isNumber(event);" maxlength="10"  class="easyui-validatebox" required="required" />
			</td>
			
			
			<td width="15px"></td>
		
	        <td><font color="#00CED1" size="4"><b>
	        		 MAIL</b></font>
	        </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="email" value="<%=email%>" onblur="validateEmail(this);" class="easyui-validatebox"  required="required" />
			</td>
			
			
			<td width="15px"></td>
		</tr>	
		
		
		<tr align="center">
				<td colspan="3" align="center">
						<input type="submit" value="Update" class="button button3" style="left: 201px;"/>
					    <input type="hidden" name="action" value="Edit"></input>
					    <input type="hidden" name="edit" value="YES"></input>
					    <input type="hidden" name="id" value="<%=id%>"></input>
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
    		
    		alert('Support Users details Updated successfully');
    		
    		</script>				
<%
	}
	
	if(Utility.parse(request.getParameter("no"))==2)
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