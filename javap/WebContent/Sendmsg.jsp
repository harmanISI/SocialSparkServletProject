<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Messages</title>
<link rel="stylesheet" href="./css/login.css">
<link rel="stylesheet" href="./css/style.css">
<link  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">  
</head>
<body>

<div style="width: 100%; display: table;">
        <div style="display: table-row; height: 100px;">
            <div style="width: 50%; display: table-cell; background: PeachPuff; ">
               <u><H1>Received Messages from ${frindid}-</H1></u>
                  <tag:forEach var="fMessages" items="${fMessages}">
               ${fMessages.getMsg()}<br>
                 ${fMessages.getDate()}<br><hr></tag:forEach> 
            </div>
 <div style="display: table-cell; background: PapayaWhip;text-align:right;"> 
 <u><H1>Sent Messages- </H1></u>
                 <tag:forEach var="msgs" items="${msgs}">
               ${msgs.getMsg()}<br>
               ${msgs.getDate()}<br><hr></tag:forEach>
               
            </div>
        </div>
    </div>	

  
           
 <h3>Logged in user ${ssnname}</h3>


<h1>Chatting with ${frindid}</h1>
<form action="Sendmsg" method="post" >

  <input type="text" name="to" placeholder="Name of the receipient" style="width:100%;
              background:Linen;height:40px;border-radius:8px" value ="${frindid}" size="50"><br><br>
 
<input type="text" name="msg"placeholder="Type a message here..." style="width:100%;
              background:Linen;height:60px;border-radius:8px" ><br><br>
<button  class="button"type="submit" >submit</button>	
<input class="button" type="reset" value="Reset">
</form>
 


</body>
</html>