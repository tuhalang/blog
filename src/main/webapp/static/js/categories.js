function searchCategory(self) {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        var data = JSON.parse(xhr.responseText);
        var listtags = document.getElementsByClassName("list-tags");
        var subtag = document.getElementsByClassName("tag-detail");
        var headtag = document.getElementsByClassName("head-tags");
        var css = listtags[0].getElementsByTagName("link");
        var js = listtags[0].getElementsByTagName("script");
        var tempsubpost = subtag[0];
        var tempcss = css[0];
        var tempjs = js[0];

        headtag[1].getElementsByTagName("div")[0].textContent = 'Danh mục(' + data.length + ')';

        for (let i = 0; i < subtag.length; i++) {
            subtag[i].remove();
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
            var tmp = tempsubpost.cloneNode(true);
            tmp.setAttribute("onclick", "return goToCategory(" + data[i].id + ");");
            tmp.getElementsByClassName("name-tags")[0].textContent = data[i].name;
            tmp.getElementsByTagName("span")[0].textContent = data[i].numOfPosts;
            tmp.getElementsByTagName("img")[0].src = data[i].image;
            listtags[0].appendChild(tmp);
        }

        listtags[0].appendChild(tempcss);
        listtags[0].appendChild(tempjs);

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