package repository;

import model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("BlogRepository")
public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
