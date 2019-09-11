<%-- 
    Document   : loginForm
    Created on : Sep 10, 2019, 10:44:16 AM
    Author     : sanjeewa_s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In Page</title>
        <link href="loginForm.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="main">
        <form action="/WebApplication7/Signin" method="POST">
                <input type="text" name="username" placeholder="Username" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="submit" value="Login">
                <div>
                <% System.out.println(request.getParameter("isAutenticated"));
                    if(request.getParameter("isAutenticated").equals("false")){%>
                    <label style="color: red">Username or Password Incorrect!</label>
                <%}%>
                </div>
        </form>
   </div>
    </body>
</html>
