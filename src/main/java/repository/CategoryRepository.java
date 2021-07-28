package repository;


import model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByName(String nameCategory);

    boolean existsByName(String name);
}
