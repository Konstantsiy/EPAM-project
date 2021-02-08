<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale.pageContent"/>

<fmt:message key="login.email" var="emailValue" />
<fmt:message key="login.password" var="passwordValue" />
<fmt:message key="login.submit" var="submitValue" />

<!doctype html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="utf-8">
    <title><fmt:message key="login.title"/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/validation.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formcheck.css">
</head>
<body>
<img src="${pageContext.request.contextPath}/images/login.jpg" class="account-image">
<div class="container">
    <form class="registration" method="post" action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="login">
        <h1 style="margin-top: 40px;"><fmt:message key="login.form.title"/></h1>

        <label for="email">
            <input type="email" placeholder="${emailValue}" id="email" name="email" required>
        </label>

        <label for="password">
            <input type="password" placeholder="${passwordValue}" id="password" name="password" maxlength="20" minlength="8" required>
        </label>

        <br>
        <input type="submit" class="btn-login" value="${submitValue}">
        <div class="bottom-text"><fmt:message key="login.bottomText"/>
            <a href="${pageContext.request.contextPath}/jsp/registration.jsp"><fmt:message key="login.href"/></a>
        </div>
    </form>
</div>
</body>
</html>