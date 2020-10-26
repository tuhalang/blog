<%--
  Created by IntelliJ IDEA.
  User: tao-thao
  Date: 23/10/2020
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value="/static/css/edit_post.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<div class="navbar">
    <div id="logo">
        <img src="<c:url value="/static/img/fbfe575.svg"/>" alt="Lazzy"/>
    </div>
    <div class="menu">
        <div><a href="home">Home</a></div>
        <div><a href="#">Categories</a></div>
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
<div id="edit-content">
    <input class="title-edit" placeholder="Tiêu đề hay gây ấn tượng cho người đọc"/>
    <input class="tag-edit" placeholder="Tag hợp lý giúp người đọc dễ tìm thấy hơn"/>
    <div id="body-edit">
        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'edit')">London</button>
            <button class="tablinks" onclick="openCity(event, 'preview')">Paris</button>
        </div>
        <div id="edit" class="tabcontent">
            <textarea id="text-area"></textarea>
        </div>

        <div id="preview" class="tabcontent">
        </div>
    </div>
</div>

</div>
<jsp:include page="common/footer.jsp"></jsp:include>
<script src="<c:url value="/static/js/edit_post.js" />"></script>
<script src="<c:url value="/static/js/markdown-it.js"/>"></script>
<script>
    var mdHtml = markdownit("commonmark")
    document.getElementById("preview").innerHTML = mdHtml.render("**abc**")
</script>
</body>
</html>
