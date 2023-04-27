package ch.ilv.notenberechnung.semester;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Semester {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
}
