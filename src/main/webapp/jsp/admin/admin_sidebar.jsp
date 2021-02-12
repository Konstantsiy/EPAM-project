<div class="sidebar">
    <h2>Warehouse</h2>
    <ul>
        <li>
            <button id="for_books"><i class="fas fa-book" id="for_book"></i>
                <a href="${pageContext.request.contextPath}/admin_home?command=view_all_books">Books</a>
            </button>
        </li>
        <li>
            <button id="for_users"><i class="fas fa-user" id="for_user"></i>
                <a href="${pageContext.request.contextPath}/admin_home?command=view_all_users">Users</a>
            </button>
        </li>
        <li>
            <button id="for_authors" style="display: flex;"><i class="fas fa-users" id="for_author"></i>
                <a href="${pageContext.request.contextPath}/admin_home?command=view_all_authors">Authors</a>
            </button>
        </li>
        <li>
            <button id="for_genres"><i class="fas fa-list" id="for_genre"></i>
                <a href="${pageContext.request.contextPath}/admin_home?command=view_all_genres">Genres</a>
            </button>
        </li>
    </ul>
</div>