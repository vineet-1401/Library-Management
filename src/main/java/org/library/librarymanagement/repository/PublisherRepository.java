package org.library.librarymanagement.repository;

import org.library.librarymanagement.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
