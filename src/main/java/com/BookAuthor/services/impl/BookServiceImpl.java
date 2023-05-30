package com.BookAuthor.services.impl;

import com.BookAuthor.dto.AuthorDto1;
import com.BookAuthor.dto.BookDto;
import com.BookAuthor.entities.Author;
import com.BookAuthor.entities.Book;
import com.BookAuthor.exception.RecordNotFoundException;
import com.BookAuthor.repository.AuthorRepository;
import com.BookAuthor.repository.BookRepository;
import com.BookAuthor.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public BookDto addBook(long authorId, BookDto bookDto) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RecordNotFoundException("Record not found"));
        Book book = mapToBook(bookDto);
        book.setAuthor(author);
        Book save = bookRepository.save(book);
        BookDto bookDto1 = mapToBookDto(save);
        AuthorDto1 authorDto1 = mapToAuthorDto1(author);
        bookDto1.setAuthorDto1(authorDto1);
        return bookDto1;
    }

    @Override
    public BookDto getOneBook(long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->new RecordNotFoundException("record not found"));
        BookDto bookDto = mapToBookDto(book);

        return bookDto;
    }

    @Override
    public List<BookDto> getAllBook() {
        List<Book> all = bookRepository.findAll();
        List<BookDto> collect = all.stream().map(m -> mapToBookDto(m)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public BookDto UpdateOneBook(long bookId, BookDto bookDto) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RecordNotFoundException("Record not found"));
        book.setTitle(bookDto.getTitle());
        book.setDescrpition(bookDto.getDescrpition());
        Book save = bookRepository.save(book);
        BookDto bookDto1 = mapToBookDto(save);
        return bookDto1;
    }

    @Override
    public void deleteOneBook(long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RecordNotFoundException("Record not found"));
        bookRepository.deleteById(bookId);
    }

    private AuthorDto1 mapToAuthorDto1(Author author) {
        AuthorDto1 authorDto1 = new AuthorDto1();
        authorDto1.setAuthorName(author.getAuthorName());
        authorDto1.setEmail(author.getAuthorName());
        authorDto1.setEmail(author.getEmail());
        authorDto1.setId(author.getId());
        return authorDto1;
    }

    private BookDto mapToBookDto(Book save) {
        BookDto bookDto = new BookDto();
        bookDto.setId(save.getId());
        bookDto.setTitle(save.getTitle());
        bookDto.setDescrpition(save.getDescrpition());
        Author author = save.getAuthor();
        AuthorDto1 authorDto1 = mapToAuthorDto1(author);
        bookDto.setAuthorDto1(authorDto1);
        return bookDto;
    }


    public Book mapToBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setDescrpition(bookDto.getDescrpition());
        return book;
    }


}
