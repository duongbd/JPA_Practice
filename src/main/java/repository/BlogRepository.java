package repository;

import model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("blogRepository")
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAll();
}
