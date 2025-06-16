<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save" method="post">
    <label><input type="checkbox" name="condiment" value="Lettuce">Lettuce</label>
    <label><input type="checkbox" name="condiment" value="Tomato">Tomato</label>
    <label><input type="checkbox" name="condiment" value="Mustard">Mustard</label>
    <label><input type="checkbox" name="condiment" value="Sprouts">Sprouts</label>
    <br>
    <input type="submit" value="save">
</form>
</body>
</html>