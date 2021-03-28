<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
            <p class="p-title">Newest Books</p>
            <div class="container-book-list new-books-container">
                <div class="container-book">
                    <div class="container-book-img">
                        <img src="${pageContext.request.contextPath}/images/it.jpg" alt="">
                    </div>
                    <div class="container-book-content">
                        <h2>Book Title</h2>
                        <p>24.5 $</p>
                        <a href="#view"><button class="view-button">View</button></a>
                    </div>
                </div>
                <div class="container-book">
                    <div class="container-book-img">
                        <img src="${pageContext.request.contextPath}/images/it.jpg" alt="">
                    </div>
                    <div class="container-book-content">
                        <h2>Book Title</h2>
                        <p>24.5 $</p>
                        <a href="#view"><button class="view-button">View</button></a>
                    </div>
                </div>
                <div class="container-book">
                    <div class="container-book-img">
                        <img src="${pageContext.request.contextPath}/images/it.jpg" alt="">
                    </div>
                    <div class="container-book-content">
                        <h2>Book Title</h2>
                        <p>24.5 $</p>
                        <a href="#view"><button class="view-button">View</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- -------------------------genres---------------------------------->
<div class="all-genres intro-genres">
    <ul>
        <li>Horror</li>
        <li>Fantasy</li>
        <li>Comedy</li>
        <li>Fiction</li>
        <li>Adventure</li>
        <li>Comics</li>
        <li>Anime</li>
    </ul>
</div>
<!-- -------------------------authors---------------------------------->
<div class="all-authors intro-authors">
    <ul>
        <li>Author1</li>
        <li>Author2</li>
        <li>Author3</li>
        <li>Author4</li>
    </ul>
</div>
</div>
<!-- -------------------------footer---------------------------------->
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script src="https://use.fontawesome.com/323395ee44.js"></script>
<script src="${pageContext.request.contextPath}/js/appear_home.js"></script>
</html>