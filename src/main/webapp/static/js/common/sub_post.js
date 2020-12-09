function goToPost(id) {
    var data = "?id=" + id
    var xhr = new XMLHttpRequest();
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/post";
    window.location.href = url + data
}