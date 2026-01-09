# Authentication & Authorization Annotations in Spring Boot


---

## I. Authentication Annotations

### 1. `@AuthenticationPrincipal`

* **Purpose**: Retrieve the currently authenticated user from the security context. (lấy thông tin người dùng đã đăng nhập từ security context. )
* **Usage**: Commonly used in controllers. (trong controller để truy cập user hiện tại.)
* **Example**:

```java
@GetMapping("/profile")
public ResponseEntity<?> getProfile(@AuthenticationPrincipal UserDetails user) {
    return ResponseEntity.ok(user.getUsername());
}
```

---

## II. Authorization Annotations

### 2. `@PreAuthorize("...")`

* **Purpose**: Perform authorization checks **before** the method is executed. (kiểm tra quyền truy cập trước khi thực hiện method.)
* **Usage**: Used on controller or service methods, supports SpEL. (Khai báo trong Controller / Service)
* **Example**:

```java
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/admin")
public String adminPage() {
    return "Welcome admin!";
}
```

> Requires `@EnableMethodSecurity(prePostEnabled = true)` (Spring Boot 3+) or `@EnableGlobalMethodSecurity(prePostEnabled = true)` (Spring Security < 6).

### 3. `@PostAuthorize("...")`

* **Purpose**: Perform authorization **after** the method is executed.  (kiểm tra quyền sau khi method thực thi)
* **Usage**: Often used when filtering based on the returned object. - thường dùng khi lọc dựa trên kết quả trả về.
* **Example**:

```java
@PostAuthorize("returnObject.username == authentication.name")
public User getUser(Long id) {
    return userService.findById(id);
}
```

### 4. `@Secured("ROLE_...")`

* **Purpose**: Restrict method access to specific roles.  kiểm soát method cho 1 hoặc nhiều role cụ thể.
* **Usage**: Controller or service methods.
* **Example**:

```java
@Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
@GetMapping("/dashboard")
public String dashboard() {
    return "dashboard";
}
```

> Requires `@EnableGlobalMethodSecurity(securedEnabled = true)`


## III. Security Configuration Annotations

### 5. `@EnableWebSecurity`

* **Purpose**: Enables Spring Security in the application. - Kích hoạt Spring Security trong ứng dụng. 
* **Usage**:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  // HttpSecurity configuration
}
```

### 6. `@EnableMethodSecurity`

* **Purpose**: Replaces `@EnableGlobalMethodSecurity` in Spring Boot 3+, enables method-level annotations like `@PreAuthorize`. - Thay thế @EnableGlobalMethodSecurity, bật các annotation như @PreAuthorize, @RolesAllowed.
* **Usage**:

```java
@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig {
}
```

---


