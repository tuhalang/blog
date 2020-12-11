<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 28/10/2020
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="<c:url value="/static/css/common/post_categ.css"/>"/>
<div class="post-categ" onclick="return goToPost(${param.id});">
    <img src="<c:url value="/static/img/avatar.jpg"/>"/>
    <div class="sub-info-post">
        <span class="title">${param.title}</span>
        <div class="list-tags">
<%--            <c:forEach var="i" begin="1" end="5">--%>
<%--                <span>Css</span>--%>
<%--            </c:forEach>--%>
        </div>
        <span class="sub-content">${param.summary}</span>
        <div class="author-createAt"><span>${param.userName}<</span> 1 tháng trước</div>
    </div>
</div>
<script src="<c:url value="/static/js/common/post-categ.js"/>"></script>