package controller;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.BlogService;
import services.CategoryService;

import java.util.HashSet;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    //@Qualifier("blogService")
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String getListCategory(ModelMap modelMap) {
        List<Category> categoryList = categoryService.getListCategory().isEmpty() ? null : categoryService.getListCategory();
        List<Blog> blogList= blogService.getAllBlog();
        modelMap.addAttribute("list", categoryList);
        modelMap.addAttribute("blogList",blogList);
        return "list_category";
    }

    @GetMapping("/searchBlog")
    public String searchBlog(ModelMap modelMap, @RequestParam String title){
        List<Category> categoryList = categoryService.getListCategory().isEmpty() ? null : categoryService.getListCategory();
        HashSet<Blog> blogList=blogService.searchByTitle(title);
        if (blogList.isEmpty())
            modelMap.addAttribute("notFound","Not found blog like this");
        else
        {
            modelMap.addAttribute("blogList",blogList);
            modelMap.addAttribute("list", categoryList);
        }
        return "list_category";
    }
}
