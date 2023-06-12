<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/8/2023
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchanging</title>
</head>
<body>
<h1>Money converter</h1>
<form action="/convert-money" method="post">
    <span>Input USD: </span>
    <span><input type="text" name="USD"></span>
    <br>
    <button>Convert</button>
    <br>
    <span>VND: </span>
    <span>${total}</span>
</form>
</body>
</html>
