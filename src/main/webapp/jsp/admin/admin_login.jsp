<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale.pageContent"/>

<fmt:message key="login.email" var="emailValue" />
<fmt:message key="login.password" var="passwordValue" />
<fmt:message key="login.submit" var="submitValue" />
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Admin Login</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Abel&family=Yusei+Magic&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Yusei+Magic&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/validation.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formcheck.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin_login.css">

</head>
<body>
<img src="${pageContext.request.contextPath}/images/admin_login.jpg" class="account-image">
<div class="container">
    <form class="registration" method="post" action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="admin_login">
        <h1>Admin Login</h1>
        <label for="email">
            <input type="email" placeholder="Email" id="email" name="email" required>
        </label>
        <label for="password">
            <input type="password" placeholder="Password" id="password" name="password" maxlength="20" minlength="8" required>
        </label>
        <br>
        <input type="submit" class="btn-registr" value="Sign In">
    </form>
</div>
</body>
</html>