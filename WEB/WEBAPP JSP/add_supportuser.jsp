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

<link rel="stylesheet" href="<%=request.getContextPath() %>/pagenationcss.css" />
<script src="<%=request.getContextPath() %>/pagenation.js"></script>
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


</head>

<body onload="startTimer()">
<section id="content" style="position: absolute;top:50;left:110px; ">
	<form name="frm" action="<%=request.getContextPath()%>/SupportUsers">
			
	<font color="#00CED1" size="4"><b><h1>ADD SUPPORT USERS DETAILS</h1></b></font>
	<table style="width: 650px;   text-align: center;">
		
		<tr align="center">
	        <td><font color="#00CED1" size="4"><b>
	        		NAME
	      </b></font>  </td>
	        
	        <td width="11px">:</td>
	        
			<td><font color="#00CED1" size="4"><b>
					<input type="text" name="name" id="ids" class="easyui-validatebox"   onKeyPress="return ValidateAlpha(event);"  required="required" autofocus required  title="Please,Enter The Company Name."/>
			</b></font></td>
			
			
			<td width="15px"></td>
		
	        <td><font color="#00CED1" size="4"><b>
	        		PASSWORD
	      </b></font>  </td>
	        
	        <td width="11px">:</td>
	        
			<td>
				<font color="#00CED1" size="4"><b>	<input type="password" name="pass"  class="easyui-validatebox"    required="required" autofocus required  title="Please,Enter The Company Adress."/>
			</b></font></td>
			
			
			<td width="15px"></td>
		</tr>	
		
		
		<tr align="center">
	        <td><font color="#00CED1" size="4"><b>
	        		AGE
	      </b></font>  </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="age"  class="easyui-validatebox" required="required"     title="Please,Enter The Company Password."/>
			</td>
			
			
			<td width="15px"></td>
		
	        <td><font color="#00CED1" size="4"><b>
	        		PHONE
	      </b></font>  </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="phone"  class="easyui-validatebox" required="required" maxlength="10"  onkeypress="return isNumber(event);" title="Please,Enter The Company Userid."/>
			</td>
			
			
			<td width="15px"></td>
	    
		</tr>	
		
		<tr align="center">
	        <td><font color="#00CED1" size="4"><b>
	        		ROLE
	      </b></font>  </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="role"  class="easyui-validatebox" required="required" onKeyPress="return ValidateAlpha(event);"  title="Please,Enter The Company Code."/>
			</td>
			
			
			<td width="15px"></td>
			
			    <td><font color="#00CED1" size="4"><b>
	        		SEX
	      </b></font>  </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<select name="sex">
				<option value="male">MALE</option>
				<option value="female">FEMALE</option>
				
				
				</select>	
					
			</td>
			
			
			<td width="15px"></td>
			
			
			
			
			
			
		
	       
		</tr>	
		
		
		
		
		
		
		
		<tr align="center">
	        <td><font color="#00CED1" size="4"><b>
	        		EMAIL
	      </b></font>  </td>
	        
	        <td width="11px">:</td>
	        
			<td>
					<input type="text" name="mail"  class="easyui-validatebox" required="required"    onblur="validateEmail(this);"   title="Please,Enter The Company Password."/>
			</td>
			
			
			<td width="15px"></td>
		
		</tr>	
		
		
		
		
		
		<tr align="center">
				<td colspan="3" align="center">
						<input  type="submit" name="action"  value="Add" class="button button3" style="left:201px;width: 120px;"/>
						<input type="hidden" name="add" value="YES" />
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
    		
    		alert('Support Users details added successfully');
    		
    		</script>		
<%
	}
	
	if(Utility.parse(request.getParameter("no"))==2)
	{
%>
		
			<script type="text/javascript">
    		
    		alert(' Something went wrong');
    		
    		</script>
							
<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
%>
		
			<script type="text/javascript">
    		
    		alert(' sorry this Support User already exist');
    		
    		</script>
					
<%
	}
%>

</body>
</html>