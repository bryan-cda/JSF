<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>bookstore::login</title>
    </head>
    <body>
    <h1><%= "Welcome to Zephyr Bookstore!" %></h1>
    <br>
        <form action="/bookstore/login" method="POST">
            username: <input type="login" name="username">
            password <input type="password" name="password">
            <button type="submit" value="login">login</button>
        </form>
    <br>
    </body>
</html>