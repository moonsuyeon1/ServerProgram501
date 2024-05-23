<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP3 - result</title>
</head>
<body>
<h1>input.jsp에서 보낸 파라미터 정보를 받아서 출력</h1>
<%
String num1 = request.getParameter("num1");
String num2 = request.getParameter("num2");
    System.out.println(num1 + " : " + num2);
%>

아이디: <%=num1 %><br />
패스워드: <%=num2%><br />

<h1>${param.num1}</h1>
<h1>${param.num2}</h1>
<h1>${param.num1}+${param.num2}</h1>
<h1>${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>
</body>
</html>