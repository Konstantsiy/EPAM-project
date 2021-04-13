<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" type="text/css">
    <jsp:include page="../include/links.jsp"></jsp:include>
    <title>Home</title>
</head>
<body>
<!-- ---------------------------navbar--------------------------------- -->
    <jsp:include page="../include/navbar.jsp"></jsp:include>
<!-- -------------------------intro---------------------------------->
<div class="intro">
    <div class="intro-content">
        <section class="seach">
            <span class="linee"></span>
            <div class="search-img">
                <img src="${pageContext.request.contextPath}/images/cool2.png" alt="">
            </div>
        </section>
        <div class="new-books">
            <p class="p-title" style="font-family: 'Patrick Hand', cursive; font-size: 25px;">Newest Books</p>
            <div class="container-book-list new-books-container">
                <c:forEach items="${books}" var="book">
                    <div class="container-book">
                        <div class="container-book-img">
                            <img src="data:image/jpg;base64,${book.image}" width="60" height="80">
                        </div>
                        <div class="container-book-content">
                            <h2 style=" font-size: 20px;">${book.title}</h2>
                            <p>${book.price} $</p>
                            <a href="${pageContext.request.contextPath}/controller?command=view_single_book&id=${book.id}"><button class="view-button">View</button></a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<%--<div class="intro">--%>
<%--    <div class="intro-content-2">--%>
<%--        <section class="seach">--%>
<%--            <span class="linee"></span>--%>
<%--            <div class="search-img">--%>
<%--                <img src="${pageContext.request.contextPath}/images/cool4.png" style="width:420px; height:340px; margin-left:550px;" alt="">--%>
<%--            </div>--%>
<%--        </section>--%>
<%--        <div class="new-books">--%>
<%--            <p class="p-title">For Children</p>--%>
<%--            <div class="container-book-list new-books-container">--%>
<%--                <c:forEach items="${books1}" var="book1">--%>
<%--                    <div class="container-book">--%>
<%--                        <div class="container-book-img">--%>
<%--                            <img src="data:image/jpg;base64,${book1.image}" width="60" height="80">--%>
<%--                        </div>--%>
<%--                        <div class="container-book-content">--%>
<%--                            <h2 style=" font-size: 20px;">${book1.title}</h2>--%>
<%--                            <p>${book1.price} $</p>--%>
<%--                            <a href="${pageContext.request.contextPath}/controller?command=view_single_book&id=${book1.id}"><button class="view-button">View</button></a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- -------------------------genres---------------------------------->
<div class="all-genres intro-genres">
    <div class="dropdown selected-group" style="width: 100px; font-family: 'Sansita Swashed', cursive;">
        <button class="dropbtn">Genres</button>
        <div class="dropdown-content">
            <c:forEach items="${genres}" var="genre">
                <a href="${pageContext.request.contextPath}/controller?command=search_c&category=genre&id=${genre.id}">${genre.title}</a>
            </c:forEach>
        </div>
    </div>
</div>
<%--<div class="all-genres intro-genres">--%>
<%--    <select class="selected-group">--%>
<%--        <c:forEach items="${genres}" var="genre">--%>
<%--            <option value="${pageContext.request.contextPath}/controller?command=search_c&category=genre&id=${genre.id}">${genre.title}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--</div>--%>
<!-- -------------------------authors---------------------------------->
<div class="all-authors intro-authors">
    <div class="dropdown selected-group" style="width: 100px; font-family: 'Sansita Swashed', cursive;">
        <button class="dropbtn">Genres</button>
        <div class="dropdown-content">
            <c:forEach items="${authors}" var="author">
                <a href="${pageContext.request.contextPath}/controller?command=search_c&category=author&id=${author.id}">${author.name} ${author.surname}</a>
            </c:forEach>
        </div>
    </div>
</div>
<%--<div class="all-authors intro-authors">--%>
<%--    <select class="selected-group">--%>
<%--        <c:forEach items="${authors}" var="author">--%>
<%--            <option value="${pageContext.request.contextPath}/controller?command=search_c&category=author&id=${author.id}">${author.name} ${author.surname}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--</div>--%>
<!-- -------------------------footer---------------------------------->
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script src="https://use.fontawesome.com/323395ee44.js"></script>
<script src="${pageContext.request.contextPath}/js/appear_home.js"></script>
</html>