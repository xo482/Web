package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MyController {
    @PostMapping("/saveText")
    public ResponseEntity<String> saveText(@RequestBody String text) {
        try {
            // 바탕화면 경로 설정
            String desktopPath = System.getProperty("user.home") + "/Desktop/";

            // 바탕화면에 파일 생성
            File file = new File(desktopPath + "savedText.txt");

            // 텍스트를 파일에 쓰기
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();

            return ResponseEntity.ok("텍스트가 바탕화면에 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("텍스트 저장 중 오류가 발생했습니다.");
        }
    }
}