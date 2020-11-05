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

function onLogin() {

}

function onRegister() {
    var repass = document.getElementById('input-rg-repass').value;
    var pass = document.getElementById('input-rg-pass').value;
    console.log(repass+pass)
    if (repass !== pass) {
        alert("Xác nhận mật khẩu không đúng!")
        return false;
    }
    return true;
}

document.getElementById("login-form").style.display = "block";