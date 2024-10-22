package org.library.librarymanagement.controller;


import jdk.jfr.Frequency;
import org.library.librarymanagement.DTO.BookDTO;
import org.library.librarymanagement.DTO.BookSaveDTO;
import org.library.librarymanagement.DTO.BookUpdateDTO;
import org.library.librarymanagement.model.Book;
import org.library.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add-book")
    public String saveBook(@RequestBody BookSaveDTO bookSaveDTO){
        return bookService.addBook(bookSaveDTO);
    }

    @GetMapping("/get-all-book")
    public List<BookDTO> getAllBook(){
        List<BookDTO> bookDTOList = bookService.getAllBook();
        return bookDTOList;
    }

    @PutMapping("/update-book")
    public String updateBook(@RequestBody BookUpdateDTO bookUpdateDTO){
        return bookService.updateBook(bookUpdateDTO);
    }
    @DeleteMapping("/delete-book/{id}")
    public String updateAuthor(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }
}
