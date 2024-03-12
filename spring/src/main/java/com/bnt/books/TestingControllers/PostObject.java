package com.bnt.books.TestingControllers;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PostObject {
    int userid;

    String community;

    String data;

    String description;
}
