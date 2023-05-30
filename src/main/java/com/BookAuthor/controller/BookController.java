package com.BookAuthor.controller;

import com.BookAuthor.dto.BookDto;
import com.BookAuthor.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/author/{authorId}")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto, @PathVariable("authorId") long authorId){
        BookDto bookDto1=bookService.addBook(authorId,bookDto);
        ResponseEntity<BookDto> bookDtoResponseEntity = new ResponseEntity<>(bookDto1, HttpStatus.CREATED);
        return bookDtoResponseEntity;
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getOneBook(@PathVariable("bookId") long bookId){
       BookDto bookDto= bookService.getOneBook(bookId);
        ResponseEntity<BookDto> bookDtoResponseEntity = new ResponseEntity<>(bookDto, HttpStatus.OK);
        return bookDtoResponseEntity;
    }
    @GetMapping("/all")
    public  ResponseEntity<List<BookDto>> getAllBook(){
        List<BookDto> bookDtos=bookService.getAllBook();
        ResponseEntity<List<BookDto>> listResponseEntity = new ResponseEntity<>(bookDtos, HttpStatus.OK);
        return listResponseEntity;
    }
    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> updateOneBook(@PathVariable("bookId") long bookId,@RequestBody BookDto bookDto){
        BookDto bookDto1=bookService.UpdateOneBook(bookId,bookDto);
        ResponseEntity<BookDto> bookDtoResponseEntity = new ResponseEntity<>(bookDto1, HttpStatus.OK);
        return bookDtoResponseEntity;
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") long bookId){
        bookService.deleteOneBook(bookId);
        ResponseEntity<String> recordHasBeenDeleted = new ResponseEntity<>("Record has been deleted", HttpStatus.OK);
        return recordHasBeenDeleted;
    }


}
