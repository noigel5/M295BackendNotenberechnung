package ch.ilv.notenberechnung.grade;

import org.springframework.stereotype.Service;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public String addGrade(Grade grade) {
        try {
            gradeRepository.save(grade);
            return "grade added successfully";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String getgrade() {
        try {
            return gradeRepository.findAll().toString();
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String getgrade(Long gradeid) {
        try {
            return gradeRepository.findById(gradeid).toString();
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String deletegrade(Long gradeid) {
        try {
            gradeRepository.deleteById(gradeid);
            return "%d deleted successfully".formatted(gradeid);
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }
}
