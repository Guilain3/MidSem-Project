package Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sem_id")
    private int sem_id;

    @Column(name="semester_name", length=50)
    private String semesterName;

    @Column(name="starting_date")
    private LocalDate startingDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "semester")
    private List<Course> courses;

    // Constructors
    public Semester() {
    }

    public Semester(String semesterName, LocalDate startingDate, LocalDate endDate, List<Course> courses) {
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

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
