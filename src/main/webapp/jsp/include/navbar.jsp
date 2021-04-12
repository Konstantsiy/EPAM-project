<div class="navbar">
    <div class="logo"><img class="logo-img" src="${pageContext.request.contextPath}/images/books-logo.png" alt=""></div>
    <div class="box">
        <i class="fa fa-search" aria-hidden="true"></i>
        <input type="text" name="" placeholder="Search book...">
    </div>
    <a href="${pageContext.request.contextPath}/controller?command=go_home">Home</a>
    <a href="${pageContext.request.contextPath}/controller?command=go_about">About</a>
    <div class="dropdown">
        <button class="dropbtn"><i class="fa fa-user-circle" aria-hidden="true"></i></button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/controller?command=go_login">Sign In</a>
            <a href="${pageContext.request.contextPath}/controller?command=go_registration">Sign Up</a>
        </div>
    </div>
</div>