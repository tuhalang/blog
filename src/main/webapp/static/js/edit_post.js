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

function savePost() {
    var content = document.getElementById('text-area').value
    var title = document.getElementById('title-edit').value
    var summary = document.getElementById('sub-content-edit').value
    var categoryId = document.getElementById('category').value
    var data = new FormData();
    data.append("content", content)
    data.append("title", title)
    data.append("summary", summary)
    data.append("categoryId", categoryId)
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.responseText == 200) {
            alert("Lưu thành công")
        } else if (xhr.responseText == 500) {
            alert("Bải viết không hợp lệ")
        } else if (xhr.responseText == 404) {
            alert("Lưu thất bại, lỗi hệ thống")
        }
    } // success case
    xhr.onerror = function () {
        alert("Lưu thất bại")
    } // failure case
    var url = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/secure/edit";
    xhr.open('POST', url, true);
    xhr.send(data);
}

document.getElementById("edit").style.display = "block";