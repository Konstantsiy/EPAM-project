<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="locale.pageContent"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/language.css">
<%--------------------------------------------------------------------------------------------------%>
<div class="navbar">
    <div class="logo"><img class="logo-img" src="${pageContext.request.contextPath}/images/books-logo.png" alt=""></div>
    <div class="box">
        <i class="fa fa-search" aria-hidden="true"></i>
        <input type="text" name="" placeholder="Search book...">
    </div>
    <a href="${pageContext.request.contextPath}/controller?command=home">Home</a>
    <a href="#about">About</a>
    <a href="#cart"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
    <div class="dropdown">
        <button class="dropbtn"><i class="fa fa-user-circle" aria-hidden="true"></i></button>
        <div class="dropdown-content">
            <a href="#">Sign In</a>
            <a href="#">Sign Up</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn"><i class="fa fa-language" aria-hidden="true"></i></button>
        <div class="dropdown-content">
            <a href="#">English</a>
            <a href="#">Русский</a>
        </div>
    </div>
</div>