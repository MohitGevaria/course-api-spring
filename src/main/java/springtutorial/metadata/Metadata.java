package springtutorial.metadata;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Metadata {

    private String name;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String description;

    private Date date_uploaded;

    private String blogId;

    public Metadata(){
        
    }

    public Metadata(String name, String id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.date_uploaded = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_uploaded() {
        return date_uploaded;
    }

    public void setDate_uploaded(Date date_uploaded) {
        this.date_uploaded = date_uploaded;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}
