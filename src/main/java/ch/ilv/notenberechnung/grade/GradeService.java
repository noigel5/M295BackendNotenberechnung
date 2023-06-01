package ch.ilv.notenberechnung.grade;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Grade addGrade(Grade grade) {
        gradeRepository.save(grade);
        return grade;
    }

    public List<Grade> getgrade() {
        return gradeRepository.findAll();
    }

    public Grade getgrade(Long gradeid) {
        Optional<Grade> grade = gradeRepository.findById(gradeid);
        return grade.get();
    }

    public List<Grade> getGradeBySchoolSubjectId(Long schoolsubjectid) {
        return gradeRepository.findBySchoolSubjectId(schoolsubjectid);
    }

    public Grade deletegrade(Grade grade) {
        gradeRepository.deleteById(grade.getId());
        return grade;
    }

    public Grade updateGrade(Grade grade) {
        gradeRepository.save(grade);
        return grade;
    }
}
