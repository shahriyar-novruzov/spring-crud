package developia.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/create")
    public void create(@ModelAttribute Book book) {
        bookRepository.save(book);
    }

    @ResponseBody
    @GetMapping("/view")
    public String view(Model model, @RequestParam Long id) {
        System.out.println("IDDDDD: " + id);

        try {
            Book book = bookRepository.findById(id).get();
            model.addAttribute("book", book);
            return "view";
        } catch (Exception e) {
            return "not_found";
        }
    }

    @GetMapping("/books")
    public String getBooks(Model model) {

        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String findBook(@PathVariable Integer id) {

        System.out.println(id);
        return "books";
    }

    @PostMapping(value = "/processBook")
    public String processBook(@ModelAttribute Book book) {
        System.out.println(book.getTitle());
        return "books";
    }

    @PostMapping(value = "/updateBook")
    public String updateBook(@ModelAttribute Book book) {
        System.out.println(book.getTitle());
        bookRepository.save(book);
        return "books";
    }

    @GetMapping(value = "/book")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @GetMapping(value = "/deleteBook")
    public String deleteBook(@RequestParam Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return "books";
    }

    @GetMapping(value = "/deleteForm")
    public String deleteBook() {
        return "delete";
    }

//    @GetMapping("/viewBook")
//    public String view(Model model, @RequestParam Long id) {
//        System.out.println(id);
//        Book book = bookRepository.findById(id).get();
//        model.addAttribute("book", book);
//        return "view";
//    }

    @GetMapping("/findBook")
    public String findBook(Model model, @RequestParam Long id) {
        System.out.println(id);
        Book book = bookRepository.findById(id).get();
        model.addAttribute("book", book);
        return "update";
    }

    @GetMapping("/delete")
    public String delete() {

        return "delete";
    }

    @GetMapping("/update")
    public String update(Model model) {
        model.addAttribute("book", new Book());
        return "update";
    }
}
