<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../include/links.jsp"></jsp:include>
    <title>Books</title>
</head>
<body>
<!-- ---------------------------navbar--------------------------------- -->
<jsp:include page="../include/navbar.jsp"></jsp:include>
<!-- -------------------------genres---------------------------------->
<div class="all-genres intro-genres">
    <ul>
        <li><a href="">Horror</a></li>
        <li><a href="">Adventure</a></li>
        <li><a href="">Detectives</a></li>
        <li><a href="">Fantasy</a></li>
        <li><a href="">Philosophy</a></li>
        <li><a href="">Educational</a></li>
        <li><a href="">Children</a></li>
    </ul>
</div>
<!-- -------------------------genres---------------------------------->
<!-- -------------------------authors---------------------------------->
<div class="all-authors intro-authors">
    <ul>
        <c:forEach items="${authors}" var="author">
            <li><a href="">${author.name} ${author.surname}</a></li>
        </c:forEach>
    </ul>
</div>
<!-- -------------------------authors---------------------------------->
<!-- -------------------------sorting---------------------------------->
<div class="sort-by">
    <div class="dropdown">
        <button class="dropbtn">Sort by <i class="fa fa-sort-desc"></i></button>
        <div class="dropdown-content">
            <a href="#">newest</a>
            <a href="#">oldest</a>
        </div>
    </div>
</div>
<!-- -------------------------special books list---------------------------------->
<div class="book-list-special">
    <ul>
        <c:forEach items="${books}" var="book">
            <li>
                <br>
                <div class="book-wrapper">
                    <div class="book-special-cover">
                        <img src="data:image/jpg;base64,${book.image}">
                    </div>
                    <div class="book-special-info">
                        <p class="simple">${book.title}</p>
                        <p class="book-author-small">${book.author.name} ${book.author.surname}</p>
                        <p class="simple">${book.price} $</p>
                        <div class="book-buttons">
                            <a href="#" class="a-add">Add to cart</a>
                            <a href="#" class="a-view" style="margin-left: 10px;">View</a>
                        </div>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</div>
<!-- -------------------------footer---------------------------------->
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script src="https://use.fontawesome.com/323395ee44.js"></script>
<script src="/bookstore/epam/appear_book_list.js"></script>
</html>