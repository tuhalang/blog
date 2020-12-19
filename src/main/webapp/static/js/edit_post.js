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
    if (content == '') {
        alert('Nội dung không được để trống')
        return
    }
    var title = document.getElementById('title-edit').value
    if (title == '') {
        alert('Tiêu đề không được để trống')
        return
    }
    var summary = document.getElementById('sub-content-edit').value
    if (summary == '') {
        alert('Mô tả ngắn gọn không được để trống không được để trống')
        return
    }
    var categoryId = document.getElementById('category').value
    var data = new FormData();
    data.append("content", content)
    data.append("title", title)
    data.append("summary", summary)
    data.append("categoryId", categoryId)
    var xhr = new XMLHttpRequest();
    xhr.overrideMimeType("charset=utf-8");
    xhr.onload = function () {
        if (xhr.responseText != 0 && xhr.responseText != -1) {
            alert("Lưu thành công")
            location.replace("/post?id="+xhr.responseText);
        } else if (xhr.responseText == 0) {
            alert("Bải viết không hợp lệ")
        } else if (xhr.responseText == -1) {
            alert("Lưu thất bại, lỗi hệ thống")
        }
    } // success case
    xhr.onerror = function () {
        alert("Lưu thất bại")
    } // failure case
    var url = "/secure/edit";
    xhr.open('POST', url, true);
    xhr.send(data);
}

document.getElementById("edit").style.display = "block";