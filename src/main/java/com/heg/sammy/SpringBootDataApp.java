package com.heg.sammy;

import com.heg.sammy.entities.Book;
import com.heg.sammy.service.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
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
    }
}
