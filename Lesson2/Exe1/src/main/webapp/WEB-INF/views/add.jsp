<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/9/2023
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Condiments' Options</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich/add" method="post">
    <table>
        <tr>
            <td>Bill's ID: </td>
            <td>
                <input type="text" name="idBills">
            </td>
        </tr>
        <tr>
            <td>
                <input type="checkbox" name="condiments">Lettuce
            </td>
            <td>
                <input type="checkbox" name="condiments">Tomatoes
            </td>
            <td>
                <input type="checkbox" name="condiments">Mustard
            </td>
            <td>
                <input type="checkbox" name="condiments">Sprouts
            </td>
        </tr>
    </table>
    <button>Save</button>
<%--    value="${sandwich.condiments}"--%>
</form>
</body>
</html>
