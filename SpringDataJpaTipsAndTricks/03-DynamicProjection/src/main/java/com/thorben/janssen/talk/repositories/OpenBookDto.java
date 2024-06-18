package com.thorben.janssen.talk.repositories;

import org.springframework.beans.factory.annotation.Value;

public interface OpenBookDto {
      
    @Value("#{target.id}-#{target.title.toUpperCase()}")
    String getIdWithTitle();

    // Long getId();
    // String getTitle();

    // default String getIdWithTitle() {
    //     return getId()+"-"+getTitle().toUpperCase();
    // }
}
