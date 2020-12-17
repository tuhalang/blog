<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 29/10/2020
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/static/css/common/tag_detail.css"/>">
<div class="tag-detail" onclick="return goToCategory(${param.id})">
    <c:if test="${param.code != null}">
        <img src="<c:url value="${param.code}"/>"/>
    </c:if>
    <c:if test="${param.code == null}">
        <img src="https://resources.workable.com/wp-content/uploads/2016/01/category-manager-640x230.jpg"/>
    </c:if>
    <div>
        <div class="name-tags"><i class="fas fa-rss"></i> ${param.name}</div>
        <div class="amount-post"><span>${param.numOfPosts}</span> post</div>
        <div></div>
    </div>
</div>
<script src="<c:url value="/static/js/common/tag_detail.js"/>"></script>