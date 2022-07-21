package springtutorial.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtutorial.blog.Blog;
import springtutorial.blog.BlogService;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/blogs/{blogId}/comments")
    public List<Comment> getAll(@PathVariable String blogId){
        return commentService.getAllComments(blogId);
    }

    @RequestMapping("/blogs/{blogId}/comments/{id}")
    public Comment getCommentById(@PathVariable String id){
        return commentService.getComment(id);
    }

    @RequestMapping(method=RequestMethod.POST, value = "/blogs/{blogId}/comments")
    public String addComment(@RequestBody Comment comment, @PathVariable String blogId){
        comment.setBlog(blogService.getBlog(blogId));
//        comment.setBlog(new Blog("", "", "", blogId));
        commentService.addComment(comment);
        return "Comment Added Successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/blogs/{blogId}/comments/{id}")
    public String deleteComment(@PathVariable String id){
        commentService.deleteComment(id);
        return "Comment deleted.";
    }

}
