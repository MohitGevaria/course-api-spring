package springtutorial.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springtutorial.category.Category;
import springtutorial.comment.Comment;

import java.util.List;

@Repository
public interface BlogRepository extends CrudRepository<Blog, String> {
    public List<Blog> findByCategoriesId(String categoryId);
}