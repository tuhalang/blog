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

function searchPost(self) {
    var xhr = new XMLHttpRequest();
    debugger
    xhr.onload = function () {
        debugger
        let data = JSON.parse(xhr.responseText);
        let listpost = document.getElementsByClassName("list-post");
        let subpost = document.getElementsByClassName("sub_post");
        let css = listpost[0].getElementsByTagName("link");
        let js = listpost[0].getElementsByTagName("script");
        let tempsubpost = subpost[0];
        let tempcss = css[0];
        let tempjs = js[0];

        for (let i = 0; i < subpost.length; i++) {
            subpost[i].remove();
            i -= 1;
        }

        for (let i = 0; i < css.length; i++) {
            css[i].remove();
            i -= 1;
        }

        for (let i = 0; i < js.length; i++) {
            js[i].remove();
            i -= 1;
        }
        for (let i = 0; i < data.length; i++) {
            let tmp = tempsubpost.cloneNode(true);
            tmp.setAttribute( "onclick", "return goToPost(" + data[i].id + ");")
            tmp.getElementsByClassName("title-des")[0].textContent = data[i].title
            tmp.getElementsByClassName("subcontent-des")[0].textContent = data[i].summary
            listpost[0].appendChild(tmp);
        }

        listpost[0].appendChild(tempcss);
        listpost[0].appendChild(tempjs);

    } // success case
    xhr.onerror = function () {
    } // failure case

    let fd = new FormData(self);
    fd.append("offset", 0);
    fd.append("limit", 6);

    xhr.open(self.method, self.action, true);
    xhr.send(fd);
    return false;
}

function searchCategory(self) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        var data = JSON.parse(xhr.responseText);
        var listcate = document.getElementsByClassName("list-categories");
        var subcateg = document.getElementsByClassName("sub_categ");
        var tempsubcateg = subcateg[0];

        for (let i = 0; i < subcateg.length; i++) {
            subcateg[i].remove();
            i -= 1;
        }

        for (let i = 0; i < data.length; i++) {
            var tmp = tempsubcateg.cloneNode(true);
            tmp.setAttribute( "onclick", "return goToCategory(" + data[i].id + ");");
            tmp.getElementsByTagName("label")[0].textContent = data[i].name;
            tmp.getElementsByClassName("amount-post")[0].textContent = '(' + data[i].numOfPosts + ')'
            listcate[0].appendChild(tmp);
        }

    } // success case
    xhr.onerror = function () {
    } // failure case

    var fd = new FormData(self);
    fd.append("offset", 0);
    fd.append("limit", 6);

    xhr.open(self.method, self.action, true);
    xhr.send(fd);
    return false;
}

