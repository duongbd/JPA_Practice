package services;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BlogRepository;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    public Blog getId(Integer id){
        return blogRepository.getOne(id);
    }
}
