<%--
  Created by IntelliJ IDEA.
  User: tao-thao
  Date: 23/10/2020
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="<c:url value="/static/css/edit_post.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div id="edit-content">
    <input class="title-edit" id="title-edit" placeholder="Tiêu đề hay gây ấn tượng cho người đọc"/>
    <input class="sub-content-edit" id="sub-content-edit" minlength="50"
           placeholder="Mô tả hợp lý giúp người đọc hiểu về bài viết dễ hơn (nhiều hơn 50 từ)"/>
    <div id="body-edit">
        <div class="tab">
            <div>
                <div id="tab-space"></div>
                <button class="tablinks active" onclick="changeTab(event, 'edit')">Edit</button>
                <button class="tablinks" onclick="changeTab(event, 'preview')">Preview</button>
            </div>
            <div class="action">
                <div class="edit-action">
                    <div>Chủ đề</div>
                    <select name="category" class="dropdown-categ" id="category">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.getId()}" class="dropdown-content-categ">${category.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div id="edit" class="tabcontent">
            <textarea id="text-area" ></textarea>
        </div>
        <div id="preview" class="tabcontent">
        </div>
    </div>
    <div id="save-post">
        <input type="submit" value="Đăng bài" class="save-post-btn" onclick="return savePost();">
    </div>
</div>

</div>
<jsp:include page="common/footer.jsp"></jsp:include>
<script src="<c:url value="/static/js/markdown-it.js"/>"></script>
<script src="<c:url value="/static/js/edit_post.js" />"></script>
</body>
</html>
