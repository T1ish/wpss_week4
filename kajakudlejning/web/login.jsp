<%-- 
    Document   : login.jsp
    Created on : Nov 30, 2016, 11:33:22 AM
    Author     : Z
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="centered">
            <h1>Velkommen til kajak booking</h1>
            <p>Log ind her</p>
            <form action="AllKayaks" method="POST">
                <input type="text" name="username" value="" placeholder="Insert Username"/>
                <br>
                <input type="password" name="password" value="" placeholder="Insert Password" />
                <br>
                <input type="submit" value="Log In" />
            </form>
        </div>
    </body>
</html>
