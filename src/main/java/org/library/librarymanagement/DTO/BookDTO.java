package org.library.librarymanagement.DTO;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.library.librarymanagement.model.Author;
import org.library.librarymanagement.model.Publisher;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private int bookId;

    private String bookName;

    private AuthorDTO author;

    private PublisherDTO publisher;
}
