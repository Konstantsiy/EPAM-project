<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin_home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/language.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin_home_buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/formcheck.css">
</head>
<body>
<div class="wrapper">
    <div class="sidebar">
        <h2>Warehouse</h2>
        <ul>
            <li><button id="for_books"><i class="fas fa-book" id="for_book"></i>Books</button></li>
            <li><button id="for_users"><i class="fas fa-user" id="for_user"></i>Users</button></li>
            <li><button id="for_authors"><i class="fas fa-users" id="for_author"></i>Authors</button></li>
            <li><button id="for_genres"><i class="fas fa-list" id="for_genre"></i>Genres</button></li>
        </ul>
    </div>
    <div class="main_content">
        <div class="header">
            Welcome home, Admin-${username}
            <div class="lang-menu" style="margin-left: 1000px; margin-top: -20px;">
                <div class="selected-lang">
                    English
                </div>
                <ul>
                    <li>
                        <a href="" class="en">English</a>
                    </li>
                    <li>
                        <a href="" class="ru">Russian</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="table1" id="table1">
            <table class="styled-table">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Age</th>
                    <th>Email</th>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.age}</td>
                        <td>${user.email}</td>
                        <td><a href="#" class="myButton">block</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="table2" id="table2" hidden="true">
            <table class="styled-table">
                <thead>
                <tr>
                    <th>Book</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Genres</th>
                    <th>Cover</th>
                    <th>Size</th>
                    <th>Price</th>
                    <th>Year</th>
                    <th>Publisher</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>[picture]</td>
                    <td>IT</td>
                    <td>Stephen King</td>
                    <td>Horror</td>
                    <td>Hard</td>
                    <td>117</td>
                    <td>17 $</td>
                    <td>1986</td>
                    <td>Издательский дом "Питер"</td>
                    <td><a href="#" class="myButton">edit</a></td>
                    <td><a href="#" class="myButton">delete</a></td>
                </tr>
                </tbody>
            </table>
            <div class="popup" id="popup-1">
                <div class="overlay"></div>
                <div class="content" style="height: 670px; top: 170%;">
                    <div class="close-btn" onclick="togglePopup1()">&times;</div>
                    <!-- --------------------add from for books------------------------- -->
                    <h1>What are we going to read?</h1>
                    <form class="add-form">
                        <div class="upload-btn-wrapper">
                            <button class="btn">Upload file</button>
                            <input type="file" name="myfile" />
                        </div>
                        <label for="book_title_en">
                            <input type="text" placeholder="Book title (Eng)" id="book_title_en" name="book_title_en">
                        </label>
                        <label for="book_title_ru">
                            <input type="text" placeholder="Book title (Rus)" name="book_title_ru" id="book_title_ru">
                        </label>
                        <label for="size">
                            <input type="number" placeholder="Pages number" name="size" id="size">
                        </label>
                        <select name="book_author" id="book_author">
                            <option value="Author1">Author1</option>
                            <option value="Author2">Author2</option>
                            <option value="Author3">Author3</option>
                            <option value="Author4">Author4</option>
                        </select>
                        <div class="selector-genres">
                            <select name="book_genre1" id="book_genre1">
                                <option value="Genre1">Genre1</option>
                                <option value="Genre2">Genre2</option>
                                <option value="Genre3">Genre3</option>
                                <option value="Genre4">Genre4</option>
                            </select>
                            <select name="book_genre2" id="book_genre2">
                                <option value="Genre1">Genre1</option>
                                <option value="Genre2">Genre2</option>
                                <option value="Genre3">Genre3</option>
                                <option value="Genre4">Genre4</option>
                            </select>
                            <select name="book_genre3" id="book_genre3">
                                <option value="Genre1">Genre1</option>
                                <option value="Genre2">Genre2</option>
                                <option value="Genre3">Genre3</option>
                                <option value="Genre4">Genre4</option>
                            </select>
                        </div>
                        <select name="book_cover" id="book_cover">
                            <option value="Cover1">Cover1</option>
                            <option value="Cover1">Cover2</option>
                            <option value="Cover1">Cover3</option>
                        </select>
                        <select name="book_publisher" id="book_publisher">
                            <option value="P1">P1</option>
                            <option value="P2">P2</option>
                            <option value="P3">P3</option>
                        </select>
                        <label for="publishing_year">
                            <input type="number" placeholder="Publishing year" id="publishing_year" name="publishing_year">
                        </label>
                        <input type="submit" class="searching" value="Append" style="margin-top: 20px;">
                    </form>
                    <!-- --------------------add from------------------------- -->
                </div>
            </div>
            <div class="popup" id="popup-2">
                <div class="overlay"></div>
                <div class="content">
                    <div class="close-btn" onclick="togglePopup2()">&times;</div>
                    <h1>Where are the books, Lebowski?</h1>
                    <!-- ---------------------search form for books---------------------- -->
                    <from class="search-book">
                        <select name="_genre" id="_genre">
                            <option value="Horror">Horror</option>
                            <option value="Fiction">Fiction</option>
                            <option value="Adventure">Adventure</option>
                            <option value="Fantastic">Fantastic</option>
                        </select>
                        <select name="author" id="author">
                            <option value="Author1">Author1</option>
                            <option value="Author2">Author2</option>
                            <option value="Author3">Author3</option>
                            <option value="Author4">Author4</option>
                        </select>
                        <select name="cover" id="cover">
                            <option value="Cover1">Cover1</option>
                            <option value="Cover1">Cover2</option>
                            <option value="Cover1">Cover3</option>
                        </select>
                        <select name="publisher" id="publisher">
                            <option value="P1">P1</option>
                            <option value="P2">P2</option>
                            <option value="P3">P3</option>
                        </select>
                        <div class="selector">
                            <label for="year_from">
                                <input type="number" placeholder="from" id="year_from" name="year_from">
                            </label>
                            <label for="year_to">
                                <input type="number" placeholder="to" id="year_to" name="year_to">
                            </label>
                        </div>
                        <input type="submit" class="searching" value="Search">
                    </from>
                    <!-- ---------------------search form---------------------- -->
                </div>
            </div>
            <!-- <button class="big-button" onclick="togglePopup()">+</button> -->
            <div class="popup-btn-container">
                <button class="popup-btn" onclick="togglePopup1()"><i class="fas fa-plus"></i></button>
                <button class="popup-btn" onclick="togglePopup2()"><i class="fas fa-search"></i></button>
            </div>
        </div>
        <div class="table3" id="table3" hidden="true">
            <table class="styled-table">
                <thead>
                <tr>
                    <th>Author</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th></td>
                    <th></td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>[picture]</td>
                    <td>Stephen</td>
                    <td>King</td>
                    <td><a href="#" class="myButton">edit</a></td>
                    <td><a href="#" class="myButton">delete</a></td>
                </tr>
                </tbody>
            </table>
            <div class="popup" id="popup-3">
                <div class="overlay"></div>
                <div class="content" style="height: 500px; top: 150%;">
                    <div class="close-btn" onclick="togglePopup3()">&times;</div>
                    <!-- --------------------add from for authors------------------------- -->
                    <h1>What is the author?</h1>
                    <form class="add-form">
                        <div class="upload-btn-wrapper">
                            <button class="btn">Upload file</button>
                            <input type="file" name="myfile" />
                        </div>
                        <label for="name_en">
                            <input type="text" placeholder="Author name (Eng)" name="name_en" id="name_en">
                        </label>
                        <label for="name_ru">
                            <input type="text" placeholder="Author name (Rus)" name="name_ru" id="name_ru">
                        </label>
                        <label for="surname_en">
                            <input type="text" placeholder="Author surname (Eng)" name="surname_en" id="surname_en">
                        </label>
                        <label for="surname_ru">
                            <input type="text" placeholder="Author surname (Rus)" name="surname_ru" id="surname_ru">
                        </label>
                        <input type="submit" class="searching" value="Append" style="margin-top: 20px;">
                    </form>
                    <!-- --------------------add from------------------------- -->
                </div>
            </div>
            <div class="popup" id="popup-4">
                <div class="overlay"></div>
                <div class="content">
                    <div class="close-btn" onclick="togglePopup4()">&times;</div>
                    <h1>Search 4</h1>
                    <!-- ---------------------search form for authors---------------------- -->
                    <label for="name">
                        <input type="text" placeholder="Author name" name="name" id="name">
                    </label>
                    <label for="surname">
                        <input type="text" placeholder="Author surname" name="surname" id="surname">
                    </label>

                    <from class="search-book">
                        <select name="genre" id="genre">
                            <option value="Horror">Horror</option>
                            <option value="Fiction">Fiction</option>
                            <option value="Adventure">Adventure</option>
                            <option value="Fantastic">Fantastic</option>
                        </select>

                        <input type="submit" class="searching" value="Search" style="margin-top: 30px;">
                    </from>
                    <!-- ---------------------search form---------------------- -->
                </div>
            </div>
            <!-- <button class="big-button" onclick="togglePopup()">+</button> -->
            <div class="popup-btn-container">
                <button class="popup-btn" onclick="togglePopup3()"><i class="fas fa-plus"></i></button>
                <button class="popup-btn" onclick="togglePopup4()"><i class="fas fa-search"></i></button>
            </div>
        </div>
        <div class="table4" id="table4" hidden="true">
            <table class="styled-table">
                <thead>
                <tr>
                    <th>Title</th>
                    <th></td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Adventure</td>
                    <td><a href="#" class="myButton">delete</a></td>
                </tr>
                </tbody>
            </table>
            <div class="popup" id="popup-5">
                <div class="overlay"></div>
                <div class="content" style="height: 300px; top: 100%;">
                    <div class="close-btn" onclick="togglePopup5()">&times;</div>
                    <!-- --------------------add from for genres------------------------- -->
                    <h1>Come on, compose</h1>
                    <form class="add-form">
                        <label for="title_en">
                            <input type="text" placeholder="Genre (Eng)" name="title_en" id="title_en">
                        </label>
                        <label for="title_ru">
                            <input type="text" placeholder="Genre (Rus)" name="title_ru" id="title_ru">
                        </label>
                        <input type="submit" class="searching" value="Append" style="margin-top: 20px;">
                    </form>
                    <!-- --------------------add from------------------------- -->
                </div>
            </div>
            <div class="popup-btn-container">
                <button class="popup-btn" onclick="togglePopup5()"><i class="fas fa-plus"></i></button>
            </div>
        </div>
    </div>
