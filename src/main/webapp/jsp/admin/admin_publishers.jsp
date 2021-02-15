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
    <div class="table5" id="table5">
        <table class="styled-table">
            <thead>
            <tr>
                <th>Publisher</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${publishers}" var="publisher">
                <tr>
                    <td>${publisher.title}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/controller?command=delete_publisher&id=${publisher.id}" class="myButton">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="popup" id="popup-5">
            <div class="overlay"></div>
            <div class="content" style="height: 280px; top: 200%;">
                <div class="close-btn" onclick="togglePopup5()">&times;</div>
                <!-- --------------------add from for publishers------------------------- -->
                <h1>Add new publisher</h1>
                <form class="add-form">
                    <input type="hidden" name="command" value="add_publisher">
                    <label for="p_title">
                        <input type="text" placeholder="Genre" name="title" id="p_title" required>
                    </label>
                    <div id="adding_p_result" class="popup-result no-visible"></div>
                    <input type="submit" class="searching" id="btn-add" value="Append" style="margin-top: 20px;">
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
<script src="${pageContext.request.contextPath}/js/publisher_check.js" type="text/javascript"></script>
</body>