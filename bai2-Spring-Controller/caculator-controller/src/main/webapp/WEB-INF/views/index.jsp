<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>

<form action="caculate" method="post">
    <input type="text" name="num1" value="0">
    <input type="text" name="num2" value="0">
    <br>
    <button type="submit" name="operator" value="+">+</button>
    <button type="submit" name="operator" value="-">-</button>
    <button type="submit" name="operator" value="*">*</button>
    <button type="submit" name="operator" value="/">/</button>
</form>
<br>
<c:if test="${not empty result}">
    <p>Result: ${result}</p>
</c:if>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>