package com.BookAuthor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthorDto {


    private long id;
    private String authorName;
    private String email;
    private List<BookDto1> allbook;
}
