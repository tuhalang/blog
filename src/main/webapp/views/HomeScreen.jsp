<%--
  Created by IntelliJ IDEA.
  User: tao-thao
  Date: 17/10/2020
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value="/static/css/home.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<div class="navbar">
    <div id="logo">
        <img src="<c:url value="/static/img/fbfe575.svg"/>" alt="Lazzy"/>
    </div>
    <nav>
        <div class="icon-menu">
            <i class="fas fa-stream" id="menu"></i>
        </div>
        <ul class="dropdown">
            <li><a href="#">Home</a></li>
            <li><a href="#">Categories</a></li>
            <li><a href="#">Login</a></li>
            <li><a href="#">Logout</a></li>
        </ul>
    </nav>
</div>
<div id="welcome">
    <div class="banner-image">
        <img src="<c:url value="/static/img/banner.jpg" />" alt="Me 1" class="banner-image-1" style="">
    </div>
    <div class="title-welcome">
        <div class="content-welcome">
            <h1>Welcome to</h1>
            <h1 class="h0">Lazzzy</h1>
            <div class="search-bar">
                <i class="fab fa-searchengin"></i>
                <input placeholder="Search here"/>
            </div>
        </div>
        <div class="night">
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
            <div class="shooting_star"></div>
        </div>
    </div>
</div>
<div class="container">
    <div class="list-post">
        <c:forEach var="i" begin="1" end="5">
            <jsp:include page="common/sub_post.jsp"></jsp:include>
        </c:forEach>
    </div>
    <div class="list-categories">
        <input placeholder="Tìm kiếm chủ đề" id = 'search-categ'/>
        <h2>Categories</h2>
        <c:forEach var="i" begin="1" end="5">
            <div class="sub_categ">
                <label>Fashion</label>
                <p class="amount-post">(6)</p>
            </div>
        </c:forEach>
    </div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
