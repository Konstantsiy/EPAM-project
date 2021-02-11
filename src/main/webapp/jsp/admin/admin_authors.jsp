<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="admin_head.jsp" />
</head>
<body>
<div class="wrapper">
    <jsp:include page="admin_sidebar.jsp" />
    <div class="table3" id="table3">
        <table class="styled-table">
            <thead>
            <tr>
                <th>Author</th>
                <th>Name</th>
                <th>Surname</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${authors}" var="author">
                <tr>
                    <td><img src="data:image/jpg;base64,${author.image}" width="120" height="150"></td>
                    <td>${author.name}</td>
                    <td>${author.surname}</td>
                    <td><a href="#" class="myButton">block</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="popup" id="popup-3">
            <div class="overlay"></div>
            <div class="content" style="height: 400px; top: 120%;">
                <div class="close-btn" onclick="togglePopup3()">&times;</div>
                <!-- --------------------add from for authors------------------------- -->
                <h1>What is the author?</h1>
                <form class="add-form" method="post" enctype="multipart/form-data" action="upload">
                    <input type="hidden" name="command" value="admin_add_author">
                    <input type="file" name="author_image" />
                    <label for="author_name">
                        <input type="text" placeholder="Author name" name="author_name" id="author_name">
                    </label>
                    <label for="author_surname">
                        <input type="text" placeholder="Author surname" name="author_surname" id="author_surname">
                    </label>
                    <input type="submit" class="searching" value="Append" style="margin-top: 20px;">
                </form>
                <!-- --------------------add from for authors------------------------- -->
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
        <div class="popup-btn-container">
            <button class="popup-btn" onclick="togglePopup3()"><i class="fas fa-plus"></i></button>
            <button class="popup-btn" onclick="togglePopup4()"><i class="fas fa-search"></i></button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/popup_buttons.js"></script>
</body>