package ch.ilv.notenberechnung.gradegroup;

import ch.ilv.notenberechnung.grades.Grade;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class GradeGroup {
        @Id
        @GeneratedValue
        private Long id;
        @Column(nullable = false)
        private String subject;
        @OneToMany
        @JoinColumn(name = "gradeGroup")
        private List<Grade> grades;
}
