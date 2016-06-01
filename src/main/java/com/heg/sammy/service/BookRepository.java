package com.heg.sammy.service;

import com.heg.sammy.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Samuel Ifere on 01/06/2016.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByPageCount(int count);
}
