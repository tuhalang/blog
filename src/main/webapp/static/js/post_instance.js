var inp = contentP
var tmp = inp.split('\n')
var toc = []
var pattern = /^(# |## |### |#### |1. |2. |3. )/i
tmp.forEach((item, index) => {
    if (pattern.test(item)) {
        toc.push(item)
    }
})
var mdHtml = markdownit("commonmark")
document.getElementById("content-main").innerHTML = mdHtml.render(inp)
document.getElementById("toc").innerHTML = mdHtml.render(toc.join("\n"))

function interactPost(postId, type = 'like') {
    data = new FormData();
    data.append("postId", postId)
    data.append("type", type)
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        console.log(xhr.responseText)
    } // success case
    xhr.onerror = function () {
    } // failure case
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/secure/interact/like";
    xhr.open('POST', url, true);
    xhr.send(data);
}