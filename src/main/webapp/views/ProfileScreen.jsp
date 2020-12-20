<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 10/12/2020
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Trang cá nhân</title>
    <link rel="stylesheet" href="<c:url value="/static/css/profile.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/fontawesome-free-5.15.1-web/css/all.css"/>"/>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Roboto:ital@1&display=swap"
          rel="stylesheet">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
<div class="container">
    <div class="profile">
        <div class="tab-profile">
            <div class="tab-profile-links active" onclick="changeTab(event, 'account')">Tài khoản</div>
            <div class="tab-profile-links" onclick="changeTab(event, 'pwd')">Mật khẩu</div>
        </div>

        <div id="account" class="tab-profile-content">
            <span>Ảnh đại diện</span>
            <div class="avatar" onclick="return openSelectAvatar()">
                <div class="avatar-1">
                    <i class="fas fa-link"></i>
                </div>
                <c:if test="${user.getAvatar()!=null}">
                    <img id="avatar" src="${user.getAvatar()}"/>
                </c:if>
                <c:if test="${user.getAvatar()==null}">
                    <img gitgit src="https://png.pngtree.com/png-clipart/20190906/original/pngtree-couple-avatar-girl-avatar-cartoon-simple-school-uniform-student-png-image_4558110.jpg"/>
                </c:if>
            </div>
            <div id="lable-uname">Tên đăng nhập</div>
            <div id="input-uname">
                <i class="fas fa-user-alt"></i>
                <input id="input-change-uname" placeholder="${user.getUsername()}"
                       pattern="^(?=.{6,32}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" required
                       title="Tên đăng nhập dài từ 6 đến 32 kí tự và không chứa kí tự đặc biệt"/>
            </div>
            <div id="amount-post">Số lượng bài viết: <span>${fn:length(posts)}</span></div>
            <div id="btn-save" onclick="return onUpdateInfo();"><i class="fas fa-save"></i> Lưu</div>
        </div>

        <div id="pwd" class="tab-profile-content">
            <form action="<c:url value="/secure/profile"/>" method="post" onsubmit="return updatePassword(this)">
                <div class="input-change-pwd">
                    <i class="fas fa-lock"></i>
                    <input placeholder="Nhập mật khẩu cũ" type="password"
                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,32}$" required name="oldPassword"
                           title="Phải chứa ít nhất một số và một chữ cái viết hoa và viết thường và có từ 6 đến 32 ký tự"/>
                </div>
                <div class="input-change-pwd">
                    <i class="fas fa-lock"></i>
                    <input placeholder="Nhập mật khẩu mới" type="password"
                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,32}$" required name="newPassword"
                           title="Phải chứa ít nhất một số và một chữ cái viết hoa và viết thường và có từ 6 đến 32 ký tự"/>
                </div>
                <div class="input-change-pwd">
                    <i class="fas fa-lock"></i>
                    <input placeholder="nhập lại mật khẩu mới" type="password"
                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,32}$" required name="renewPassword"
                           title="Phải chứa ít nhất một số và một chữ cái viết hoa và viết thường và có từ 6 đến 32 ký tự"/>
                </div>
                <button type="submit" class="btn-save"><i class="fas fa-save"></i> Lưu</button>
            </form>
        </div>

    </div>
    <div id="divider">
        <div class="divider-1"></div>
        <div class="divider-2"><i class="fas fa-chevron-down"></i></div>
        <div class="divider-1"></div>
    </div>
    <div class="list-posts">
        <c:forEach items="${posts}" var="post">
            <jsp:include page="common/post_categ.jsp">
                <jsp:param name="title" value="${post.getTitle()}"/>
                <jsp:param name="summary" value="${post.getSummary()}"/>
                <jsp:param name="id" value="${post.getId()}"/>
            </jsp:include>
        </c:forEach>
    </div>
</div>
<div id="modal-avatar" class="modal-avatar">
    <!-- Modal content -->
    <div class="modal-content-avatar">
        <h2>Nhập đường dẫn ảnh bạn muốn đặt làm ảnh đại diện</h2>
        <div class="avatar-change">
            <input type="text" placeholder="https://" id="input-modal-avatar" oninput="return changeInpAvatar();"/>
            <div id="save-avatar" onclick="return changeAvatar();">Lưu</div>
        </div>
    </div>

</div>
<jsp:include page="common/footer.jsp"></jsp:include>
<script src="<c:url value="/static/js/profile.js"/>"></script>
</body>
</html>
