package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int course_id;

    @Column(name = "course_code", length = 50)
    private String courseCode;

    @Column(name = "course_name", length = 50)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "department_id")
    private AcademicUnitEnum department;

    @OneToMany(mappedBy = "course")
    private Set<CourseDefinition> courseDefinitions = new HashSet<>();
    
    @ManyToMany(mappedBy = "courses")
    private Set<StudentRegistration> registrations;

    // Constructors
    public Course() {
    }

    public Course(String courseCode, String courseName, Semester semester, AcademicUnitEnum department) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.semester = semester;
        this.department = department;
    }

    // Getters and Setters
    public int getId() {
        return course_id;
    }

    public void setId(int id) {
        this.course_id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public AcademicUnitEnum getDepartment() {
        return department;
    }

    public void setDepartment(AcademicUnitEnum department) {
        this.department = department;
    }

    public Set<CourseDefinition> getCourseDefinitions() {
        return courseDefinitions;
    }

    public void setCourseDefinitions(Set<CourseDefinition> courseDefinitions) {
        this.courseDefinitions = courseDefinitions;
    }

    public Set<StudentRegistration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<StudentRegistration> registrations) {
        this.registrations = registrations;
    }
}
