<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 26/10/2020
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="<c:url value="/static/css/post_instance.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="container">
    <div class="fill-space">
        <div class="action-post">
            <i class="far fa-thumbs-up"></i>
            <i class="fas fa-comment-dots"></i>
        </div>
    </div>
    <div class="container-post">
        <div class="header-post">${post.getTitle()}</div>
        <div id="content-main"></div>
    </div>
    <div id="info-post">
        <div id="info-author">
            <i class="fas fa-user"></i>
            <div>
                <span>${owner.getUsername()}</span>
                <span>${numOfPosts} bài viết</span>
            </div>
        </div>
<%--        <div id="table-of-content">--%>
<%--            <span>Mục lục</span>--%>
<%--            <div id="toc"></div>--%>
<%--        </div>--%>
    </div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
<script src="<c:url value="/static/js/markdown-it.js"/>"></script>
<script>
    contentP = `<c:out value="${post.getContent()}" escapeXml="false"/>`;
</script>
<script src="<c:url value="/static/js/post_instance.js"/> "></script>
</body>
</html>
