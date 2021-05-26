<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 

<%@ page import="model.*" %> 
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feed</title>
</head>
<body>
<link  href="./css/style.css" rel="stylesheet">
<link  href="./css/styles.css" rel="stylesheet">
<link  href="./bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>

<div class="main">
  <div class="main_resize">
    <div class="header">
    
      <div class="logo">
        <h1><span>Social</span>Spark<small></small></h1>
      </div>
      
      
      <div class="search">
       <form method="post"  action="search">
         <div class="wrapper">
	<input type="text" class="input" 
	placeholder="Search Friends here..." id="fname" name="fname">
	<button type="submit"  class="searchbtn" name="srch"><i class="fa fa-search"></i></button>
	
             
</div>
<div style="font-size:25px">
              <span class="btn"></span>
             <a href="Logout"> <i class = "fa fa-power-off"></i></a></div>
	


</form>
         
        <!--/searchform -->
       
      
              
             
              
      <div class="clr"></div>
      <div class="menu_nav">
        <ul>
          <li ><a href="Home.jsp">
             <span class="glyphicon glyphicon-home" > Home</span>
              </a></li>
         <li ><a href= "#">
             <span class="glyphicon glyphicon-align-justify" > Feed</span>
              </a></li>
          <li ><a href="Sendmsg.jsp">
             <span class="glyphicon glyphicon-envelope" > Messages</span>
              </a></li>
          <li ><a href="notifications.jsp">
             <span class="glyphicon glyphicon-bell" > Notifications</span>
              </a></li>
          <li ><a href="#">
             <span class="glyphicon glyphicon-user" > Requests</span>
              </a></li>
            <div class="dropdown">  
         <li><a href="#">
        
             <span class="glyphicon glyphicon-cog" class="dropbtn" > Settings</span>
            
      <div class="dropdown-content">
   <button onclick="myFunction2()" class="btn">Clear account data</button>
   <script>
function myFunction2() {
  var txt;
  if (confirm("Do you want to clear account data?")) {
    txt = "";
  } else {
    txt = "";
  }
 
}
</script>
    <button onclick="myFunction3()" class="btn">Delete account</button>
<script>
function myFunction3() {
  var txt;
  if (confirm("Do you want to delete account?")) {
    txt = "";
  } else {
    txt = "";
  }
  
}
</script>
  </div>
    
    </a></li>
      </div>
        <div class="clr"></div>
        <div class=logo>
          <h1><span>Welcome! </span>${userName}<small></small></h1>
          </div>
      </div>
      <div class="hbg"><img src="images/header_images.jpg" width="923" height="291" alt="" /></div>
    </div>
    <div class="content">
      <div class="content_bg">
        <div class="mainbar">
          <div class="article">
            <h2>Friend's Posts     </h2>
            <tag:forEach var="allPOST" items="${allPOST}">
          
            <H6 >Post by ${allPOST.getFullname()}  </H6>
            
            <div>
            
            
              
            
      <form action="PostsOperationServlet"method="POST">
              
              
              <input  type="text" value ="${allPOST.getContent()}"  style="width:50%;
              background:Linen;height:230px;border-radius:8px"><br>
                <H9 >LIKES  ${allPOST.getLikes()}  </H9>
                
                  <input type="hidden"  name="likecount" value="${allPOST.getLikes()} ">  
                  
          <button type="submit"   value= "${allPOST.getPostId()}"     class="btn icon" name ="Like"><i class="fa fa-thumbs-up"></i></button>
          <button type="submit" value= "${allPOST.getPostId()}"  class="btn icon"><i class="fa fa-thumbs-down"></i></button>
           <button type="submit" value= "${allPOST.getPostId()}"   class="btn icon"   name ="savepost" ><i class="fa fa-save"></i></button>    
                 <div>
                </div>
                 
           
            </form>
          
            </div>
              </tag:forEach>
          </div>
          <div class="article">
            
            <div class="clr"></div>
           
            <div class="clr"></div>
          </div>
          
        </div>
       <div class="sidebar">
          <div class="gadget">
            
            <ul class="sb_menu">
           
	        
	        
 			
 <fieldset class="fieldset">
                  <br>
                  <legend class="legend">Your Friends </legend>
                  <tag:forEach var="frnds" items="${frnds}">

                  <H6> ${frnds.getUserid()}</H6>
		
		<form action="sendingMsg" method="post" >
<button type="submit"  value ="${frnds.getFrndid()}"name="FRNDID" class="btn icon"><i class="fa fa-envelope"></i></button>
</form>

<form action="FriendOperation" method="post">
<button type="submit"  value ="${frnds.getFrndid()}"name="view" class="btn icon"><i class="fa fa-user-circle-o"></i></button>
<button type="submit"  value ="${frnds.getFrndid()}"name="remove" class="btn icon"><i class="fa fa-user-times"></i></button>

	</tag:forEach>
	</fieldset>
	</form>
   
    </ul>
    <br><br><br>
            <div class="clr"></div>
            <ul class="sb_menu">
             
                
                <fieldset class="fieldset">
                  
                  
                   <legend class="legend">Suggestions </legend>
                  <tag:forEach var="frndsugestion" items="${frndsugestion}">
                 <H6> ${frndsugestion.getName()}</H6>
                 <form action="AddFrnd" method="post" >
                 
              
              
		
		<button class="button" type="submit"  value ="${frndsugestion.getEmail()}"name="Add" >add friend</button>
		
		
		
	</tag:forEach>
	</fieldset>
	
	</form>
	
	</ul>
          </div>
          
          
             
          <div class="gadget">
            
            <div class="clr"></div>
            
          </div>
          
            </div>
          </div>
        </div>
        <div class="clr"></div>
      </div>
    </div>
  </div>
  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>Image Gallery</span></h2>
        <img src="images/imag.png" width="58" height="58" alt="" />
        <img src="images/jsp.jpg" width="58" height="58" alt="" />
        <img src="images/jdbc.jpg" width="58" height="58" alt="" />
        <img src="images/cookie.png" width="58" height="58" alt="" />
        <img src="images/pic_5.jpg" width="58" height="58" alt="" />
        <img src="images/pic_6.jpg" width="58" height="58" alt="" /> </div>
      <div class="col c2">
        <h2><span>Wise Words</span></h2>
        <p>" We can let circumstances rule us, or we can take charge and rule our lives from within."</p>
      </div>
      <div class="col c3">
        <h2><span>About</span></h2>
        <p>The project named "SocialSpark" followed the 'MVC' pattern whose back end  is designed by using Java 
        advance concepts such as: cookies,sessions,JSP,JDBC,servlets and many more.It is designed by Harman whereas, 
          front end of this project is designed by Anmoldeep Kaur which is purely based on html and css components.
           
         </p>
      </div>
      <div class="clr"></div>
    </div>
  </div>
</div>
<div class="footer">
  <div class="footer_resize">
   
    <div class="clr"></div>
  </div>
</div>
</div>

</body>
</html>