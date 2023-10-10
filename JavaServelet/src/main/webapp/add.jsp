<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>bookstore::index</title>
  </head>
  <body>
  <form action="/bookstore/store" method="POST">
    Title: <input type="text" name="title">
    <button type="submit" value="add">add</button>
  </form>
  </body>
</html>
