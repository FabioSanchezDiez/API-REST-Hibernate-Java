package models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name="Lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    private Long id;

    @Column(name = "name", length = 180, nullable = false)
    @Expose
    private String name;

    @Column(name = "lesson_order")
    @Expose
    private Integer lessonOrder;

    @Column(name = "video")
    @Expose
    private String video;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    public Lesson() {
    }

    public Lesson(Long id, String name, Integer lessonOrder, String video) {
        this.id = id;
        this.name = name;
        this.lessonOrder = lessonOrder;
        this.video = video;
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

    public Integer getLessonOrder() {
        return lessonOrder;
    }

    public void setLessonOrder(Integer lessonOrder) {
        this.lessonOrder = lessonOrder;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
