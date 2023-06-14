<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/14/2023
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/result" method="post">
    <table>
        <tr>
            <td>First number:</td>
            <td>
                <input type="text" name="firstNumber">
            </td>
        </tr>
        <tr>
            <td>Second Number: </td>
            <td>
                <input type="text" name="secondNumber">
            </td>
        </tr>
        <tr>
            <td>Operator: </td>
            <td>
                <button value="+" name="operator"> Addition (+) </button>
                <button value="-" name="operator"> Subtraction (-) </button>
                <button value="*" name="operator"> Multiplication (*) </button>
                <button value="/" name="operator"> Division (/) </button>
            </td>
        </tr>
        <tr>
            <td>Result: </td>
            <td style="font-weight: bolder">${result}</td>
        </tr>
    </table>
</form>
</body>
</html>
