package Model;

import javax.persistence.*;
import java.util.Set;
import java.sql.Timestamp;

@Entity
@Table(name="Student_Registration")
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_id")
    private int reg_id;

    @Column(name="registration_code", length=50)
    private String registrationCode;

    @Column(name="registration_date")
    private Timestamp registrationDate;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name="semester_id")
    private Semester semester;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "department_id")
    private AcademicUnitEnum department;
    
    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "registration_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
    
    // Constructor
    public StudentRegistration() {
    }

    public StudentRegistration(String registrationCode, Timestamp registrationDate,
            Student student, Semester semester, AcademicUnitEnum department) {
        this.registrationCode = registrationCode;
        this.registrationDate = registrationDate;
        this.student = student;
        this.semester = semester;
        this.department = department;
    }

    // Getters and Setters
    public int getId() {
        return reg_id;
    }

    public void setId(int id) {
        this.reg_id = id;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
