package controller;

import model.Blog;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import repository.BlogRepository;

import java.util.List;
import java.util.Map;

@Controller
public class BlogController {
    private BlogRepository blogRepository;

    @GetMapping("/home")
    public String getHome(ModelMap modelMap) {
        modelMap.addAttribute("list", blogRepository.findAll(Sort.by("date_create")));
        return "home";
    }
}
