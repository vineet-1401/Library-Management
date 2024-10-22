package org.library.librarymanagement.controller;

import org.library.librarymanagement.DTO.AuthorDTO;
import org.library.librarymanagement.DTO.PublisherDTO;
import org.library.librarymanagement.service.impl.AuthorServiceImpl;
import org.library.librarymanagement.service.impl.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    private PublisherServiceImpl publisherService;

    @PostMapping("/add-publisher")
    public String savePublisher(@RequestBody PublisherDTO publisherDTO){
        return publisherService.addPublisher(publisherDTO);
    }

    @GetMapping("/get-all-publisher")
    public List<PublisherDTO> getAllPublisher(){
        List<PublisherDTO> publisherDTOList = publisherService.getAllPublisher();
        return publisherDTOList;
    }

    @PutMapping("/update-publisher")
    public String updatePublisher(@RequestBody PublisherDTO publisherDTO){
        return publisherService.updatePublisher(publisherDTO);
    }
    @DeleteMapping("/delete-publisher/{id}")
    public String updateAuthor(@PathVariable Integer id){
        return publisherService.deletePublisher(id);
    }
}
