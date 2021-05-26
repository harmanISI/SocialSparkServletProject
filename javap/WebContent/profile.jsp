<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 

<%@ page import="model.*" %> 
<%@ page import="java.util.ArrayList" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hello</h1> <h3>${userName}</h3>
 <form action="AddFrnd" method="post" >
                  <br><br><br>
                  <H6>SUUGESTIONS</H6>
                  <tag:forEach var="frndsugestion" items="${frndsugestion}">
                 <H3> ${frndsugestion.getName()}</H3>
		<h3>
		<button type="submit"  value ="${frndsugestion.getEmail()}"name="Add" >add friend</button>
		
		</h3>
	</tag:forEach>
	
             


	
	
	
	

</body>
</html>