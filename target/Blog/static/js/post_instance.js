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