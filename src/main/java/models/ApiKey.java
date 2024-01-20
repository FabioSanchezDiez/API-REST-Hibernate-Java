package models;

import javax.persistence.*;

@Entity
@Table(name="ApiKey")
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "api_key", length = 40, unique = true, nullable = false)
    private String apiKey;
    @Column(name = "uses")
    private Integer uses;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "read_only")
    private Boolean readOnly;

    public ApiKey() {
    }

    public ApiKey(Long id, String key, Integer uses, Boolean active, Boolean readOnly) {
        this.id = id;
        this.apiKey = key;
        this.uses = uses;
        this.active = active;
        this.readOnly = readOnly;
    }

    public void decrementUse(){
        this.uses--;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Integer getUses() {
        return uses;
    }

    public void setUses(Integer uses) {
        this.uses = uses;
    }

    public Boolean getActive() {
        if (this.uses <= 0) this.active = false;
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @Override
    public String toString() {
        return "ApiKey{" +
                "id=" + id +
                ", key='" + apiKey + '\'' +
                ", uses=" + uses +
                ", active=" + active +
                ", readOnly=" + readOnly +
                '}';
    }
}
