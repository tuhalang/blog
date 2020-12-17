function goToProfile() {
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/secure/profile";
    window.location.href = url
}

function goToSettings() {
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/secure/settings";
    window.location.href = url
}

function logout() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        location.replace(window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/home")
    } // success case
    xhr.onerror = function () {
    } // failure case
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/auth/signOut";
    xhr.open('GET', url, true);
    xhr.send();
}

var modal = document.getElementById("modal-login");

function showLogin() {
    modal.style.display = "block";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}