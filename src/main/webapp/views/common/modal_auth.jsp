<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phoenix
  Date: 26/10/2020
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/static/css/common/auth.css"/>"/>
<div class="modal-container" id="modal-login">
    <div class="modal-content">
        <div class="introduce">
            <div>Đăng nhập</div>
            <p>Đăng nhập để đăng kí xem các bài viết mới và bình luận</p>
            <img src="<c:url value="/static/img/graphic-map.png"/>">
        </div>
        <div class="auth-container">
            <div class="tab">
                <div id="tab-space"></div>
                <button class="tablinks active" onclick="changeTabAuth(event, 'login-form')">Đăng nhập</button>
                <button class="tablinks" onclick="changeTabAuth(event, 'register-form')">Đăng kí</button>
                <div class="fill-space"></div>
            </div>

            <form id="login-form" class="tabcontent" method="POST" action="<c:url value="/auth/signIn"/>">
                <div class="input-auth data uname">
                    <div>Tên đăng nhập</div>
                    <input id="input-uname" placeholder="Nhập tên đăng nhập" name="uname"
                           pattern="^(?=.{6,32}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" required
                           title="Tên đăng nhập dài từ 6 đến 32 kí tự và không chứa kí tự đặc biệt"/>
                </div>
                <div class="input-auth data pass">
                    <div>Mật khẩu</div>
                    <input id="input-pass" placeholder="Mật khẩu từ 6 đến 32 kí tự" type="password" name="pwd"
                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,32}$" required
                           title="Phải chứa ít nhất một số và một chữ cái viết hoa và viết thường và có từ 6 đến 32 ký tự"/>
                </div>
                <div class="input-auth">
                    <div></div>
                    <button id="btn-login" type="submit">Đăng nhập</button>
                </div>
            </form>

            <form id="register-form" class="tabcontent" action="<c:url value="/auth/signUp"/>" method="post" >
                <div class="input-auth data uname">
                    <div>Tên đăng nhập</div>
                    <input id="input-rg-uname" placeholder="Nhập tên đăng nhập" name="uname"
                           pattern="^(?=.{6,32}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" required
                    title="Tên đăng nhập dài từ 6 đến 32 kí tự và không chứa kí tự đặc biệt"/>
                </div>
<%--                <div class="input-auth data uname">--%>
<%--                    <div>Email</div>--%>
<%--                    <input id="input-rg-email" placeholder="Nhập email" type="email" name="email" required/>--%>
<%--                </div>--%>
                <div class="input-auth data pass">
                    <div>Mật khẩu</div>
                    <input id="input-rg-pass" placeholder="Mật khẩu từ 6 đến 32 kí tự" type="password"
                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,32}$" required name="pwd"
                           title="Phải chứa ít nhất một số và một chữ cái viết hoa và viết thường và có từ 6 đến 32 ký tự"/>
                </div>
                <div class="input-auth data uname">
                    <div>Xác nhận mật khẩu</div>
                    <input id="input-rg-repass" placeholder="Nhập lại mật khẩu" type="password"
                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,32}$" required/>
                </div>
                <div class="input-auth">
                    <div></div>
                    <button id="btn-register" type="submit">Tạo tài khoản</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="<c:url value="/static/js/common/auth.js"/>"></script>