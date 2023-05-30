package com.BookAuthor.services.impl;

import com.BookAuthor.dto.AuthorDto;
import com.BookAuthor.dto.AuthorDto1;
import com.BookAuthor.dto.BookDto1;
import com.BookAuthor.entities.Author;
import com.BookAuthor.entities.Book;
import com.BookAuthor.exception.RecordNotFoundException;
import com.BookAuthor.repository.AuthorRepository;
import com.BookAuthor.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public AuthorDto1 addAuthor(AuthorDto authorDto) {
        Author author = mapToAuthor(authorDto);
        Author save = authorRepository.save(author);
        AuthorDto1 authorDto1 = mapToAuthor1(save);
        return authorDto1;
    }

    @Override
    public AuthorDto getOneAuthor(long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(()->new RecordNotFoundException("Record Not found"));
        AuthorDto authorDto = mapToAuthorDto(author);
        return authorDto;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {

        List<Author> all = authorRepository.findAll();
        List<AuthorDto> collect = all.stream().map(m -> mapToAuthorDto(m)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public AuthorDto updateOneAuthor(long authorId, AuthorDto authorDto) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RecordNotFoundException("record not found"));
        author.setAuthorName(authorDto.getAuthorName());
        author.setEmail(authorDto.getEmail());
        Author save = authorRepository.save(author);
        AuthorDto authorDto1 = mapToAuthorDto(save);
        return authorDto1;
    }

    @Override
    public void deleteOneAuthor(long authorId) {

        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RecordNotFoundException("Record not found"));
        authorRepository.deleteById(authorId);

    }
    private AuthorDto mapToAuthorDto(Author author) {
        AuthorDto author1 = new AuthorDto();
        author1.setId(author.getId());
        author1.setAuthorName(author.getAuthorName());
        author1.setEmail(author.getEmail());
        List<Book> allbook = author.getAllbook();
        List<BookDto1> collect = allbook.stream().map(m -> mapToBookDto1(m)).collect(Collectors.toList());
        author1.setAllbook(collect);
        return author1;
    }
    public BookDto1 mapToBookDto1(Book book){
        BookDto1 bookDto1 = new BookDto1();
        bookDto1.setId(book.getId());
        bookDto1.setTitle(book.getTitle());
        bookDto1.setDescrpition(book.getDescrpition());
        return bookDto1;
    }

    private AuthorDto1 mapToAuthor1(Author save) {
        AuthorDto1 authorDto1 = new AuthorDto1();
        authorDto1.setAuthorName(save.getAuthorName());
        authorDto1.setEmail(save.getEmail());
        authorDto1.setId(save.getId());
        return authorDto1;
    }

    private Author mapToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setAuthorName(authorDto.getAuthorName());
        author.setEmail(authorDto.getEmail());
       return author;
    }


}
