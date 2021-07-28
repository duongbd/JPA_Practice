package services;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

    public Category getCategoryByName(String name){
        return categoryRepository.findByName(name);
    }

    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).get();
    }


    public List<Category> getListCategory(){
        return categoryRepository.findAll(Sort.by("name"));
    }
    public int getIdByName(String name){
        return categoryRepository.findByName(name).getId();
    }

    @Transactional
    public boolean saveCategory(Category category) {
        if(categoryRepository.existsByName(category.getName()))
            return false;
        else
        categoryRepository.save(category);
        return true;
    }

    @Transactional
    public void delBlogById(Integer id) {
        categoryRepository.deleteById(id);
    }
}
