<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
        <h3>Book List</h3>
        <ul>
            <c:forEach var="book" items="${books}">
                <li>${book.title}</li>
            </c:forEach>
        </ul>
        <br>
        <a href="/bookstore">back</a>
    </body>
</html>