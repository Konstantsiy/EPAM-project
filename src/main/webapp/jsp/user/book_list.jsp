<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/bookstore/epam/home.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">

    <link href="https://fonts.googleapis.com/css2?family=Catamaran&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Patrick+Hand&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Merienda+One&family=Patrick+Hand&family=Sansita+Swashed&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Courgette&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
<!-- ---------------------------navbar--------------------------------- -->
<div class="navbar">
    <div class="logo"><img class="logo-img" src="/bookstore/epam/images/books-logo.png" alt=""></div>
    <div class="box">
        <i class="fa fa-search" aria-hidden="true"></i>
        <input type="text" name="" placeholder="Search book...">
    </div>
    <a href="#home">Home</a>
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
        <li>
            <br>
            <div class="book-wrapper">
                <div class="book-special-cover">
                    <img src="/bookstore/epam/images/it.jpg" alt="">
                </div>
                <div class="book-special-info">
                    <p class="simple">Book Title</p>
                    <p class="book-author-small">Author Name Surname</p>
                    <p class="simple">25.4 $</p>
                    <div class="book-buttons">
                        <a href="#" class="a-add">Add to cart</a>
                        <a href="#" class="a-view" style="margin-left: 10px;">View</a>
                    </div>
                </div>
            </div>
        </li>
        <li>
            <br>
            <div class="book-wrapper">
                <div class="book-special-cover">
                    <img src="/bookstore/epam/images/it.jpg" alt="">
                </div>
                <div class="book-special-info">
                    <p class="simple">Book Title</p>
                    <p class="book-author-small">Author Name Surname</p>
                    <p class="simple">25.4 $</p>
                    <div class="book-buttons">
                        <a href="#" class="a-add">Add to cart</a>
                        <a href="#" class="a-view" style="margin-left: 10px;">View</a>
                    </div>
                </div>
            </div>
        </li>
        <li>
            <br>
            <div class="book-wrapper">
                <div class="book-special-cover">
                    <img src="/bookstore/epam/images/it.jpg" alt="">
                </div>
                <div class="book-special-info">
                    <p class="simple">Book Title</p>
                    <p class="book-author-small">Author Name Surname</p>
                    <p class="simple">25.4 $</p>
                    <div class="book-buttons">
                        <a href="#" class="a-add">Add to cart</a>
                        <a href="#" class="a-view" style="margin-left: 10px;">View</a>
                    </div>
                </div>
            </div>
        </li>
        <li>
            <br>
            <div class="book-wrapper">
                <div class="book-special-cover">
                    <img src="/bookstore/epam/images/it.jpg" alt="">
                </div>
                <div class="book-special-info">
                    <p class="simple">Book Title</p>
                    <p class="book-author-small">Author Name Surname</p>
                    <p class="simple">25.4 $</p>
                    <div class="book-buttons">
                        <a href="#" class="a-add">Add to cart</a>
                        <a href="#" class="a-view" style="margin-left: 10px;">View</a>
                    </div>
                </div>
            </div>
        </li>
    </ul>
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
<script src="/bookstore/epam/appear_book_list.js"></script>
</html>