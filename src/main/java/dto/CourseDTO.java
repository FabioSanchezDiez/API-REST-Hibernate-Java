package dto;

import com.google.gson.annotations.Expose;

public class CourseDTO {
    @Expose
    private Long id;
    @Expose
    private String image;
    @Expose
    private String name;
    @Expose
    private Integer registeredUsers;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String image, String name, Integer registeredUsers) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.registeredUsers = registeredUsers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", registeredUsers=" + registeredUsers +
                '}';
    }
}
