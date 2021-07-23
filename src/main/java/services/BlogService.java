package services;

import model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BlogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    public Optional<Blog> getId(Integer id){
        return blogRepository.findById(id);
    }
}
