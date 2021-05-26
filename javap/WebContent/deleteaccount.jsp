<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete account</title>
</head>
<style>.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  height:650px;
  color: white;
}
.button4 {
  background-color: white;
  color: black;
  border: 2px solid #e7e7e7;
}

.button4:hover {background-color: #e7e7e7;}

.button {
  background-color: pink;
  border: none;
  color: black;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
  border-radius:50px;
}

</style>
<body>
<div class="about-section">
<h2> Click here to delete account</h2>


<button onclick="myFunction()" class="button button4">Delete account</button>

<p id="demo"></p>

<script>
function myFunction() {
  var txt;
  if (confirm("Do you want to delete account?")) {
    txt = "Account is deleted successfully!";
  } else {
    txt = "You pressed Cancel!";
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>
</div>


</body>
</html>