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
    <link href="https://fonts.googleapis.com/css2?family=Merienda+One&family=Patrick+Hand&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
<div class="logo"><img class="logo-img" src="/bookstore/epam/images/books-logo.png" alt=""></div>
<div class="navbar">
    <a href="#home">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Genres</button>
        <div class="dropdown-content">
            <a href="#">Horror</a>
            <a href="#">Adventure</a>
            <a href="#">Fiction</a>
        </div>
    </div>
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
<div class="intro">
    <div class="intro-content">
        <section class="seach">
            <div class="box">
                <i class="fa fa-search" aria-hidden="true"></i>
                <input type="text" name="" placeholder="Book title...">
            </div>
            <span class="line-right"></span>
            <span class="line-left"></span>
            <div class="search-img">
                <img src="/bookstore/epam/images/cat.png" alt="">
            </div>
        </section>
        <div class="new-books">
            <p class="p-title">New</p>
            <div class="container-book-list new-books-container">
                <div class="container-book">
                    <div class="container-book-img">
                        <img src="/bookstore/epam/images/it.jpg" alt="">
                    </div>
                    <div class="container-book-content">
                        <h2>Book Title</h2>
                        <p>24.5 $</p>
                        <a href="#view"><button class="view-button">View</button></a>
                    </div>
                </div>
                <div class="container-book">
                    <div class="container-book-img">
                        <img src="/bookstore/epam/images/it.jpg" alt="">
                    </div>
                    <div class="container-book-content">
                        <h2>Book Title</h2>
                        <p>24.5 $</p>
                        <a href="#view"><button class="view-button">View</button></a>
                    </div>
                </div>
                <div class="container-book">
                    <div class="container-book-img">
                        <img src="/bookstore/epam/images/it.jpg" alt="">
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
</div>
<div class="all-books">
    <div class="container-book-list">
        <!-- {% for book in book_list %} -->
        <div class="container-book">
            <div class="container-book-img">
                <img src="/bookstore/epam/images/it.jpg" alt="">
            </div>
            <div class="container-book-content">
                <h2>Book Title</h2>
                <p>24.5 $</p>
                <a href="#view"><button class="view-button">View</button></a>
            </div>
        </div>
        <div class="container-book">
            <div class="container-book-img">
                <img src="/bookstore/epam/images/it.jpg" alt="">
            </div>
            <div class="container-book-content">
                <h2>Book Title</h2>
                <p>24.5 $</p>
                <a href="#view"><button class="view-button">View</button></a>
            </div>
        </div>
        <div class="container-book">
            <div class="container-book-img">
                <img src="/bookstore/epam/images/it.jpg" alt="">
            </div>
            <div class="container-book-content">
                <h2>Book Title</h2>
                <p>24.5 $</p>
                <a href="#view"><button class="view-button">View</button></a>
            </div>
        </div>
        <div class="container-book">
            <div class="container-book-img">
                <img src="/bookstore/epam/images/it.jpg" alt="">
            </div>
            <div class="container-book-content">
                <h2>Book Title</h2>
                <p>24.5 $</p>
                <a href="#view"><button class="view-button">View</button></a>
            </div>
        </div>
        <div class="container-book">
            <div class="container-book-img">
                <img src="/bookstore/epam/images/it.jpg" alt="">
            </div>
            <div class="container-book-content">
                <h2>Book Title</h2>
                <p>24.5 $</p>
                <a href="#view"><button class="view-button">View</button></a>
            </div>
        </div>
        <div class="container-book">
            <div class="container-book-img">
                <img src="/bookstore/epam/images/it.jpg" alt="">
            </div>
            <div class="container-book-content">
                <h2>Book Title</h2>
                <p>24.5 $</p>
                <a href="#view"><button class="view-button">View</button></a>
            </div>
        </div>
        <!-- {% endfor %} -->
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
<script src="/bookstore/epam/appear_home.js"></script>
</html>