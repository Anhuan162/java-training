package com.huan.library.service;

import com.huan.library.dto.request.AuthorRequest;
import com.huan.library.dto.response.AuthorResponse;
import com.huan.library.entity.Author;
import com.huan.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorResponse createAuthor(AuthorRequest request) {
        Author author = new Author();
        author.setName(request.getName());
        return mapToResponse(authorRepository.save(author));
    }

    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public AuthorResponse getAuthorById(int id) {
        return authorRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    private AuthorResponse mapToResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getAuthorId())
                .name(author.getName())
                .build();
    }
}
