package org.library.librarymanagement.service;

import org.library.librarymanagement.DTO.BookDTO;
import org.library.librarymanagement.DTO.BookSaveDTO;
import org.library.librarymanagement.DTO.BookUpdateDTO;
import org.library.librarymanagement.model.Book;

import java.util.List;

public interface BookService {

    String addBook(BookSaveDTO bookSaveDTO);

    List<BookDTO> getAllBook();

    String updateBook(BookUpdateDTO bookUpdateDTO);

    String deleteBook(Integer id);
}
