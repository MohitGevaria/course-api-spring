package springtutorial.course;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import springtutorial.topic.Topic;

import javax.persistence.*;

@Entity
public class Course {

    private String name;
    @Id
    private String id;
    private String description;
    @ManyToOne
    @JoinColumn(name = "topicId", nullable = false)
    private Topic topic;

    public Course(){
        
    }

    public Course(String name, String id, String description, String topicId) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.topic = new Topic("", topicId, "");
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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


}
