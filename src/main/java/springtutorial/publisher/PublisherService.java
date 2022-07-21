package springtutorial.publisher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtutorial.blog.Blog;
import springtutorial.blog.BlogRepository;
import springtutorial.blog.BlogService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers(){
        List<Publisher> publishers = new ArrayList<>();
        publisherRepository.findAll().forEach(publishers::add);
        return publishers;
    }

    public Publisher getPublisher(String id){
        Optional<Publisher> comment;
        comment = publisherRepository.findById(id);
        return comment.get();
    }

    public void addPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher, String id)
    {
        publisherRepository.save(publisher);
    }

    public void deletePublisher(String id){
        publisherRepository.deleteById(id);
    }

}
