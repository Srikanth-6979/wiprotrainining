<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>City List</title></head>
<body>
    <h2>City List</h2>
    <ul>
        <c:forEach var="city" items="${cities}">
            <li>${city}</li>
        </c:forEach>
    </ul>
</body>
</html>

