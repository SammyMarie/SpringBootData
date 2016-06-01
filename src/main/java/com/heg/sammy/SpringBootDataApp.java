package com.heg.sammy;

import com.heg.sammy.entities.Book;
import com.heg.sammy.service.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Samuel Ifere on 01/06/2016.
 */
@SpringBootApplication
public class SpringBootDataApp {

    public static void main(String[] args){
        ApplicationContext context = SpringApplication.run(SpringBootDataApp.class, args);
        BookRepository repository = context.getBean(BookRepository.class);

        List<Book> books = repository.findAll(new ArrayList<Long>(){{
            add(1L);
            add(4L);
            add(6L);
        }});

        for (Book book: books) {
            System.out.println(book);
        }

        Book book = repository.findByPageCount(100);
        System.out.println("\n" + book);

        book.setTitle("A test book");
        book.setPageCount(200);
        book.setPublishDate(new Date());
        book.setPrice(new BigDecimal("200.00"));

        repository.save(book);
        Book saved = repository.save(book);
        System.out.println("Saved! " + saved);
    }
}
