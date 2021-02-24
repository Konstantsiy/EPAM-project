<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../include/links.jsp"></jsp:include>
    <title>Document</title>
</head>
<body>
<!-- ---------------------------navbar--------------------------------- -->
<jsp:include page="../include/navbar.jsp"></jsp:include>
<!-- -------------------------intro---------------------------------- -->
<div class="intro">
    <div class="intro-content">
        <div class="book-cover">
            <div class="book-img">
                <img class="intro-book-img" src="${pageContext.request.contextPath}/images/it.jpg" alt="">
            </div>
            <div class="book-content">
                <div class="book-title">Book Title</div>
                <div class="book-author">
                    Author:
                    <div class="author-container">
                        <a class="author-popup-btn" href="#popup">Name Surname</a>
                        <div class="popup" id="popup">
                            <div class="popup-inner">
                                <div class="photo">
                                    <img src="${pageContext.request.contextPath}/images/JKRowling.jpg" alt="">
                                </div>
                                <div class="text">
                                    <h1>Lorem ipsum dolor sit amet</h1>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ex velit, viverra non vulputate vitae, blandit vitae nisl. Nullam fermentum orci et erat viverra bibendum. Aliquam sed varius nibh, vitae mattis purus. Mauris elementum sapien non ullamcorper vulputate. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Sed eget felis sit amet eros viverra pulvinar.</p>
                                </div>
                                <a class="close" href="#">X</a>
                            </div>
                        </div>
                    </div>
                    <!-- Author: <a href="#" class="author-href">Name Surname</a> -->
                </div>
                <div class="book-genres">
                    <p>Genres: </p>
                    <ul class="book-genres-list">
                        <li>Horror</li>
                        <li>Fantasy</li>
                        <li>Adventure</li>
                    </ul>
                </div>
                <span class="book-line">ooooooooooooooooooooooooooooooooooooooooo</span>
                <p>Price: 24.5 $</p>
                <p>Pages: 125</p>
                <p>Publishing year: 1986</p>
                <p>Cover: Hard</p>
                <p>Publisher: P1</p>
                <div class="pay-box">
                    <a href="#" class="btn-pay btn-white btn-animation-1">Add to Cart</a>
                </div>
            </div>
        </div>
        <div class="intro-text">
            <p>It is a 1986 horror novel by American author Stephen King.
                It was his 22nd book, and his 17th novel written under his own name.
                The story follows the experiences of seven children as they are terrorized
                by an evil entity that exploits the fears of its victims to disguise itself
                while hunting its prey. "It" primarily appears in the form of Pennywise the
                Dancing Clown to attract its preferred prey of young children.

                The novel is told through narratives alternating
                between two periods and is largely told in the
                third-person omniscient mode. It deals with themes
                that eventually became King staples: the power of
                memory, childhood trauma and its recurrent echoes in
                adulthood, the malevolence lurking beneath the idyllic
                façade of the American small town, and overcoming evil
                through mutual trust and sacrifice.</p>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="footer-col">
                <h4>bookshop</h4>
                <ul style="margin-left: -40px;">
                    <li><a href="#">about us</a></li>
                    <li><a href="#">our books</a></li>
                    <li><a href="#">contacts</a></li>
                    <li><a href="#">shipping</a></li>
                </ul>
            </div>
            <div class="footer-col">
                <h4>contacts</h4>
                <ul style="margin-left: -40px;">
                    <li><a href="#">bookshop@gmail.com</a></li>
                    <li><a href="#">Minsk, Belarus</a></li>
                    <li><a href="#">EPAM Systems</a></li>
                </ul>
            </div>
            <div class="footer-col">
                <h4>follow us</h4>
                <div class="social-links">
                    <a href="#"><i class="fab fa-github"></i></a>
                    <a href="#"><i class="fab fa-vk"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-linkedin-in"></i></a>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
<script src="https://use.fontawesome.com/323395ee44.js"></script>
<script src="/bookstore/epam/appear_book.js"></script>
</html>