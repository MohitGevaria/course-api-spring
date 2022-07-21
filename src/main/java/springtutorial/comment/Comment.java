package springtutorial.comment;

import org.hibernate.annotations.GenericGenerator;
import springtutorial.blog.Blog;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Comment {
    @Column(columnDefinition = "VARCHAR(255)")

    private String body;
    private String userName;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "blogId", nullable = false)
    private Blog blog;

    public Comment() {
    }

    public Comment(String title, String body, String userName) {
        this.body = body;
        this.userName = userName;
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}
