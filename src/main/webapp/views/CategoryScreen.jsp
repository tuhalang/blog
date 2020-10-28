<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 28/10/2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSS</title>
    <link rel="stylesheet" href="<c:url value="/static/css/category.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="container">
    <div class="info-category">
        <img src="https://s3-ap-southeast-1.amazonaws.com/kipalog.com/css.png_cqep5dt185"/>
        <div class="categ">
            <h2>Css</h2>
            <p><span>25</span> bài viết</p>
        </div>
    </div>
    <div id="divider">
        <div class="divider-1"></div>
        <div class="divider-2"><i class="fas fa-chevron-down"></i></div>
        <div class="divider-1"></div>
    </div>
    <div class="list-posts">
        <c:forEach var="i" begin="1" end="5">

        </c:forEach>
    </div>
</div>
</body>
</html>