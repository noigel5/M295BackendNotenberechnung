package ch.ilv.notenberechnung.schoolsubject;

import ch.ilv.notenberechnung.semester.Semester;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SchoolSubject {
        @Id
        @GeneratedValue
        private Long id;
        @Column(nullable = false)
        private String subject;
        @ManyToOne(optional = false)
        @JoinColumn(name = "semster_id")
        private Semester semester;
}
