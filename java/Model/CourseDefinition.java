package Model;

import javax.persistence.*;

@Entity
@Table(name = "Course_Definition")
public class CourseDefinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_def_id")
    private int course_def_id;

    @Column(name = "course_definition_code", length = 50)
    private String courseDefinitionCode;

    @Column(name = "course_definition_description", length = 50)
    private String courseDefinitionDescription;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Constructors
    public CourseDefinition() {
    }

    public CourseDefinition(String courseDefinitionCode, String courseDefinitionDescription, Course course) {
        this.courseDefinitionCode = courseDefinitionCode;
        this.courseDefinitionDescription = courseDefinitionDescription;
        this.course = course;
    }

    // Getters and Setters
    public int getId() {
        return course_def_id;
    }

    public void setId(int id) {
        this.course_def_id = id;
    }

    public String getCourseDefinitionCode() {
        return courseDefinitionCode;
    }

    public void setCourseDefinitionCode(String courseDefinitionCode) {
        this.courseDefinitionCode = courseDefinitionCode;
    }

    public String getCourseDefinitionDescription() {
        return courseDefinitionDescription;
    }

    public void setCourseDefinitionDescription(String courseDefinitionDescription) {
        this.courseDefinitionDescription = courseDefinitionDescription;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
