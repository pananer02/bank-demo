<%-- 
    Document   : myaccount
    Created on : Oct 26, 2018, 1:21:52 AM
    Author     : naijab
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
    </head>
    <body>
        <h1>History</h1>
        <hr/>
        <table border="1">
            <tr>
                <th>NO</th>
                <th>Name</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Balance</th>
                <th>Date</th>
            </tr>
            <c:forEach items="${historyList}" var="item" varStatus="status">
                <tr>
                    <td>${status.count}</td>
                    <td>${item.accountId.name}</td>
                    <td>${item.type}</td>
                    <td>${item.amount}</td>
                    <td>${item.balance}</td>
                    <td>${item.date}</td>
                </tr>
            </c:forEach>
        </table>
        <hr/>
        <a href="MyAccount">Back to My Account</a>
    </body>
</html>
