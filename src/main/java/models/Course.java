package models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="Courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 120, unique = true, nullable = false)
    private String name;

    @Column(name = "registered_users")
    private Integer registeredUsers;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "image")
    private String image;

    @Column(name = "category", length = 60)
    private String category;

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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id + "\n" +
                "name='" + name + "\n" +
                "registeredUsers=" + registeredUsers + "\n" +
                "publicationDate=" + publicationDate + "\n" +
                "image='" + image + "\n" +
                "category='" + category + "\n" +
                '}' + "\n";
    }
}
