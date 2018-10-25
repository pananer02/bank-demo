<%-- 
    Document   : login
    Created on : Oct 26, 2018, 1:01:01 AM
    Author     : naijab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        ${loginResponse}
        <form action="Login" method="post">
            Username: <input type="text" name="username" />
            <br/>
            Password: <input type="password" name="password" /><br/>
            <input type="submit" />
        </form>
    </body>
</html>
