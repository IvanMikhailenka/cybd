<%@ page import="playList.Song" %>
<%@ page import="Hibernate.QueriesToDb" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 10.11.2016
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach items="${songList}" var="song">
        <p>${song}</p>
    </c:forEach>
    <form action="/page" method="post">
        <p>Input Song name, duration and genre</p>
        <input type="text" name="name" value="someSong">
        <input type="text" name="duration" value="1.22">
        <input type="text" name="genre" value="genre">
        <input type="submit" name="getLogin" value="Submit">
    </form>
</body>
</html>
