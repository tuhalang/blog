//////////////////////////////////////////////////////////////modal
var modal = document.getElementById("modal-login");

// Get the button that opens the modal
var btn = document.getElementById("login");

// Get the <span> element that closes the modal
// var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}
//
// // When the user clicks on <span> (x), close the modal
// span.onclick = function() {
//     modal.style.display = "none";
// }

//click outside modal
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

/////////////////////////////////////////////////////////////////////////////

function onEdit(val){
    window.location.replace(val);
}