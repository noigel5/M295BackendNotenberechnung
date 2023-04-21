package ch.ilv.notenberechnung.gradegroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeGroupRepository extends JpaRepository<GradeGroup, Long> {

}
