<%--
  Created by IntelliJ IDEA.
  User: tao-thao
  Date: 17/10/2020
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge, chrome=1"/>
    <link rel="icon" type="image/png" sizes="192x192"  href="<c:url value="/static/img/android-icon-192x192.png"/>"/>
    <link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/static/img/favicon-32x32.png"/>"/>
    <link rel="icon" type="image/png" sizes="96x96" href="<c:url value="/static/img/favicon-96x96.png"/>"/>
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/static/img/favicon-16x16.png"/>"/>
    <link rel="manifest" href="<c:url value="/static/img/manifest.json"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/home.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
    <script async src="https://www.googletagmanager.com/gtag/js?id=G-PX5CNE1YB5"></script>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }

        gtag('js', new Date());

        gtag('config', 'G-PX5CNE1YB5');
    </script>
</head>
<body>
<div class="navbar">
    <div id="logo">
        <img src="<c:url value="/static/img/logo.png"/>" alt="Lazzy"/>
    </div>
    <nav>
        <div class="icon-menu">
            <i class="fas fa-stream" id="menu"></i>
        </div>
        <ul class="dropdown">
            <li><a href="#">Trang chủ</a></li>
            <li><a href="<c:url value="/categories"/>">Danh mục</a></li>
            <c:if test="${USERNAME==null}">
                <li id="login" onclick="return showLogin();"><a href="#">Đăng nhập</a></li>
            </c:if>
            <c:if test="${USERNAME!=null}">
                <li><a href="#" onclick="return logout();">Đăng xuất</a></li>
                <li><a href="<c:url value="/secure/profile"/>" onclick="return goToProfile();">Quản lí tài khoản</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
<div id="btn-edit-auth" onclick="return onEdit('<c:url value="/secure/edit"/>')">
    <i class="fas fa-pencil-alt"></i>
</div>
<div id="welcome">
    <div class="banner-image">
        <img src="<c:url value="/static/img/banner.jpg" />" alt="Me 1" class="banner-image-1" style="">
    </div>
    <div class="title-welcome">
        <div class="content-welcome">
            <h1>Welcome to</h1>
            <h1 class="h0">Lazyyy</h1>
            <form action="<c:url value="/post"/>" method="post" onsubmit="return searchPost(this)">
                <div class="search-bar">
                    <i class="fab fa-searchengin"></i>
                    <input placeholder="Search here" type="text" id="search-input" name="postName"/>
                    <button type="submit" style="display: none">
                        Tìm kiếm
                    </button>
                </div>
            </form>
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
        <c:forEach items="${latestPost}" var="post">
            <jsp:include page="common/sub_post.jsp">
                <jsp:param name="title" value="${post.getTitle()}"/>
                <jsp:param name="summary" value="${post.getSummary()}"/>
                <jsp:param name="id" value="${post.getId()}"/>
            </jsp:include>
        </c:forEach>
    </div>
    <div class="list-categories">
        <form action="<c:url value="/categories"/>" method="post" onsubmit="return searchCategory(this)">
            <input placeholder="Tìm kiếm chủ đề" id='search-categ' name="categoryName"/>
            <button type="submit" style="display: none">
                search
            </button>
        </form>
        <h2>Categories</h2>
        <c:forEach items="${categories}" var="category">
            <div class="sub_categ" onclick="return goToCategory(${category.getId()});">
                <label>${category.getName()}</label>
                <p class="amount-post">(${category.getNumOfPosts()})</p>
            </div>
        </c:forEach>
    </div>
</div>
<jsp:include page="common/modal_auth.jsp"></jsp:include>
<jsp:include page="common/footer.jsp"></jsp:include>
<script src="<c:url value="/static/js/home.js"/>"></script>
</body>
</html>
