package springtutorial.comment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments(String blogId){
        List<Comment> comments = new ArrayList<>();
        commentRepository.findByBlogId(blogId).forEach(comments::add);
        return comments;
    }

    public Comment getComment(String id){
        Optional<Comment> comment;
        comment = commentRepository.findById(id);
        return comment.get();
    }

    public void addComment(Comment topic) {
        commentRepository.save(topic);
    }

    public void updateComment(Comment topic, String id)
    {
        commentRepository.save(topic);
    }

    public void deleteComment(String id){
        commentRepository.deleteById(id);
    }
}
