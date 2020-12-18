<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 28/10/2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Category</title>
    <link rel="stylesheet" href="<c:url value="/static/css/category.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container">
    <div class="info-category">
        <img src="${categ.getImage()}"/>
        <div class="categ">
            <h2>${categ.getName()}</h2>
            <p><span>${categ.getNumOfPosts()}</span> bài viết</p>
        </div>
    </div>
    <div id="divider">
        <div class="divider-1"></div>
        <div class="divider-2"><i class="fas fa-chevron-down"></i></div>
        <div class="divider-1"></div>
    </div>
    <div class="list-posts">
        <c:forEach items="${posts}" var="post">
            <jsp:include page="common/post_categ.jsp">
                <jsp:param name="title" value="${post.getTitle()}"/>
                <jsp:param name="summary" value="${post.getSummary()}"/>
                <jsp:param name="userName" value="${post.getUserName()}"/>
                <jsp:param name="id" value="${post.getId()}"/>
            </jsp:include>
        </c:forEach>
    </div>
</div>
</body>
</html>