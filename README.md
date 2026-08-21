# Spring Boot - 10 bài tập

Project này dùng Spring Boot 2.7.18 + Java 8, phù hợp nếu máy đang dùng JDK 8.

## Chạy project

Trong NetBeans:
1. File -> Open Project
2. Chọn thư mục `springboot-10-bai`
3. Clean and Build
4. Run file `Springboot10BaiApplication.java`

Server:
http://localhost:8080

## Test 10 bài

### Bài 1
GET http://localhost:8080/orders/101?currency=VND

Kết quả:
{
  "orderId": 101,
  "currency": "VND"
}

### Bài 2
POST http://localhost:8080/comments?postId=5
Content-Type: application/json

Body:
{
  "content": "Bài viết hay quá!"
}

### Bài 3
GET http://localhost:8080/users/10

Header:
X-Client-Version: 1.2.0

### Bài 4
GET http://localhost:8080/search?keyword=spring

Không truyền page/size thì:
page = 0
size = 10

Có thể test:
GET http://localhost:8080/search?keyword=spring&page=2&size=20

### Bài 5
GET http://localhost:8080/tags?tags=java,spring,boot

### Bài 6
GET http://localhost:8080/filters?color=red&size=M&brand=Nike

### Bài 7
POST http://localhost:8080/login-form

Body dạng x-www-form-urlencoded:
username=admin
password=123

### Bài 8
POST http://localhost:8080/documents

Body dạng form-data:
file = chọn file
title = Tai lieu Spring
description = Mo ta tai lieu
tags = java
tags = spring
tags = boot

### Bài 9
PUT http://localhost:8080/users/10
Content-Type: application/json

Body:
{
  "email": "new@email.com"
}

### Bài 10
DELETE http://localhost:8080/posts/5

Header:
Authorization: Bearer xxx
