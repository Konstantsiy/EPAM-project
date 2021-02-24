<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="admin_head.jsp" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/availability_check.css">
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
                    <td><img src="data:image/jpg;base64,${author.image}" width="60" height="75"></td>
                    <td>${author.name}</td>
                    <td>${author.surname}</td>
                    <td><a href="${pageContext.request.contextPath}/controller?command=delete_author&id=${author.id}" class="myButton">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="popup" id="popup-3">
            <div class="overlay"></div>
            <div class="content" style="height: 700px; top: 240%;">
                <div class="close-btn" onclick="togglePopup3()">&times;</div>
                <!-- --------------------add from for authors------------------------- -->
                <h1>What is the author?</h1>
                <form id="add-form" class="add-form" method="post" enctype="multipart/form-data" action="upload">
                    <input type="hidden" name="command" value="add_author">
                    <input type="file" name="author_image" />
                    <label for="author_name">
                        <input type="text" placeholder="Author name" name="author_name" id="author_name" required>
                    </label>
                    <div id="result_name" class="popup-result no-visible"></div>
                    <label for="author_surname">
                        <input type="text" placeholder="Author surname" name="author_surname" id="author_surname" required>
                    </label>
                    <div id="result_surname" class="popup-result no-visible"></div>
                    <label for="bio">
                        <textarea class="bio" placeholder="Author biography" name="author_bio" id="bio" cols="20" rows="8"></textarea>
                    </label>
                    <input id="btn-add" type="submit" class="searching" value="Append" style="margin-top: 20px;">
                </form>
                <!-- --------------------add from for authors------------------------- -->
            </div>
        </div>
        <div class="popup-btn-container">
            <button class="popup-btn" onclick="togglePopup3()"><i class="fas fa-plus"></i></button>
<%--            <button class="popup-btn" onclick="togglePopup4()"><i class="fas fa-search"></i></button>--%>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/popup_buttons.js"></script>
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/author_check.js" type="text/javascript"></script>
</body>