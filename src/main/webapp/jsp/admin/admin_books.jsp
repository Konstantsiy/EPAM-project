<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="admin_head.jsp" />
</head>
<body>
<div class="wrapper">
    <jsp:include page="admin_sidebar.jsp" />
    <div class="table2" id="table2">
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
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td><img src="data:image/jpg;base64,${book.image}" width="60" height="75"></td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>
                        <c:forEach items="${book.genres}" var="genre">
                            <p>${genre.title}</p>
                        </c:forEach>
                    </td>
                    <td>${book.cover}</td>
                    <td>${book.size}</td>
                    <td>${book.price} $</td>
                    <td>${book.year}</td>
                    <td><a href="#" class="myButton">edit</a></td>
                    <td><a href="#" class="myButton">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="popup" id="popup-1">
            <div class="overlay"></div>
            <div class="content" style="height: 740px; top: 170%;">
                <div class="close-btn" onclick="togglePopup1()">&times;</div>
                <!-- --------------------add from for books------------------------- -->
                <h1>What are we going to read?</h1>
                <form class="add-form" action="upload" enctype="multipart/form-data" method="post">
                    <input type="hidden" name="command" value="add_book">
                    <input type="file" name="book_image" />
                    <label for="book_title">
                        <input type="text" placeholder="Book title" id="book_title" name="book_title" required>
                    </label>
                    <label for="book_size">
                        <input type="number" placeholder="Pages number" name="book_size" id="book_size" required>
                    </label>
                    <select name="book_author" id="book_author">
                        <option value="auth_id">Author Surname1</option>
                        <option value="Author2">Author2</option>
                        <option value="Author3">Author3</option>
                        <option value="Author4">Author4</option>
                    </select>
                    <div class="selector-genres">
                        <select name="book_genre1" id="book_genre1" required>
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
                    <select name="book_cover" id="book_cover" required>
                        <option value="Cover1">Cover1</option>
                        <option value="Cover2">Cover2</option>
                        <option value="Cover3">Cover3</option>
                    </select>
                    <label for="book_p_year">
                        <input type="number" placeholder="Publishing year" id="book_p_year" name="book_p_year" required>
                    </label>
                    <label for="book_desc">
                        <textarea class="desc" placeholder="Book description" name="book_desc" id="book_desc" cols="20" rows="8"></textarea>
                    </label>
                    <input type="submit" class="searching" value="Append" style="margin-top: 20px;">
                </form>
                <!-- --------------------add from for books------------------------- -->
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
        <div class="popup-btn-container">
            <button class="popup-btn" onclick="togglePopup1()"><i class="fas fa-plus"></i></button>
            <button class="popup-btn" onclick="togglePopup2()"><i class="fas fa-search"></i></button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/popup_buttons.js"></script>
</body>