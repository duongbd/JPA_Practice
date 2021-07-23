package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.BlogRepository;
import services.BlogService;

import java.util.List;

@Controller

public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/home")
    public String getHome(ModelMap modelMap) {
        Blog blog= blogService.getId(1);
        //modelMap.addAttribute("list", blogList);
        modelMap.addAttribute("demo", "demo");
        return "home";
    }
}
