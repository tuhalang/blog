<%--
  Created by IntelliJ IDEA.
  User: tao-thao
  Date: 22/10/2020
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="<c:url value='/static/css/common/sub_post.css'/>">
<div class="sub_post" onclick="return goToPost(${param.id});">
    <div class="thumnail-image">
        <div>
            <img src="<c:url value="/static/img/img2.34ae3742.jpg" />">
        </div>
    </div>
    <div class="post-description">
        <div class="title-des">${param.title}</div>
        <div class="subcontent-des">${param.summary}</div>
        <div class="create-at-des">Aug,2020 - 2 min read</div>
    </div>
</div>
<script src="<c:url value="/static/js/common/sub_post.js" />"></script>