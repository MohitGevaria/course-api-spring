package springtutorial.publisher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, String> {
//    public List<Publisher> findByBlogId(String blogId);
}