package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BlogRepository;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
}
