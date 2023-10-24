<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>bookstore::index</title>
</head>
<body>
<h1><%= "Welcome to Zephyr Bookstore!" %></h1>
<br/>
<a href="/bookstore/store">Books</a>
<a href="/bookstore/add.jsp">Add</a>
<a href="/bookstore/find_by_title.jsp">Find</a>
<form action="/bookstore/login.jsp" method="POST">
  <button type="submit" value="logout">login</button>
</form>
<form action="/bookstore/logout" method="POST">
  <button type="submit" value="logout">logout</button>
</form>
</body>
</html>