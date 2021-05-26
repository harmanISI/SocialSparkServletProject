<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clear Account Data</title>
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<div class="about-section">
<h2> Click here to clear account data</h2>


<button onclick="myFunction()" class="button button4">Clear account data</button>

<p id="demo"></p>

<script>
function myFunction() {
  var txt;
  if (confirm("Do you want to clear account data?")) {
    txt = "Account data is cleared successfully!";
  } else {
    txt = "You pressed Cancel!";
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>
</div>





<div class="w3-container">
  <h2>W3.CSS Login Modal</h2>
  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-green w3-large">Login</button>

  <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:600px">

      <div class="w3-center"><br>
        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <img src="img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
      </div>

      <form class="w3-container" action="/action_page.php">
        <div class="w3-section">
          <label><b>Username</b></label>
          <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="usrname" required>
          <label><b>Password</b></label>
          <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="psw" required>
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Login</button>
          <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me
        </div>
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id01').style.display='none'" type="button" class="w3-button w3-red">Cancel</button>
        <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span>
      </div>

    </div>
  </div>
</div>

<div class="main-area">
    <div class="control-panel">
    <h1>Admin Control Panel</h1>
    <button class="categories">My Account </button><br /><br />
    <button class="categories">System Users </button><br /><br />
    <button class="categories">Applicants </button><br /><br />
    <button class="categories">Blacklist </button>
    <br /><br />
    <button class="categories">Jobs </button><br /><br />
    <button class="categories">Requirements </button><br />
    <br />
    <button class="categories">Reports </button> 
    <script>
    .control-panel {
        border: solid 1px #000;
    padding: 15px;
    border-radius: 15px;
    box-shadow: 5px 5px 5px;
    width: 300px;
    text-align: center;
    display: inline-block;
    height: 370px;
    background-color: #FFE400;
  }

  .main-area {
    width: 500px;
    margin: auto;
  }

  .categories{
    width: 200px;
  }
  </script>
            

</body>
</html>