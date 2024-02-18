package dto;

import com.google.gson.annotations.Expose;

public class CourseDTO {
    @Expose
    private String image;
    @Expose
    private String name;
    @Expose

    private Integer registeredUsers;

    public CourseDTO() {
    }

    public CourseDTO(String image, String name, Integer registeredUsers) {
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

    @Override
    public String toString() {
        return "CourseDTO{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", registeredUsers=" + registeredUsers +
                '}';
    }
}
