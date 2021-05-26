<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="./css/login.css">
    <meta charset="ISO-8859-1">
  </head>
  <body>
  
    <div class="wrapper">
      <div class="title-text">
        <div class="title login">
        
        
   
        <tag:if test="${error != null}">
		<script>	
				alert("Either USERNAME or PASSWORD IS INCORRECT ");
		</script>
	</tag:if>
      
         <tag:if test="${name != null}">
		<script>	
				alert("Hello  ${name} your account is created Succesfully,We urge you to Login your Profile ");
		</script>
	</tag:if>
      
      <tag:if test="${ll != null}">
		<script>	
				alert("Password is updated , try login using new password ");
		</script>
	</tag:if>
	
      
        
Login Form</div>
<div class="title signup">
Signup Form</div>
</div>
<div class="form-container">
        <div class="slide-controls">
          <input type="radio" name="slide" id="login" checked>
          <input type="radio" name="slide" id="signup">
          <label for="login" class="slide login">Login</label>
          <label for="signup" class="slide signup">Signup</label>
          <div class="slider-tab">
</div>
</div>
<div class="form-inner">
          <form action="LoginUser" method="post" class="login">
            <div class="field">
              <input type="text" placeholder="Email Address" name="loginemail" required>
            </div>
<div class="field">
              <input type="password" placeholder="Password" name="loginpass" required>
            </div>
<div class="pass-link">
<a href="Forgotpassword.jsp">Forgot password?</a></div>
<div class="field btn">
              <div class="btn-layer">
</div>
<input type="submit" value="Login">
            </div>
<div class="signup-link">
Not a member? <a href="">Signup now</a></div>
</form>


<form action="GetRegistar" class="signup" method="post">
            <div class="field">
              <input type="text" placeholder="Email Address" name="email" required>
            </div>
<div class="field">
              <input type="password" placeholder="Password" name="pass" required>
            </div>
<div class="field">
              <input type="text" placeholder="Your Fullname" name="name" required>
            </div>
<div class="field">
               <input type="date" id="birthday" name="dob"> 
               </div>
<div >
<select  class="field" name="que"  required>
<option value="Select question" >Select question</option>
<option value="Your first school's name" >Your first school's name</option>
<option value="Your pet's name" >Your pet's name</option>
<option value="Your first car's name" >Your first car's name</option>
<option value="Your favourite teacher's name" >Your favourite teacher's name</option>
<option value="Your mother's maiden name" >Your mother's maiden name</option>
<option value="Your best friend's name" >Your best friend's name</option>

</select> 
</div> 
<div class="field">
              <input type="text" placeholder="Security answer" name="ans" required>
            </div>         
<div class="field btn">
              <div class="btn-layer">
</div>
<input type="submit" value="Signup">
            </div>
</form>
</div>
</div>
</div>
<script>
      const loginText = document.querySelector(".title-text .login");
      const loginForm = document.querySelector("form.login");
      const loginBtn = document.querySelector("label.login");
      const signupBtn = document.querySelector("label.signup");
      const signupLink = document.querySelector("form .signup-link a");
      signupBtn.onclick = (()=>{
        loginForm.style.marginLeft = "-50%";
        loginText.style.marginLeft = "-50%";
      });
      loginBtn.onclick = (()=>{
        loginForm.style.marginLeft = "0%";
        loginText.style.marginLeft = "0%";
      });
      signupLink.onclick = (()=>{
        signupBtn.click();
        return false;
      });
    </script>
      
</body>
</html>