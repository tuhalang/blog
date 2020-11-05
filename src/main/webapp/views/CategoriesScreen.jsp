<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 29/10/2020
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSS</title>
    <link rel="stylesheet" href="<c:url value="/static/css/categories.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="head-tags">
    <div style="font-size: 18px;font-weight: 550;">CATEGORIES(2034)</div>
    <div class="space-fill"></div>
    <div class="search-categ">
        <input />
    </div>
</div>
<div class="list-tags">
    <c:forEach var="i" begin="1" end="12">
        <jsp:include page="common/tag_detail.jsp"></jsp:include>
    </c:forEach>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
