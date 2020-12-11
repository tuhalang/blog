//////////////////////////////////////////////////////////////modal
var modal = document.getElementById("modal-login");

function showLogin() {
    modal.style.display = "block";
}
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

/////////////////////////////////////////////////////////////////////////////

function onEdit(val){
    window.location.replace(val);
}

function goToCategory(id){
    var data = "?id=" + id
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/category";
    window.location.href = url + data
}

function goToProfile() {
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/secure/profile";
    window.location.href = url
}

function goToSettings() {
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/secure/settings";
    window.location.href = url
}