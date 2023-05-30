package com.BookAuthor.controller;

import com.BookAuthor.dto.AuthorDto;
import com.BookAuthor.dto.AuthorDto1;
import com.BookAuthor.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorDto1> addAuthor(@RequestBody AuthorDto authorDto){
        AuthorDto1 authorDto1=authorService.addAuthor(authorDto);
        ResponseEntity<AuthorDto1> authorDto1ResponseEntity = new ResponseEntity<>(authorDto1, HttpStatus.CREATED);
        return authorDto1ResponseEntity;
    }
    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorDto> getOneBook(@PathVariable("authorId") long authorId){
       AuthorDto authorDto= authorService.getOneAuthor(authorId);
        ResponseEntity<AuthorDto> authorDtoResponseEntity = new ResponseEntity<>(authorDto, HttpStatus.OK);
        return authorDtoResponseEntity;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDto>> getAllAuthor(){
        List<AuthorDto> authorDtoList=authorService.getAllAuthor();
        ResponseEntity<List<AuthorDto>> listResponseEntity = new ResponseEntity<>(authorDtoList, HttpStatus.OK);
        return listResponseEntity;
    }

    @PutMapping("/update/{authorId}")
    public ResponseEntity<AuthorDto> updateOneAuthor(@PathVariable("authorId") long authorId,@RequestBody AuthorDto authorDto){
        AuthorDto authorDto1=authorService.updateOneAuthor(authorId,authorDto);
        ResponseEntity<AuthorDto> authorDtoResponseEntity = new ResponseEntity<>(authorDto1, HttpStatus.OK);
        return authorDtoResponseEntity;
    }
    @DeleteMapping("/delete/{authorId}")
    public ResponseEntity<String> deleteOneAuthor(@PathVariable("authorId") long authorId){
        authorService.deleteOneAuthor(authorId);
        ResponseEntity<String> recordHasBeenDeleted = new ResponseEntity<>("record has been deleted", HttpStatus.OK);
        return recordHasBeenDeleted;
    }
}
