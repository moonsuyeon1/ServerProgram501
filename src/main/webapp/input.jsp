<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP3 - input</title>
</head>
<body>
<form action="result.jsp" method="post">
<input type="number" name="num1">
<input type="number" name="num2">
<button type="submit">전송</button>
</form>

<h1><%= "Hello World!3" %>
</h1>
<br/>
<a href="test3">test3</a>
</body>
</html>