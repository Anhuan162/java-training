package com.huan.library.controller;

import com.huan.library.dto.request.AuthorRequest;
import com.huan.library.dto.response.AuthorResponse;
import com.huan.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest request) {
        return ResponseEntity.ok(authorService.createAuthor(request));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable int id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
}
