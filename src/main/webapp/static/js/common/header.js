function goToProfile() {
    var url = "/secure/profile";
    window.location.href = url
}

function goToSettings() {
    var url = "/secure/settings";
    window.location.href = url
}

function logout() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        location.replace("/home")
    } // success case
    xhr.onerror = function () {
    } // failure case
    var url = "/auth/signOut";
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