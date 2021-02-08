<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="locale.pageContent"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/language.css">
<nav>
    <div class="dropdown">
        <button><a href="#" class="simple-link"><fmt:message key="header.home"/></a></button>
        <div class="projects">
            <button><fmt:message key="header.genres"/></button>
            <ul>
                <li><a href="#">Horror</a></li>
                <li><a href="#">Fantastic</a></li>
                <li><a href="#">Fiction</a></li>
                <li><a href="#">Adventure</a></li>
            </ul>
        </div>
        <button><a href="#" class="simple-link"><fmt:message key="header.about"/></a></button>
        <button><a href="#" class="simple-link"><fmt:message key="header.cart"/></a></button>
        <button><a href="${pageContext.request.contextPath}/jsp/login.jsp" class="simple-link"><fmt:message key="header.action1"/></a></button>
    </div>
    <div class="lang-menu">
        <div class="selected-lang">
            English
        </div>
        <ul>
            <li>
                <a href="?sessionLocale=en" class="en"><fmt:message key="header.lang.en"/></a>
            </li>
            <li>
                <a href="?sessionLocale=ru" class="ru"><fmt:message key="header.lang.ru"/></a>
            </li>
        </ul>
    </div>
</nav>