package services;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BlogRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    public Blog getId(Integer id){
        return blogRepository.findById(id).get();
    }
    @Transactional
    public void delBlogById(Integer id){
        blogRepository.deleteById(id);
    }
    @Transactional
    public void modifyBlogContent(Integer id, String content){
        blogRepository.findById(id).ifPresent(blog -> {blog.setContent(content);blog.setLast_modify(new Date());blogRepository.save(blog);});
    }
    @Transactional
    public void saveBlog(Blog blog){
        blogRepository.save(blog);
    }
}
