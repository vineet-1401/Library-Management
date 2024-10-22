package org.library.librarymanagement.service.impl;

import org.library.librarymanagement.DTO.PublisherDTO;
import org.library.librarymanagement.model.Publisher;
import org.library.librarymanagement.repository.PublisherRepository;
import org.library.librarymanagement.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public String addPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher(
                publisherDTO.getPublisherName()
        );
        publisherRepository.save(publisher);
        return "Publisher added successfully";
    }

    @Override
    public List<PublisherDTO> getAllPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        List<PublisherDTO> publisherDTOs = new ArrayList<PublisherDTO>();
        for (Publisher publisher : publishers) {
            PublisherDTO publisherDTO = new PublisherDTO(
                    publisher.getPublisherId(),
                    publisher.getPublisherName()
            );
            publisherDTOs.add(publisherDTO);
        }
        return publisherDTOs;
    }

    @Override
    public String updatePublisher(PublisherDTO publisherDTO) {
        if(publisherRepository.existsById(publisherDTO.getPublisherId())) {
            Publisher publisher = publisherRepository.findById(publisherDTO.getPublisherId()).get();
            publisher.setPublisherName(publisherDTO.getPublisherName());
            publisherRepository.save(publisher);
            return "Publisher updated successfully";
        }else {
            return "Publisher not found";
        }
    }

    @Override
    public String deletePublisher(Integer id) {
        if(publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id);
            return "Publisher deleted successfully";
        }
        return "Publisher not found";
    }
}
