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
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-PX5CNE1YB5"></script>
<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'G-PX5CNE1YB5');
</script>
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
                <div><i class="fas fa-user-alt"></i> Trang cá nhân</div>
                <div><i class="fas fa-cogs"></i> Cài đặt</div>
                <div><i class="fas fa-sign-out-alt"></i> Đăng xuất</div>
            </div>
        </div>
    </div>
</div>