</div>
<script>
    document.getElementById('for_users').onclick = function() {
        document.getElementById('table1').hidden = false
        document.getElementById('table2').hidden = true
        document.getElementById('table3').hidden = true
        document.getElementById('table4').hidden = true
    }
    document.getElementById('for_books').onclick = function() {
        document.getElementById('table1').hidden = true
        document.getElementById('table2').hidden = false
        document.getElementById('table3').hidden = true
        document.getElementById('table4').hidden = true
    }
    document.getElementById('for_authors').onclick = function() {
        document.getElementById('table1').hidden = true
        document.getElementById('table2').hidden = true
        document.getElementById('table3').hidden = false
        document.getElementById('table4').hidden = true
    }
    document.getElementById('for_genres').onclick = function() {
        document.getElementById('table1').hidden = true
        document.getElementById('table2').hidden = true
        document.getElementById('table3').hidden = true
        document.getElementById('table4').hidden = false
    }
    function togglePopup1() {
        document.getElementById("popup-1").classList.toggle("active");
    }
    function togglePopup2() {
        document.getElementById("popup-2").classList.toggle("active");
    }
    function togglePopup3() {
        document.getElementById("popup-3").classList.toggle("active");
    }
    function togglePopup4() {
        document.getElementById("popup-4").classList.toggle("active");
    }
    function togglePopup5() {
        document.getElementById("popup-5").classList.toggle("active");
    }
</script>
</body>
</html>