package com.example.springboot10bai.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class ExerciseController {

    // =========================
    // BÀI 1: Path + Query
    // GET /orders/{orderId}?currency=VND
    // =========================
    @GetMapping("/orders/{orderId}")
    public Map<String, Object> bai1(
            @PathVariable int orderId,
            @RequestParam String currency) {

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("orderId", orderId);
        result.put("currency", currency);
        return result;
    }

    // =========================
    // BÀI 2: POST + Query + Body
    // POST /comments?postId=5
    // Body: {"content":"Bài viết hay quá!"}
    // =========================
    @PostMapping("/comments")
    public Map<String, Object> bai2(
            @RequestParam int postId,
            @RequestBody Map<String, String> body) {

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("postId", postId);
        result.put("content", body.get("content"));
        return result;
    }

    // =========================
    // BÀI 3: Header + Path
    // GET /users/{id}
    // Header: X-Client-Version: 1.2.0
    // =========================
    @GetMapping("/users/{id}")
    public Map<String, Object> bai3(
            @PathVariable int id,
            @RequestHeader("X-Client-Version") String clientVersion) {

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("id", id);
        result.put("clientVersion", clientVersion);
        return result;
    }

    // =========================
    // BÀI 4: Query Param có default
    // GET /search?keyword=spring
    // page mặc định 0, size mặc định 10
    // =========================
    @GetMapping("/search")
    public Map<String, Object> bai4(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("keyword", keyword);
        result.put("page", page);
        result.put("size", size);
        return result;
    }

    // =========================
    // BÀI 5: Nhận danh sách Query
    // GET /tags?tags=java,spring,boot
    // =========================
    @GetMapping("/tags")
    public List<String> bai5(@RequestParam List<String> tags) {
        return tags;
    }

    // =========================
    // BÀI 6: Query Map động
    // GET /filters?color=red&size=M&brand=Nike
    // =========================
    @GetMapping("/filters")
    public Map<String, String> bai6(
            @RequestParam Map<String, String> filters) {

        return filters;
    }

    // =========================
    // BÀI 7: Form URL Encoded
    // POST /login-form
    // Content-Type: application/x-www-form-urlencoded
    // username=admin&password=123
    // =========================
    @PostMapping(
            value = "/login-form",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Map<String, String> bai7(
            @RequestParam String username,
            @RequestParam String password) {

        Map<String, String> result = new LinkedHashMap<>();
        result.put("username", username);
        result.put("password", password);
        return result;
    }

    // =========================
    // BÀI 8: Multipart + nhiều tham số
    // POST /documents
    // file + title + description + tags
    // =========================
    @PostMapping(
            value = "/documents",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, Object> bai8(
            @RequestPart("file") MultipartFile file,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam List<String> tags) {

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize());
        result.put("title", title);
        result.put("description", description);
        result.put("tags", tags);
        return result;
    }

    // =========================
    // BÀI 9: PUT cập nhật từng phần
    // PUT /users/{id}
    // Body: {"email":"new@email.com"}
    // =========================
    @PutMapping("/users/{id}")
    public Map<String, Object> bai9(
            @PathVariable int id,
            @RequestBody Map<String, String> body) {

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("id", id);
        result.put("email", body.get("email"));
        return result;
    }

    // =========================
    // BÀI 10: DELETE + Header xác thực
    // DELETE /posts/{id}
    // Header: Authorization: Bearer xxx
    // =========================
    @DeleteMapping("/posts/{id}")
    public Map<String, Object> bai10(
            @PathVariable int id,
            @RequestHeader("Authorization") String authorization) {

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("postId", id);
        result.put("authorization", authorization);
        result.put("message", "Xóa bài viết thành công");
        return result;
    }
}
