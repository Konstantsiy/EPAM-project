<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin_home.css">
</head>
<body>
<div class="wrapper">
    <div class="sidebar">
        <h2>Warehouse</h2>
        <ul>
            <li><button id="for_books"><i class="fas fa-book" id="for_book"></i>Books</button></li>
            <li><button id="for_users"><i class="fas fa-user" id="for_user"></i>Users</button></li>

            <!-- <li><a href="#"><i class="fas fa-book" id="for_book"></i>Books</a></li>
            <li><a href="#"><i class="fas fa-user" id="for_user"></i>Users</a></li> -->

            <!-- <li><a href="#"><i class="fas fa-address-card"></i>About</a></li> -->
            <!-- <li><a href="#"><i class="fas fa-project-diagram"></i>portfolio</a></li>
            <li><a href="#"><i class="fas fa-blog"></i>Blogs</a></li>
            <li><a href="#"><i class="fas fa-address-book"></i>Contact</a></li>
            <li><a href="#"><i class="fas fa-map-pin"></i>Map</a></li> -->
        </ul>
        <!-- <div class="social_media">
          <a href="#"><i class="fab fa-facebook-f"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="fab fa-instagram"></i></a>
      </div> -->
    </div>
    <div class="main_content">
        <div class="header">Welcome home, Admin-${username}.</div>
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
<%--                <tr>--%>
<%--                    <td>user1</td>--%>
<%--                    <td>23</td>--%>
<%--                    <td>email1@gmail.com</td>--%>
<%--                    <td><a href="#" class="myButton">block</a></td>--%>
<%--                </tr>--%>
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
                    <td>Genres</td>
                    <td>Price</td>
                    <td>Year</td>
                    <td>Publisher</td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>[picture]</td>
                    <td>IT</td>
                    <td>Stephen King</td>
                    <td>Horror</td>
                    <td>17 $</td>
                    <td>1986</td>
                    <td>Издательский дом "Питер"</td>
                    <td><a href="#" class="myButton">edit</a></td>
                    <td><a href="#" class="myButton">delete</a></td>
                </tr>
                <!-- <tr class="active-row">
                    <td>Melissa</td>
                    <td>5150</td>
                </tr> -->
                <!-- and so on... -->
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    document.getElementById('for_books').onclick = function() {
        document.getElementById('table1').hidden = true
        document.getElementById('table2').hidden = false
    }
    document.getElementById('for_users').onclick = function() {
        document.getElementById('table2').hidden = true
        document.getElementById('table1').hidden = false
    }
</script>
</body>
</html>