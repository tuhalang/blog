<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 26/10/2020
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/static/css/common/header.css"/>"/>
<div class="navbar">
    <div id="logo">
        <img src="<c:url value="/static/img/logo.png"/>" alt="Lazzy"/>
    </div>
    <div class="menu">
        <div><a href="<c:url value="/home"/>">Home</a></div>
        <div><a href="<c:url value="/categories"/>">Categories</a></div>
        <div class="dropdown">
            <a href="#"><i class="fas fa-user-circle"></i></a>
            <div class="dropdown-content">
                <div onclick="return goToProfile()"><i class="fas fa-user-alt"></i> Trang cá nhân</div>
                <div onclick="return goToSettings()"><i class="fas fa-cogs"></i> Cài đặt</div>
                <c:if test="${USERNAME==null}">
                    <div onclick="return showLogin();"><i class="fas fa-sign-in-alt"></i> Đăng nhập</div>
                </c:if>
                <c:if test="${USERNAME!=null}">
                    <div onclick="return logout();"><i class="fas fa-sign-out-alt"></i> Đăng xuất</div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../common/modal_auth.jsp"></jsp:include>
<script src="<c:url value="/static/js/common/header.js"/>"></script>