package org.library.librarymanagement.service.impl;

import org.library.librarymanagement.DTO.*;
import org.library.librarymanagement.model.Book;
import org.library.librarymanagement.repository.AuthorRepository;
import org.library.librarymanagement.repository.BookRepository;
import org.library.librarymanagement.repository.PublisherRepository;
import org.library.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book(
                bookSaveDTO.getBookName(),
                authorRepository.getById(bookSaveDTO.getAuthorId()),
                publisherRepository.getById(bookSaveDTO.getPublisherId())
        );
        bookRepository.save(book);
        return "Book added successfully";
    }

    @Override
    public List<BookDTO> getAllBook() {
        List<Book> allBooks = bookRepository.findAll();
        List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
        for (Book book : allBooks) {
            BookDTO bookDTO = new BookDTO(
                    book.getBookId(),
                    book.getBookName(),
                    new AuthorDTO(book.getAuthor().getAuthorId(), book.getAuthor().getAuthorName()),
                    new PublisherDTO(book.getPublisher().getPublisherId(), book.getPublisher().getPublisherName())
            );
            bookDTOs.add(bookDTO);
        }
        return bookDTOs;
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {
        if(bookRepository.existsById(bookUpdateDTO.getBookId())) {
            Book book = bookRepository.getById(bookUpdateDTO.getBookId());
            book.setBookName(bookUpdateDTO.getBookName());
            book.setAuthor(authorRepository.getById(bookUpdateDTO.getAuthorId()));
            book.setPublisher(publisherRepository.getById(bookUpdateDTO.getPublisherId()));
            bookRepository.save(book);
            return "Book updated successfully";
        }
        return "Book not found";
    }

    @Override
    public String deleteBook(Integer id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Book deleted successfully";
        }
        return "Book not found";
    }
}
