package org.library.librarymanagement.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookUpdateDTO {
    private int bookId;

    private String bookName;

    private int authorId;

    private int publisherId;
}
