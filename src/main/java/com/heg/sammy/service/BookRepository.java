package com.heg.sammy.service;

import com.heg.sammy.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Samuel Ifere on 01/06/2016.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByTitleNot(String title);
    List<Book> findByTitleContainingOrTitleContaining(String title, String title1);
    List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);
    List<Book> findByPageCountBetween(int min, int max);
}
