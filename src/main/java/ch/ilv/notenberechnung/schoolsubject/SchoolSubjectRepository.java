package ch.ilv.notenberechnung.schoolsubject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolSubjectRepository extends JpaRepository<SchoolSubject, Long> {

    List<SchoolSubject> findBySemesterId(Long id);
}
