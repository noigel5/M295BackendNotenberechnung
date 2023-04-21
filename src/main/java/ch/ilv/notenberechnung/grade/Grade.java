package ch.ilv.notenberechnung.grade;

import ch.ilv.notenberechnung.schoolsubject.SchoolSubject;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Grade {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double grade;
    @ManyToOne(optional = false)
    @JoinColumn(name = "schoolsubject_id")
    private SchoolSubject schoolSubject;
}
