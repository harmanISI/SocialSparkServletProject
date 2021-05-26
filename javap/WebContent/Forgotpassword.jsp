<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/login.css">
<meta charset="ISO-8859-1">
<title>forgot password</title>
</head>
<body>
 <tag:if test="${notmatch != null}">
		<script>	
				alert("credentials not matched ");
		</script>
	</tag:if>

   <div class="wrapper">
      <div class="title-text">
        <div class="title login">
Forgot Password</div>

</div>


<div class="form-inner">
          <form action="fpass" class="login">
            <div class="field">
              <input type="text" placeholder="Email Address" name="forgotemail" required>
            </div>
<div >
<select  class="field" name="secQues"  required>
<option value="0" >Select question</option>
<option value="Your first school's name" >Your first school's name</option>
<option value="Your pet's name" >Your pet's name</option>
<option value="Your first car's name" >Your first car's name</option>
<option value="Your favourite teacher's name" >Your favourite teacher's name</option>
<option value="Your mother's maiden name" >Your mother's maiden name</option>
<option value="Your best friend's name" >Your best friend's name</option>

</select> 
</div> 
<div class="field">
              <input type="text" placeholder="Security answer" name="secans" required>
            </div>
            

<div class="field btn">
              <div class="btn-layer">
</div>
<input type="submit" value="Forgot Password"  name="forgot">
            </div>

</form>


</div>
</div>
</div>

</body>
</html>