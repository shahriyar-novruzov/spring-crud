package developia.hibernate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @GetMapping("/viewForm")
    public String viewForm(Model model) {
        model.addAttribute("book", new Book());
        return "view";
    }
}
