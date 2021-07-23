package controller;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import services.BlogService;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller

public class BlogController {
    @Autowired
    //@Qualifier("blogService")
    private BlogService blogService;

    @GetMapping("/")
    public String getHome(ModelMap modelMap) {
        List<Blog> blogList = blogService.getAllBlog();
        blogList.sort(Comparator.comparing(Blog::getDate_create));
        modelMap.addAttribute("list", blogList);
        return "home";
    }

    @GetMapping("/{id}")
    public String getBlog(ModelMap modelMap, @PathVariable Integer id) {
        Blog blog = blogService.getId(id);
        modelMap.addAttribute("list", blog);
        return "detail";
    }

    @PostMapping("/delete/{id}")
    public String delBlog(ModelMap modelMap, @PathVariable Integer id) {
        blogService.delBlogById(id);
        return "redirect:/";
    }

    @PostMapping("/modify/{id}")
    public String modifyBlog(ModelMap modelMap, @PathVariable Integer id, @RequestParam String content) {
        blogService.modifyBlogContent(id, content);
        return "redirect:/";
    }

    @PostMapping(value = "/newBlog")
    public String saveBlog(@RequestParam String title,@RequestParam String content,@RequestParam String writer) {
        System.out.println(title);
        Blog blog=new Blog();
        blog.setContent(content);
        blog.setTitle(title);
        blog.setWriter(writer);
        blog.setLast_modify(new Date());
        blog.setDate_create(new Date());
        blogService.saveBlog(blog);
        return "redirect:/";
    }
    @GetMapping(value = "/newBlog")
    public String newBlog(){
        return "new";
    }
}
