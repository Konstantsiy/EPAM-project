<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" type="text/css">
    <jsp:include page="../include/links.jsp"></jsp:include>
    <title>Document</title>
</head>
<body>
<!-- ---------------------------navbar--------------------------------- -->
<jsp:include page="../include/navbar.jsp"></jsp:include>
<!-- -------------------------intro---------------------------------- -->
<div class="intro">
    <div class="intro-content">
        <div class="book-cover" style="box-shadow: 0 0 100px rgb(237 119 119);">
            <div class="book-img">
                <img class="intro-book-img" src="data:image/jpg;base64,${book.image}">
            </div>
            <div class="book-content">
                <div class="book-title">${book.title}</div>
                <div class="book-author">
                    Author:
                    <div class="author-container">
                        <a class="author-popup-btn" href="#popup">${book.author.name} ${book.author.surname}</a>
                        <div class="popup" id="popup">
                            <div class="popup-inner">
                                <div class="photo">
                                    <img class="intro-book-img" src="data:image/jpg;base64,${book.author.image}">
                                </div>
                                <div class="text">
                                    <h1>${book.author.name} biography</h1>
                                    <p>${authorBio}</p>
                                </div>
                                <a class="close" href="#">X</a>
                            </div>
                        </div>
                    </div>
                    <!-- Author: <a href="#" class="author-href">Name Surname</a> -->
                </div>
                <div class="book-genres">
                    <p>Genre: ${book.genre.title}</p>
                </div>
                <span class="book-line">ooooooooooooooooooooooooooooooooooooooooo</span>
                <p>Price: ${book.price} $</p>
                <p>Pages: ${book.size}</p>
                <p>Publishing year: ${book.year}</p>
                <p>Cover: ${book.cover}</p>
<%--                <div class="pay-box">--%>
<%--                    <a href="#" class="btn-pay btn-white btn-animation-1">Add to Cart</a>--%>
<%--                </div>--%>
            </div>
        </div>
        <div class="intro-text">
            <p>${book.desc}</p>
        </div>
    </div>
</div>
<!-- -------------------------footer---------------------------------->
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
<script src="https://use.fontawesome.com/323395ee44.js"></script>
<script src="${pageContext.request.contextPath}/js/appear_book.js"></script>
</html>