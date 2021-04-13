<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="admin_head.jsp" />
    <title>Admin Users</title>
</head>
<body>
<div class="wrapper">
    <jsp:include page="admin_sidebar.jsp" />
    <div class="table1" id="table1">
        <table class="styled-table">
            <thead>
            <tr>
                <th>Username</th>
                <th>Age</th>
                <th>Email</th>
<%--                <td></td>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
<%--                    <td><a href="#" class="myButton">block</a></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/popup_buttons.js"></script>
</body>