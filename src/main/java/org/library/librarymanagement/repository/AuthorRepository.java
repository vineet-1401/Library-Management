package org.library.librarymanagement.repository;


import org.library.librarymanagement.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Integer> {}
