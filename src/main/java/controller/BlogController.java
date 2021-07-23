package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import services.BlogService;

import java.util.List;

@Controller

public class BlogController {
    @Autowired
    //@Qualifier("blogService")
    private BlogService blogService;

    @GetMapping("/home")
    public String getHome(ModelMap modelMap) {
        List<Blog> blogList=blogService.getAllBlog();
        modelMap.addAttribute("list", blogList);
        modelMap.addAttribute("demo", "demo");
        return "home";
    }
    @GetMapping("/{id}")
    public String getBlog(ModelMap modelMap, @PathVariable Integer id) {
        modelMap.addAttribute("list", blogService.getId(id));
        return "detail";
    }
}
