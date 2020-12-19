"use strict";

function changeTabAuth(evt, authAction) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(authAction).style.display = "block";
    evt.currentTarget.className += " active";
}

function login(self) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.responseText == '200') {
            document.getElementById('modal-login').style.display = "none"
            location.reload()
            return true;
        }
    } // success case
    xhr.onerror = function () {
        alert("Tài khoản hoặc mật khẩu sai");
    } // failure case
    xhr.open(self.method, self.action, true);
    xhr.send(new FormData(self));
    return false;
}

function register(self) {
    if (self.pwd.value != self.repwd.value) {
        alert("Xác nhận mật khẩu sai")
        return true;
    }
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.responseText == 200) {
            alert("Đăng kí thành công");
        } else {
            alert("đăng kí thất bại");
        }
    } // success case
    xhr.onerror = function () {
        alert("đăng kí thất bại");
    } // failure case
    xhr.open(self.method, self.action, true);
    xhr.send(new FormData(self));
    return false;
}

function logout() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        location.replace("/home")
    } // success case
    xhr.onerror = function () {} // failure case
    var url = "/auth/signOut";
    xhr.open('GET', url, true);
    xhr.send();
    return false;
}

document.getElementById("login-form").style.display = "block";