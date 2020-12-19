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

function interactPost(postId, type = '1',userId) {
    if (document.getElementById("action-like").style.color == "red") return;
    if (userId == null) return;
    let data = new FormData();
    data.append("postId", postId)
    data.append("type", type)
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        console.log(xhr.responseText)
        document.getElementById("amount-like").innerText = xhr.responseText + " like"
        document.getElementById("action-like").style.color = "red"
    } // success case
    xhr.onerror = function () {
    } // failure case
    let url = "/secure/interact/like";
    xhr.open('POST', url, true);
    xhr.send(data);
}

function checkInteract(postId, type = "1") {
    let data = "?postId=" + postId + "&type=" + type + "&action=check";
    let xhr = new XMLHttpRequest();
    xhr.onload = function () {
        console.log(xhr.responseText)
        if (xhr.responseText == true)
            document.getElementById("action-like").style.color = "red"
    } // success case
    xhr.onerror = function () {
    } // failure case
    let url = "/secure/interact/like";
    xhr.open('GET', url + data, true);
    xhr.send();
}

function getAmountInteract(postId, type = "1") {
    let data = "?postId=" + postId + "&type=" + type + "&action=count";
    debugger
    let xhr = new XMLHttpRequest();
    xhr.onload = function () {
        debugger
        console.log(xhr.responseText)
        document.getElementById("amount-like").innerText = xhr.responseText + " like"
    } // success case
    xhr.onerror = function () {
    } // failure case
    let url = "/secure/interact/like";
    xhr.open('GET', url + data, true);
    xhr.send();
}