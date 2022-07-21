package springtutorial.metadata;

import jdk.jfr.MemoryAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetadataRepository extends CrudRepository<Metadata, String> {
    public List<Metadata> findByBlogId(String blogId);
}
