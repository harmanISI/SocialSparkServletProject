<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
   


<%@ page import="model.*" %> 
<%@ page import="java.util.ArrayList" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> View Friend's Profile  </title>

 <link  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">

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
<tag:if test="${namef == null}">
<script>
alert(" USER not fOUND search again by clicking back button");
</script>
</tag:if>

		<div class="parent">
  <div class="box-one">
    <h1>
      Hi,<br />
      
      <span class="color-secondary">
      <tag:if test="${namef != null}">
    <h1>Welcome to the Profile of: ${namef}</h1>
      </span>
      <br />
      <h3>
	Email id of your Friend:<span class="color-secondary">${emailf} </span>
     
    </h3>
   
    <h3>
	${namef} created account on:<span class="color-secondary">${datef} </span>
     
    </h3>
    <div style="margin-top:50px;">
    </div>
  </div>
  <div class="box-two">
    <div class="image" >
    <img src="images/user.png" >
    
    </div>
  </div>
</div>
</tag:if>


</body>
</html>