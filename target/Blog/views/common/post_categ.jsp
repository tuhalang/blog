<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 28/10/2020
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/static/css/common/post_categ.css"/>"/>
<div class="post-categ" onclick="return goToPost(25);">
    <img src="<c:url value="/static/img/avatar.jpg"/>"/>
    <div class="sub-info-post">
        <span class="title">Xây dựng ứng dụng realtime theo dõi nhiệt độ, độ ẩm, ánh sáng sử dụng Firebase Phần I</span>
        <div class="list-tags">
            <c:forEach var="i" begin="1" end="5">
                <span>Css</span>
            </c:forEach>
        </div>
        <span class="sub-content">WARNING: Toàn bộ những thứ dưới đây được thực hiện trong MỘT (01) ngày Đừng làm theo vì sẽ thấy hối hận NHƯNG NÊN ĐỌC Truyền thuyết kể rằng, v...</span>
        <div class="author-createAt"><span>tranvandiep010</span> 1 tháng trước</div>
    </div>
</div>
<script src="<c:url value="/static/js/common/post-categ.js"/>"></script>