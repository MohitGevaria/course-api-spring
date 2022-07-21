package springtutorial.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtutorial.blog.Blog;
import springtutorial.blog.BlogService;

import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/publishers")
    public List<Publisher> getAllPublishers(){
        return publisherService.getAllPublishers();
    }

    @RequestMapping("/publishers/{id}")
    public Publisher getPublisherById(@PathVariable String id){
        return publisherService.getPublisher(id);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/publishers")
    public String addPublisher(@RequestBody Publisher publisher){
//        publisher.setBlog(blogService.getBlog(blogId));
//        comment.setBlog(new Blog("", "", "", blogId));
        publisherService.addPublisher(publisher);
        return "Publisher Added Successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/publishers/{id}")
    public String deletePublisher(@PathVariable String id){
        publisherService.deletePublisher(id);
        return "Publisher deleted.";
    }

    @RequestMapping(method=RequestMethod.POST, value = "publishers/{id}/blog/{id}")
    public String addBlogToPublisher(@PathVariable String publisherId, @PathVariable String blogId) {
        Publisher publisher = publisherService.getPublisher(publisherId);
        Blog blog = blogService.getBlog(blogId);
//        publisher.addBlog(blog);
        blog.addPublisher(publisher);
        return "Blog Added.";
    }
}
