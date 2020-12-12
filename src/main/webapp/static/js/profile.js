function changeTab(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tab-profile-content");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tab-profile-links");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

document.getElementById('account').style.display = "block";

//modal avatar
// Get the modal
var modal = document.getElementById("modal-avatar");

function openSelectAvatar() {
    modal.style.display = "block";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
/////////////////////////////////////////////////
function updateUsername(self) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.responseText == 200) {
            alert("Đổi tên tài khoản thành công");
        } else {
            alert("Đổi tên tài khoản thất bại");
        }
    } // success case
    xhr.onerror = function () {
        alert("Đổi tên tài khoản thất bại");
    } // failure case

    var fd = new FormData(self);
    fd.append("type", "username");

    xhr.open(self.method, self.action, true);
    xhr.send(fd);
    return false;
}

function updatePassword(self) {
    if (self.newPassword.value != self.renewPassword.value) {
        alert("Xác nhận mật khẩu sai")
        return true;
    }
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.responseText == 200) {
            alert("Đổi mật khẩu thành công");
        } else if (xhr.responseText == 400) {
            alert("Mật khẩu cũ không chính xác");
        } else {
            alert("Đổi mật khẩu thất bại");
        }
    } // success case
    xhr.onerror = function () {
        alert("Đổi mật khẩu thất bại");
    } // failure case

    var fd = new FormData(self);
    fd.append("type", "password");

    xhr.open(self.method, self.action, true);
    xhr.send(fd);
    return false;
}