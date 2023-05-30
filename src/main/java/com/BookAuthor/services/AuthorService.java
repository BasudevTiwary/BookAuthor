package com.BookAuthor.services;

import com.BookAuthor.dto.AuthorDto;
import com.BookAuthor.dto.AuthorDto1;

import java.util.List;

public interface AuthorService {
    AuthorDto1 addAuthor(AuthorDto authorDto);

    AuthorDto getOneAuthor(long authorId);

    List<AuthorDto> getAllAuthor();

    AuthorDto updateOneAuthor(long authorId, AuthorDto authorDto);

    void deleteOneAuthor(long authorId);
}
