<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/21/2023
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <style>
        table tr td{
            border: solid 1px; padding: 1px;
        }
    </style>
</head>
<body>
<h1>List</h1>
<table>
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Languages</th>
        <th>Page size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th></th>
    </tr>
    <c:forEach var="item" items="${list}" varStatus="status" >
        <tr>
            <td>${status.count}</td>
            <td>${item.id}</td>
            <td>${item.languages}</td>
            <td>${item.size}</td>
            <td>${item.spams}</td>
            <td>${item.signature}</td>
            <td>
                <button>
                    <a href="/home/update?id=${item.id}">Update</a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
