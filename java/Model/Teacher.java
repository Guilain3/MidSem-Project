package Model;

import javax.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int teacher_id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "qualification", length = 50)
    private QualificationEnum qualification;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Constructors
    public Teacher() {
    }

    public Teacher(String firstName, String lastName, QualificationEnum qualification, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        this.course = course;
    }

    // Getters and Setters
    public int getId() {
        return teacher_id;
    }

    public void setId(int id) {
        this.teacher_id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public QualificationEnum getQualification() {
        return qualification;
    }

    public void setQualification(QualificationEnum qualification) {
        this.qualification = qualification;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
