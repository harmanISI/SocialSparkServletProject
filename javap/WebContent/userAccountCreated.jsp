<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User account created</title>
</head>
<style>
.parent {
  background-color: #252E3B;
  height: 650px;
  display: flex;
}
h1 {
  margin: 0px;
  font-family: monospace;
}
.box-one {
  width: 35%;
  color: white;
  background-color: #252E3B;
  padding: 50px;
}
.box-two {
  width: 80%;
  background: linear-gradient(-57deg, #F0DA50 63%, #252E3B 42%);
  color: white;
}
img {
  max-width: 100%;
  height: auto;
  border-radius: 50%;
  border: 3px solid #F0DA50;
}
.image {
    height: 250px;
    width: 250px;
    border-radius: 50%;
    margin-top: 8%;
    margin-left: 27%;
}
.color-secondary, a {
  color: #F0DA50;
  text-decoration: none;
}
.contact-link {
  padding: 10px 30px;
  background: #F7DF1E;
  border-radius: 5px;
  font-family: monospace;
  font-weight: 700;
  font-size: 18px;
  color: #000000;
}
</style>
<body>
<div class="parent">
  <div class="box-one">
    <h1>
      	Welcome!, ${namef} 
      	<br />
      
      <span class="color-secondary">
<h1>Your account is created successfully..</h1>
      </span>
      <br />
      </h1>
      <div style="margin-top:50px;">
      </div>
      </div>
       <div class="box-two">
    <div class="image" >
    <img src="images/user.png" >
    </div>
    </div>
  </div>


</body>
</html>