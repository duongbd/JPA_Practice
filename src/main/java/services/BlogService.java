package services;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BlogRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class BlogService {
    @Autowired
    @Qualifier("blogRepository")
    private BlogRepository blogRepository;

    public List<Blog> getAllBlog() {
        return blogRepository.findAll(Sort.by(Sort.Direction.ASC, "dateCreate"));
    }

    public Blog getById(Integer id) {
        return blogRepository.findById(id).get();
    }

    @Transactional
    public void delBlogById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public void modifyBlogContent(Integer id, String content) {
        blogRepository.findById(id).ifPresent(blog -> {
            blog.setContent(content);
            blog.setLastModify(new Date());
            blogRepository.save(blog);
        });
    }

    @Transactional
    public void setCategoryIdNullWhenDeleteCategory(Integer id) {
        Category category=new Category();
        category.setId(0);
        blogRepository.setNullCategoryIdByCategoryId(id);
    }

    @Transactional
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public List<Blog> getAllByIdCategory(Integer id) {
        return blogRepository.findAllByCategoryId(id);

    }

    public boolean checkCategoryIdExist(Integer id){
        return blogRepository.findFirstByCategoryId(id) != null;
    }

    public Page<Blog> getPage(Integer categoryId, Pageable pageable){
        return blogRepository.findAllByCategoryId(categoryId, pageable);
    }

    public HashSet<Blog> searchByTitle(String title){
        HashSet<Blog> blogList=blogRepository.findAllByTitleContaining(title);
        blogList.addAll(blogRepository.findAllByTitleEndingWith(title));
        blogList.addAll(blogRepository.findAllByTitleStartingWith(title));
        blogList.addAll(blogRepository.findAllByTitleLike(title));
        return blogList;
    }
}
