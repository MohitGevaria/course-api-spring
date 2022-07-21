package springtutorial.blog;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import springtutorial.category.Category;
import springtutorial.metadata.Metadata;
import springtutorial.publisher.Publisher;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Blog {
    private String title;
    @Column(columnDefinition = "VARCHAR(255)")
    private String body;
    private String author;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToMany()
    private List<Category> categories;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "metadata_id")
    private Metadata metadata;

//    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "publisher_id", nullable = true)

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "SuperHero_Movies",
            joinColumns = {@JoinColumn(name = "superhero_id")},
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    @JsonIgnoreProperties("blog")
    private Set<Publisher> publisher;

    public Blog() {
    }

    public Blog(String title, String body, String author, String id) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Set<Publisher> getPublisher() {
        return publisher;
    }

    public void setPublisher(Set<Publisher> publisher) {
        this.publisher = publisher;
    }

    public void addPublisher(Publisher publisher) {
        this.publisher.add(publisher);
    }
}
