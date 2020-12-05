function changeTab(evt, action) {
    if (action === "preview") onPreview();
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(action).style.display = "block";
    evt.currentTarget.className += " active";
}

var mdHtml = markdownit("commonmark")

async function onPreview() {
    document.getElementById("preview").innerHTML = mdHtml.render(document.getElementById("text-area").value)
}

function savePost(){
    var s = document.getElementById('text-area').value
    alert(s)
    var data = new FormData();
    data.append("content",s)
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        alert("Lưu thành công")
    } // success case
    xhr.onerror = function () {} // failure case
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/auth/signOut";
    xhr.open('POST', '/auth/signOut', true);
    xhr.send(data);
}

document.getElementById("edit").style.display = "block";