<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/9/2023
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
    <table>
        <tr>
            <th>No.</th>
            <th>Bill's ID</th>
            <th>Condiments</th>
        </tr>
        <c:forEach varStatus="status" items="${sandwichList}" var="sandwich">
            <tr>
                <td>${status.count}</td>
                <td style="text-align: center">${sandwich.idBills}</td>
                <td>${sandwich.condiments}</td>
            </tr>
        </c:forEach>
    </table>

<button style="background-color: darkseagreen">
    <a style="color: black; text-decoration: none" href="/sandwich/add">Add new sandwich!</a>
</button>
</body>
</html>
