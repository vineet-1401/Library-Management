package org.library.librarymanagement.service;

import org.library.librarymanagement.DTO.AuthorDTO;

import java.util.List;

public interface AuthorService {

    String addAuthor(AuthorDTO authorDTO);

    List<AuthorDTO> getAllAuthor();

    String updateAuthor(AuthorDTO authorDTO);

    String deleteAuthor(Integer id);
}
