<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
</head>
<body>
    <jsp:include page="include/header.jsp"/>
    <br>
    <br>
    <p>Hello, ${username}</p>
    <br>
    <br>
<%--    <c:forEach items="${users}" var="user">--%>
<%--        <tr>--%>
<%--            <td>${user.username}</td>--%>
<%--            <td>${user.age}</td>--%>
<%--            <td>${user.email}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
    <jsp:include page="include/footer.jsp"/>
</body>
</html>