package Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="Semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sem_id")
    private int sem_id;

    @Column(name="semester_name", length=50)
    private String semesterName;

    @Column(name="starting_date")
    private Timestamp startingDate;

    @Column(name="end_date")
    private Timestamp endDate;

    @OneToMany(mappedBy = "semester")
    private List<Course> courses;

    // Constructors
    public Semester() {
    }

    public Semester(String semesterName, Timestamp startingDate, Timestamp endDate, List<Course> courses) {
        this.semesterName = semesterName;
        this.startingDate = startingDate;
        this.endDate = endDate;
        this.courses = courses;
    }

    // Getters and Setters
    public int getId() {
        return sem_id;
    }

    public void setId(int id) {
        this.sem_id = id;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Timestamp getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Timestamp startingDate) {
        this.startingDate = startingDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
