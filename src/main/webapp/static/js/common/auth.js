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


function onRegister() {
    var repass = document.getElementById('input-rg-repass').value;
    var pass = document.getElementById('input-rg-pass').value;
    console.log(repass + pass)
    if (repass !== pass) {
        alert("Xác nhận mật khẩu không đúng!")
        return false;
    }
    return true;
}

function login(self) {
    var http = new XMLHttpRequest();
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/auth/signIn";
    var data = new FormData();
    data.append("pwd",self.pwd.value)
    data.append("uname",self.uname.value)
    http.open('POST', url, true);

//Send the proper header information along with the request
    http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    http.onreadystatechange = function() {//Call a function when the state changes.
        if(http.status == 200) {
            if (http.responseText == "200") {
                location.reload()
            }else alert("Tai khoan hoac mat khau sai!")
        }
    }
    http.send(data);
    return true;
}

function register(self) {
    if (self.pwd.value != self.repwd.value){
        alert("Xác nhận mật khẩu sai")
        return true;
    }
    var http = new XMLHttpRequest();
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/auth/signUp";
    var params = `pwd=${self.pwd.value}&uname=${self.uname.value}`
    http.open('POST', url, true);

//Send the proper header information along with the request
    http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    http.onreadystatechange = function() {//Call a function when the state changes.
        if(http.readyState == 4 && http.status == 200) {
            alert(http.responseText);
        }
    }
    http.send(params);
    return false;
}

document.getElementById("login-form").style.display = "block";