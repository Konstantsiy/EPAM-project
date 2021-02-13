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
    <div class="table4" id="table4">
        <table class="styled-table">
            <thead>
            <tr>
                <th>Title (Eng)</th>
                <th>Title (Rus)</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${genres}" var="genre">
                <tr>
                    <td>${genre.titleEng}</td>
                    <td>${genre.titleRus}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/controller?command=delete_genre&id=${genre.id}" class="myButton">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="popup" id="popup-5">
            <div class="overlay"></div>
            <div class="content" style="height: 340px; top: 80%;">
                <div class="close-btn" onclick="togglePopup5()">&times;</div>
                <!-- --------------------add from for genres------------------------- -->
                <h1>Come on, compose</h1>
                <form class="add-form">
                    <input type="hidden" name="command" value="admin_add_genre">
                    <label for="title_eng">
                        <input type="text" placeholder="Genre (Eng)" name="title_eng" id="title_eng">
                    </label>
                    <div id="adding_genre_result_eng" class="popup-result no-visible"></div>
                    <label for="title_rus">
                        <input type="text" placeholder="Genre (Rus)" name="title_rus" id="title_rus">
                    </label>
                    <div id="adding_genre_result_rus" class="popup-result no-visible"></div>
                    <input type="submit" class="searching" value="Append" style="margin-top: 20px;">
                </form>
                <!-- ---------------------------------------------------------------- -->
            </div>
        </div>
        <div class="popup-btn-container">
            <button class="popup-btn" onclick="togglePopup5()"><i class="fas fa-plus"></i></button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/popup_buttons.js"></script>
<script src="http://code.jquery.com/jquery-2.2.4.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/genre_check.js" type="text/javascript"></script>
</body>