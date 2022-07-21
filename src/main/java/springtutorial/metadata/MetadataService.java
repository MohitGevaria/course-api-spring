package springtutorial.metadata;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial.comment.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MetadataService {
    @Autowired
    private MetadataRepository metadataRepository;


    public List<Metadata> getMetadata(String blogId){
        List<Metadata> metadata = new ArrayList<>();
        metadata = metadataRepository.findByBlogId(blogId);
        return metadata;
    }

    public void addMetadata(Metadata metadata) {
        metadataRepository.save(metadata);
    }

    public void updateMetadata(Metadata metadata, String id)
    {
        metadataRepository.save(metadata);
    }

}
