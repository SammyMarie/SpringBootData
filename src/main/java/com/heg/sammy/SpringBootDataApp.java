package com.heg.sammy;

import com.heg.sammy.entities.Book;
import com.heg.sammy.service.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by Samuel Ifere on 01/06/2016.
 */
@SpringBootApplication
public class SpringBootDataApp {

    public static void main(String... args){
        ApplicationContext context = SpringApplication.run(SpringBootDataApp.class, args);
        BookRepository repository = context.getBean(BookRepository.class);

        for(Book book : repository.findByTitleContaining("of")){
            System.out.println(book);
        }

        for(Book book : repository.findByTitleContainingAndPageCountGreaterThan("of", 150)){
            System.out.println(book + "\n");
        }

        for(Book book : repository.findByTitleContainingOrTitleContaining("of", "animal")){
            System.out.println(book + "\n");
        }

        for(Book book : repository.findByPageCountBetween(100, 150)){
            System.out.println(book + "\n");
        }
    }
}
