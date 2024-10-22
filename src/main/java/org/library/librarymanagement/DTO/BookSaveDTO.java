package org.library.librarymanagement.DTO;

import lombok.*;
import org.library.librarymanagement.model.Author;
import org.library.librarymanagement.model.Publisher;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookSaveDTO {

    private String bookName;

    private int authorId;

    private int publisherId;
}
