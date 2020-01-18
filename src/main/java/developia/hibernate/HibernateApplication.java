package developia.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    Book book;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(book);

//        Book book = new Book();
//        book.setAuthor("Jojo Moyes");
//        book.setIsbn("4233433");
//        book.setTitle("Still Me");
//
//
//        bookRepository.save(book);
//
//        Book book = bookRepository.findById(1L).get();
//
//        bookRepository.delete(book);

    }
}
