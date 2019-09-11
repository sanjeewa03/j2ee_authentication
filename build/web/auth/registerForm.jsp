<%-- 
    Document   : registerForm
    Created on : Sep 10, 2019, 10:58:35 AM
    Author     : sanjeewa_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Here</title>
        <link href="registerForm.css" rel="stylesheet" type="text/css">
 
    </head>
    <body>
        <div id="main">
       <form action="/WebApplication7/Signup">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
    <input type="hidden" id="mode" name="mode" value="2">
    <label for="username"><b>User Name</b></label>
    <input type="text" placeholder="Enter username" name="username" required>
    <% System.out.println(request.getParameter("added"));
                    if(request.getParameter("added").equals("false")){%>
                    <label style="color: red">Username already taken !</label>
                <%}%>
                <br>
    
    <label for="fname"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="fname" required>

    <label for="lname"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="lname" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Repeat Password" name="password" required>
    <hr>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  

  <div class="container signin">
    <p>Already have an account? <a href="/WebApplication7/Signin">Sign in</a>.</p>
  </div>
</form>
        </div>
    </body>
</html>
