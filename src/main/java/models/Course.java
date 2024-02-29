package models;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;

    @Column(name = "name", length = 120, unique = true, nullable = false)
    @Expose
    private String name;

    @Lob
    @Column(name = "description", nullable = false)
    @Expose
    private String description;

    @Column(name = "registered_users")
    @Expose
    private Integer registeredUsers;

    @Column(name = "publication_date")
    @Expose
    private LocalDate publicationDate;

    @Column(name = "image")
    @Expose
    private String image;

    @Column(name = "category", length = 60)
    @Expose
    private String category;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Section> sections = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users = new ArrayList<>();

    public Course() {
    }

    public Course(Long id, String name, Integer registeredUsers, LocalDate publicationDate, String image, String category) {
        this.id = id;
        this.name = name;
        this.registeredUsers = registeredUsers;
        this.publicationDate = publicationDate;
        this.image = image;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(Integer registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public void increaseRegisteredUsers() {
        this.registeredUsers += 1;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id + "\n" +
                "name=" + name + "\n" +
                "registeredUsers=" + registeredUsers + "\n" +
                "publicationDate=" + publicationDate + "\n" +
                "image=" + image + "\n" +
                "category=" + category + "\n" +
                '}' + "\n";
    }
}
