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

document.getElementById("edit").style.display = "block";