package org.library.librarymanagement.service;

import org.library.librarymanagement.DTO.PublisherDTO;

import java.util.List;

public interface PublisherService {
    String addPublisher(PublisherDTO publisherDTO);

    List<PublisherDTO> getAllPublisher();

    String updatePublisher(PublisherDTO publisherDTO);

    String deletePublisher(Integer id);
}
