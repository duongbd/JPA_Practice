package repository;

import model.Blog;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;


@Repository("blogRepository")
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findAllByCategoryId(Integer id);
    @Modifying
    @Query("update Blog u set u.category.id = null where u.category.id = :category")
    void setNullCategoryIdByCategoryId(@Param("category") Integer category);

    Blog findFirstByCategoryId(Integer id);

    Page<Blog> findAllByCategoryId(Integer categoryId, Pageable pageable);

    HashSet<Blog> findAllByTitleLike(String title);
    HashSet<Blog> findAllByTitleStartingWith(String title);
    HashSet<Blog> findAllByTitleEndingWith(String title);
    HashSet<Blog> findAllByTitleContaining(String title);
}
