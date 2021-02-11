<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="locale.pageContent"/>

<fmt:message key="reg.username" var="usernameValue" />
<fmt:message key="reg.age" var="ageValue" />
<fmt:message key="reg.email" var="emailValue" />
<fmt:message key="reg.password" var="passwordValue"/>
<fmt:message key="reg.repeatPassword" var="repeatPasswordValue"/>
<fmt:message key="reg.submit" var="submitValue"/>

<!doctype html>
<html lang="${sessionScope.locale}">
<head>
    <meta charset="utf-8">
    <title><fmt:message key="reg.title"/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/validation.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formcheck.css">
</head>
<body>
<img src="${pageContext.request.contextPath}/images/registration.jpg" class="account-image">
<div class="container">
    <form class="registration" id="registration" method="post"
          action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="registration">
        <h1><fmt:message key="reg.form.title"/></h1>

        <label for="username">
            <input type="text" placeholder="${usernameValue}" id="username" name="username" required>
            <ul class="input-requirements">
                <li><fmt:message key="reg.usernameCondition1"/></li>
                <li><fmt:message key="reg.usernameCondition2"/></li>
            </ul>
        </label>

        <label for="age">
            <input type="number" placeholder="${ageValue}" id="age" name="age" required>
            <ul class="input-requirements">
                <li><fmt:message key="reg.ageCondition1"/></li>
            </ul>
        </label>

        <label for="email">
            <input type="email" placeholder="${emailValue}" id="email" name="email" required>
            <ul class="input-requirements">
                <li><fmt:message key="reg.emailCondition1"/></li>
            </ul>
        </label>

        <label for="password">
            <input type="password" placeholder="${passwordValue}" id="password" name="password" maxlength="20" minlength="8" required>
            <ul class="input-requirements">
                <li><fmt:message key="reg.passwordCondition1"/></li>
                <li><fmt:message key="reg.passwordCondition2"/></li>
                <li><fmt:message key="reg.passwordCondition3"/></li>
                <li><fmt:message key="reg.passwordCondition4"/></li>
                <li><fmt:message key="reg.passwordCondition5"/></li>
            </ul>
        </label>

        <label for="password_repeat">
            <input type="password" placeholder="${repeatPasswordValue}" id="password_repeat" name="password_repeat" maxlength="20" minlength="8" required>
        </label>
        <br>
        <input type="submit" class="btn-registr" value="${submitValue}">
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/validation_script.js"></script>
</body>
</html>