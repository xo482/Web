document.getElementById("helloButton").addEventListener("click", function() {
      fetch("/hello") // 서버의 /hello 엔드포인트로 GET 요청 보내기
          .then(response => response.text())
          .then(data => {
             document.getElementById("response").textContent = data; // 응답 출력
          })
          .catch(error => {
             console.error("Error:", error);
          });
      });

document.getElementById("textButton").addEventListener("click", function() {
      // 외부 index.html 파일을 새 창에서 열기
      window.open("/external/textSubmit/index.html", "_blank");
});