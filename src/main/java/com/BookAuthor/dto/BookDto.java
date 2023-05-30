package com.BookAuthor.dto;

import com.BookAuthor.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookDto {


    private long id;
    private String title;
    private String descrpition;

    private AuthorDto1 authorDto1;
}
