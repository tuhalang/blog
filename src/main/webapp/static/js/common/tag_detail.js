function goToCategory(id){
    var data = "?id=" + id
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/category";
    window.location.href = url + data
}