<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/login.css">
<meta charset="ISO-8859-1">
<title>Confirm password</title>
</head>
<body>

  <tag:if test="${unequal != null}">
		<script>	
				alert("Kindly confirm your password , you are writing two different password");
		</script>
	</tag:if>
      
<div class="wrapper">
      <div class="title-text">
        <div class="title login">
Confirm Password</div>

</div>

<div class="form-inner">

<form action="passup" class="signup">
            <h1> welecome back ${fname} </h1>
<div class="field">
              <input type="password" placeholder=" New Password" name="pass" required>
            </div>
<div class="field">
              <input type="password" placeholder="Confirm new password" name="cpass" required>
            </div>
        
<div class="field btn">
              <div class="btn-layer">
</div>
<input type="submit" value="confirm" name ="updatepass">

            </div>
</form>
</div>
</div>
</div>

</body>
</html>