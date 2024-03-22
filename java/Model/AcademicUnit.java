package Model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="Academic_unit")
public class AcademicUnit {
    @Id
    @Column(name = "Academic_id", columnDefinition = "BINARY(16)") 
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID academicId;
    
    @Column(name = "academic_code")
    private Long academicCode;
    
    @Column(name="academic_name")
    private String academicName;
    
    @Column(name="type")
    private AcademicUnitEnum type;
    
    @Column(name="parent_id", nullable=true)
    private UUID parentId;
    
    // Constructors
    public AcademicUnit() {
    }

    public AcademicUnit(Long academicCode, UUID academicId, String academicName, AcademicUnitEnum type, UUID parentId) {
        this.academicCode = academicCode;
        this.academicId = academicId;
        this.academicName = academicName;
        this.type = type;
        this.parentId = parentId;
    }
    
    // Getters and Setters
    public Long getAcademicCode() {
        return academicCode;
    }

    public void setAcademicCode(Long academicCode) {
        this.academicCode = academicCode;
    }

    public UUID getAcademicId() {
        return academicId;
    }

    public void setAcademicId(UUID academicId) {
        this.academicId = academicId;
    }

    public String getAcademicName() {
        return academicName;
    }

    public void setAcademicName(String academicName) {
        this.academicName = academicName;
    }

    public AcademicUnitEnum getType() {
        return type;
    }

    public void setType(AcademicUnitEnum type) {
        this.type = type;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }
}
