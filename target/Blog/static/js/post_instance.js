console.log(content)
var inp = content
var mdHtml = markdownit("commonmark")
document.getElementById("content-main").innerHTML = mdHtml.render(inp)