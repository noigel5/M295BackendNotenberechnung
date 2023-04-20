package com.grades.notenberechnung.gradegroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class GradeGroup {
        @Id
        @GeneratedValue
        private Long id;
        @Column(nullable = false)
        private String name;
//        @OneToMany
//        private List<Grade> grades;
}
