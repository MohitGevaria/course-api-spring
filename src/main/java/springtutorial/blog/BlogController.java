package springtutorial.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogservice;

    @RequestMapping("/blogs")
    public List<Blog> getAll(){
        return blogservice.getAllBlogs();
    }

    @RequestMapping("/blogs/{id}")
    public Blog getBlogById(@PathVariable String id){
        return blogservice.getBlog(id);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/blogs")
    public String addBlog(@RequestBody Blog blog){
        blog.getMetadata().setDate_uploaded(new Date());
        blogservice.addBlog(blog);
        blog.getMetadata().setBlogId(blog.getId());
        return "Blog Added Successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/blogs/{id}")
    public String deleteBlog(@PathVariable String id){
        blogservice.deleteBlog(id);
        return "Blog deleted.";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/blogs/category/{categoryId}")
    public List<Blog> getBlogsByCategory(@PathVariable String categoryId){
        return blogservice.getBlogsByCategory(categoryId);
    }
}
