package models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;

    @Column(name = "name", length = 100, unique = true)
    @Expose
    private String name;

    @Column(name = "email", length= 120, nullable = false)
    @Expose
    private String email;

    @Column(name = "password", length= 60)
    @Expose
    private String password;

    @Column(name = "admin")
    @Expose
    private Boolean admin;

    @Column(name = "confirmed")
    @Expose
    private Boolean confirmed;

    @Column(name = "token", length= 15)
    @Expose
    private String token;

    @ManyToMany(mappedBy = "users")
    private List<Course> courses = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, String password, Boolean admin, Boolean confirmed, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.confirmed = confirmed;
        this.token = token;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
