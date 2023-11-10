// "pushButton" 버튼을 클릭하면 "hiddenButton" 버튼을 표시합니다.
document.getElementById("pushButton").addEventListener("click", function() {
    var hiddenButton = document.getElementById("hiddenButton");
    hiddenButton.style.display = "block"; // 또는 "inline" 또는 "inline-block" 등을 사용하여 원하는 표시 방식을 선택할 수 있습니다.
  });
