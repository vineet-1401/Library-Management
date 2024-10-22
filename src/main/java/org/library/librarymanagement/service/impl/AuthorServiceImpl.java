package org.library.librarymanagement.service.impl;

import org.library.librarymanagement.DTO.AuthorDTO;
import org.library.librarymanagement.model.Author;
import org.library.librarymanagement.repository.AuthorRepository;
import org.library.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorDTO authorDTO) {
        Author author = new Author(
                authorDTO.getAuthorName()
        );
        authorRepository.save(author);
        return "Author Saved Successfully";
    }

    @Override
    public List<AuthorDTO> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDTO> authorDTOs = new ArrayList<AuthorDTO>();
        for (Author author : authors) {
            AuthorDTO authorDTO = new AuthorDTO(
                    author.getAuthorId(),
                    author.getAuthorName()
            );
            authorDTOs.add(authorDTO);
        }
        return authorDTOs;
    }

    @Override
    public String updateAuthor(AuthorDTO authorDTO) {
        if(authorRepository.existsById(authorDTO.getAuthorId())) {
            Author author = authorRepository.findById(authorDTO.getAuthorId()).get();
            author.setAuthorName(authorDTO.getAuthorName());
            authorRepository.save(author);
            return "Author Updated Successfully";
        }else{
            return "Author Not Found";
        }
    }

    @Override
    public String deleteAuthor(Integer id) {
        if(authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return "Author Deleted Successfully";
        }
        return "Author Not Found";
    }


}
