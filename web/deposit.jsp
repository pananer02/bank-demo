<%-- 
    Document   : myaccount
    Created on : Oct 26, 2018, 1:21:52 AM
    Author     : naijab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deposit</title>
    </head>
    <body>
        <h1>Deposit</h1>
        <b>${transactionResponse}</b>
        <h3>Balance: <span style="color: green">${acc.balance}</span></h3>
        <form action="Deposit" method="post">
            <input type="number" name="depositValue" /><br/>
            <input type="submit" />
        </form>
        <hr/>
        <a href="MyAccount">Back to My Account</a>
    </body>
</html>
