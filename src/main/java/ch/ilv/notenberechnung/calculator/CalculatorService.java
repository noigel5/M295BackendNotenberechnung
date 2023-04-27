package ch.ilv.notenberechnung.calculator;

import ch.ilv.notenberechnung.grade.Grade;
import ch.ilv.notenberechnung.grade.GradeRepository;
import ch.ilv.notenberechnung.schoolsubject.SchoolSubject;
import ch.ilv.notenberechnung.schoolsubject.SchoolSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CalculatorService {
    private final GradeRepository gradeRepository;
    private final SchoolSubjectRepository schoolSubjectRepository;
    public CalculatorService(GradeRepository gradeRepository, SchoolSubjectRepository schoolSubjectRepository) {
        this.gradeRepository = gradeRepository;
        this.schoolSubjectRepository = schoolSubjectRepository;
    }

    public double calculate(Calculator calculator) {
        if (calculator.getMaxPoints() == 0) {
            if (calculator.getAchievedPoints() == 0) {
                int listSize = calculator.getGrades().size();
                double AVG = 0;
                for (int i = 0; i < listSize; i++) {
                    AVG += calculator.getGrades().get(i);
                }
                return AVG/listSize;
            }
        }
         return calculator.getAchievedPoints() / calculator.getMaxPoints() * 5 + 1;
    }

    public double AvgSubject(Long subjectid) {
        List<Grade> grades = gradeRepository.findAll();
        double gradesToAVG = 0.0;
        int size = 0;
        for (Grade grade : grades) {
            if (Objects.equals(grade.getSchoolSubject().getId(), subjectid)) {
                gradesToAVG += (grade.getGrade());
                size += 1;
            }
        }
        return gradesToAVG/size;
    }

    public double AvgSemester(Long semesterid) {
        List<SchoolSubject> schoolSubjects = schoolSubjectRepository.findAll();
        List<Grade> grades = gradeRepository.findAll();
        double gradesToAVG = 0.0;
        int size = 0;
        for (SchoolSubject schoolSubject : schoolSubjects) {
            if (Objects.equals(schoolSubject.getSemester().getId(), semesterid)) {
                for (Grade grade : grades) {
                    if (Objects.equals(grade.getSchoolSubject().getId(), schoolSubject.getId())) {
                        gradesToAVG += (grade.getGrade());
                        size += 1;
                    }
                }
            }
        }
        return gradesToAVG/size;
    }
}
