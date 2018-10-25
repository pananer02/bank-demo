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
        <title>My Account</title>
    </head>
    <body>
        <h1>My Account</h1>
        <b>${transactionResponse}</b>
        <hr/>
        <h2 style="color: blue">${acc.name}</h2>
        <h3>Balance: <span style="color: green">${acc.balance}</span></h3>
        <hr/>
        <ul>
            <li><a href="Deposit">Deposit</a></li>
            <li><a href="Withdraw">Withdraw</li>
            <li><a href="History">History</li>
            <li><a href="Logout">Logout</li>    
        </ul>
    </body>
</html>
