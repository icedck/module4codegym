<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Condiment Result</h1>
<h2>Ur select:</h2>
<ul>
  <c:forEach var="item" items="${condiments}">
    <li>${item}</li>
  </c:forEach>
</ul>
</body>
</html>
