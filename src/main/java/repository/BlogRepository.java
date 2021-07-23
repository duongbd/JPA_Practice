package repository;

import model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("blogRepository")
public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
