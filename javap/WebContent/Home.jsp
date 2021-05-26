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
<title>Home</title>
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
	       <input type="text" class="input" placeholder="Search Friends here..." id="fname" name="fname">
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
          
              <li ><a href= "profilerefresh?PGE=feed.jsp">
         
         
         
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
                <h1><span>Welcome! </span>${userName}<small></small>
             </h1>
          </div>
      </div>
              <div class="hbg"><img src="images/header_images.jpg" width="923" height="291" alt="" /></div>
    </div>
              <div class="content">
                <div class="content_bg">
                 <div class="mainbar">
                   <div class="article">
                      <div class="clr"></div>
                       <div>
                         <form action="CreatePostServlet" method="POST">
                           <input  type="text" name="postContent" placeholder="What's in your mind...." style="width:100%;
                              background:Linen;height:150px;border-radius:8px">
                             <input class="btn1 " type="submit" value="Submit">
                       </form>
                     </div>
                            <h2>Your Posts</h2>
                             <form action="PostsOperationServlet">
                               <div>
                                <tag:forEach var="mypost" items="${mypost}">
                                
                 <input value="${mypost.getContent()}"  placeholder="Your posts" id="textbox" type="text"  style="width:50%;
                      background:Linen;height:230px;border-radius:8px;"><h6>no. of likes-     ${mypost.getLikes()}  </h6>
           <button type="submit"  name ="Like"   value= "${mypost.getPostId()}"  class="btn icon"><i onclick="myFunction(this)" 
              class="fa fa-thumbs-up"></i>
           </button>
          
  <button  id="page-button" type="button" data-toggle="modal" data-target="#myModal"
  class="btn icon"><i class="fa fa-edit"></i></button>
 
  <!--the JQuery to grab the value and change the textbox-->
    <script>
        $(document).ready(function () {
            $('#page-button').click(function () {
                $('#modal-text').val($('#textbox').val());
                $('#textbox').val($('#modal-text').val());
                document.getElementById("textbox").disabled = true;
            });
        });
    </script>
    
        <!--textbox on main page-->
        
        <!-- Trigger the modal with a button -->
       

        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
         <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                          <h4 class="modal-title">Edit Post here:</h4>
                    </div>
                   
                    <div class="modal-body">
                        <!-- The Modal text box-->
                         <form action="Logout" method="GET">
                         <input id="modal-text" name="pp" type="text" style="width:100%;background:Linen;height:230px;border-radius:8px;"/>
                    </div>
                       <div class="modal-footer">
                         <button id="close-button" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                           <button id="edit-button" type="button" class="btn btn-default" data-dismiss="modal" value="">Edit</button>
                      </i></button>
                        </form>
                    </div>
                </div>
             </div>
        </div>
      <button type="submit" onclick="myFunction1()"  value= "${mypost.getPostId()}" name ="delete"   class="btn icon"><i class="fa fa-trash"></i></button> <br><hr>
       
    </form>
    <script>
function myFunction1() {
  var txt;
  if (confirm("Do you want to delete this post?")) {
    txt = "";
  } else {
    txt = "";
  }
 
}
</script>
           </tag:forEach> 
          </div>
       </div>
     </div> 
        <div class="sidebar">
          <div class="gadget">
             <ul class="sb_menu">
 			   <fieldset class="fieldset">
                  <br>
                  <legend class="legend"><h2>Your Friends</h2> </legend>
                   <tag:forEach var="frnds" items="${frnds}">
                    <H3 style="font-size:25px;font-weight:bold;font-color:#A52A2A"> ${frnds.getUserid()}</H3>
	                  <form action="sendingMsg" method="post" >
<button class="button" type="submit"  value ="${frnds.getFrndid()}"name="FRNDID" class="btn icon"><i class="fa fa-envelope">  
  Message</i></button> </form><br>

          <form action="FriendOperation" method="post">
       <button class="button" type="submit"  value ="${frnds.getFrndid()}"name="view" class="btn icon"><i class="fa fa-user-circle-o">    View Profile</i></button><br><br>

        <button class="button" type="submit"  value ="${frnds.getFrndid()}"name="remove" class="btn icon"><i class="fa fa-user-times">    Unfriend</i></button>

	     
       
	</form>
	 </tag:forEach>
	 </fieldset>
   </ul>
    <br><br><br>
            <div class="clr"></div>
             <ul class="sb_menu">
              <fieldset class="fieldset">
                <br>
                  <legend class="legend"><h2>Suggestions</h2> </legend>
                    <tag:forEach var="frndsugestion" items="${frndsugestion}">
                     <H3 style="font-size:25px;font-weight:bold;"> ${frndsugestion.getName()}</H3>
                      <form action="AddFrnd" method="post" >
  
     <button class="button" type="submit"  value ="${frndsugestion.getEmail()}"name="Add" ><i class="fas fa-user-plus">  
          Add friend</i></button>
	         </tag:forEach>
	      </fieldset>
       </form>
     </ul>
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