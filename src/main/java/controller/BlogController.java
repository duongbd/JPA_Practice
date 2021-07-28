package controller;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import services.BlogService;
import services.CategoryService;

import java.util.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    //@Qualifier("blogService")
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public String getBlog(ModelMap modelMap, @PathVariable Integer id) {
        Blog blog = blogService.getById(id);
        modelMap.addAttribute("list", blog);
        return "detail_blog";
    }

    @PostMapping("/delete/{blogId}")
    public String deleteBlog(ModelMap modelMap, @PathVariable Integer blogId) {
        blogService.delBlogById(blogId);
        return "delete_success";
    }

    @PostMapping("/modify/{id}")
    public String modifyBlog(ModelMap modelMap, @PathVariable Integer id, @RequestParam String content) {
        blogService.modifyBlogContent(id, content);
        return "redirect:/";
    }

    @PostMapping(value = "/newBlog")
    public String saveBlog(ModelMap modelMap,@RequestParam String title, @RequestParam String content, @RequestParam String writer, @RequestParam String nameCategory) {
        Blog blog = new Blog();
        blog.setContent(content);
        blog.setTitle(title);
        blog.setWriter(writer);
        blog.setLastModify(new Date());
        blog.setDateCreate(new Date());
        System.out.println(nameCategory);
        Category category=categoryService.getCategoryByName(nameCategory);
        if (nameCategory.equals("")) {blog.setCategory(null);}
        else {
            if (category != null) blog.setCategory(category);
            else {
                modelMap.addAttribute("err", "Category not found so we cant save blog");
                return "new_blog";
            }
        }
        blogService.saveBlog(blog);
        return "redirect:/category/"+ nameCategory+"/1";
    }

    @GetMapping(value = "/newBlog")
    public String newBlog() {
        return "new_blog";
    }

    @ModelAttribute("categoryList")
    public List<Category> getCategoryList() {
        return categoryService.getListCategory();
    }
}
