document.getElementById("submitButton").addEventListener("click", function() {
    var text = document.getElementById("text")
    var text2 = document.getElementById("text2")
    
    text2.value = text.value;
})