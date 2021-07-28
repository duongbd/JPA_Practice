package controller;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.BlogService;
import services.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    //@Qualifier("blogService")
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("")
    public String getListCategory(ModelMap modelMap) {
        List<Category> categoryList = categoryService.getListCategory().isEmpty() ? null : categoryService.getListCategory();
        modelMap.addAttribute("list", categoryList);
        return "list_category";
    }

    @RequestMapping(value = "/{categoryName}/{pageId}", method = RequestMethod.GET)
    public ModelAndView getHome(@PathVariable String categoryName, @PathVariable Integer pageId) {
        Integer id = categoryService.getIdByName(categoryName);
        //List<Blog> blogList = blogService.getAllByIdCategory(id);
        Page<Blog> blogPage = blogService.getPage(id, PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "dateCreate")));
        for (int i = 1; i < pageId; i++)
            blogPage = blogService.getPage(id, blogPage.nextPageable());
        List<Blog> blogList = blogPage.getContent();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= blogPage.getTotalPages(); i++)
            list.add(i);
        //blogList.sort(Comparator.comparing(Blog::getDate_create));
        ModelAndView modelAndView = new ModelAndView("list_blog");
        modelAndView.addObject("list", blogList);
        modelAndView.addObject("name", categoryName);
        modelAndView.addObject("count", list);
        return modelAndView;
    }

    @GetMapping("/Non-Category/{pageId}")
    public String getBlog(ModelMap modelMap, @PathVariable Integer pageId) {
        Page<Blog> blogPage = blogService.getPage(null, PageRequest.of(0, 2,Sort.by(Sort.Direction.ASC, "dateCreate")));
        for (int i = 1; i < pageId; i++)
            blogPage = blogService.getPage(null, blogPage.nextPageable());
        List<Blog> blogList = blogPage.getContent();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= blogPage.getTotalPages(); i++)
            list.add(i);
        modelMap.addAttribute("list", blogList);
        modelMap.addAttribute("name", "Non-Category");
        modelMap.addAttribute("count", list);
        return "list_blog";
    }

    @PostMapping(value = "/new")
    public String saveCategory(ModelMap modelMap, @RequestParam String nameCategory) {
        Category category = new Category();
        category.setName(nameCategory);
        if (categoryService.saveCategory(category))
            return "redirect:/category";
        else {
            modelMap.addAttribute("err", "Category is exist so we can't save new category");
            return "new_category";
        }
    }

    @PostMapping("/delete/{nameCategory}")
    public String delBlog(ModelMap modelMap, @PathVariable String nameCategory) {
        if (blogService.checkCategoryIdExist(categoryService.getIdByName(nameCategory)))
            blogService.setCategoryIdNullWhenDeleteCategory(categoryService.getIdByName(nameCategory));
        categoryService.delBlogById(categoryService.getIdByName(nameCategory));
        return "redirect:/category";
    }

    @GetMapping(value = "/new")
    public String newCategory() {
        return "new_category";
    }
}
