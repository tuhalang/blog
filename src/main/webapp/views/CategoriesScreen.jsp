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
    <title>Categories</title>
    <link rel="stylesheet" href="<c:url value="/static/css/categories.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <jsp:include page="common/header.jsp"></jsp:include>
    <div class="head-tags">
        <div style="font-size: 18px;font-weight: 550;">
            <c:if test="${categoryName != null}">
            <p style="font-style: italic;"> Kết quả tìm kiếm cho: <b>${categoryName}</b>
            <p>
                </c:if>
        </div>
    </div>
    <div class="head-tags">
        <div style="font-size: 18px;font-weight: 550;">Danh Mục(${categoryList.size()})</div>
        <div class="space-fill"></div>
        <form action="<c:url value="/categories"/>" method="post" onsubmit="return searchCategory(this)">
            <div class="search-categ">
                <input name="categoryName" value="${categoryName}"/>
                <button type="submit" style="display: none">
                    search
                </button>
            </div>
        </form>
    </div>
    <div class="list-tags" style="min-height: 75vh;">
        <c:forEach items="${categoryList}" var="category">
            <jsp:include page="common/tag_detail.jsp">
                <jsp:param name="name" value="${category.getName()}"/>
                <jsp:param name="code" value="${category.getCode()}"/>
                <jsp:param name="image" value="${category.getImage()}"/>
                <jsp:param name="numOfPosts" value="${category.getNumOfPosts()}"/>
                <jsp:param name="id" value="${category.getId()}"/>
            </jsp:include>
        </c:forEach>
    </div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>
<script src="<c:url value="/static/js/categories.js"/>"></script>
</body>
</html>
