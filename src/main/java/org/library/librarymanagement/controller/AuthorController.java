package org.library.librarymanagement.controller;


import org.library.librarymanagement.DTO.AuthorDTO;
import org.library.librarymanagement.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @PostMapping("/add-author")
    public String saveAuthor(@RequestBody AuthorDTO authorDTO){
        return authorService.addAuthor(authorDTO);
    }

    @GetMapping("/get-all-author")
    public List<AuthorDTO> getAllAuthor(){
        List<AuthorDTO> authorDTOList = authorService.getAllAuthor();
        return authorDTOList;
    }

    @PutMapping("/update-author")
    public String updateAuthor(@RequestBody AuthorDTO authorDTO){
        String authorUpdate = authorService.updateAuthor(authorDTO);
        return authorUpdate;
    }
    @DeleteMapping("/delete-author/{id}")
    public String updateAuthor(@PathVariable Integer id){
        String authorDelete = authorService.deleteAuthor(id);
        return authorDelete;
    }
}
