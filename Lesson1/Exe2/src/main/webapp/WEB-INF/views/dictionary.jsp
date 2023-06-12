<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/12/2023
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary Searching</title>
</head>
<body>
<h1>Your Dictionary</h1>
<form action="/translation" method="post">
    <span>Input English word: </span>
    <span>
        <input type="text" name="US">
    </span>
    <br>
    <button onclick="translate()">Translate</button>
    <p>${VN}</p>
</form>

<%--<script>--%>
<%--    function translate() {--%>
<%--        document.getElementById("result").innerHTML = "${US} means ${VN}.";--%>
<%--        console.log("${US} means ${VN}.");--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
