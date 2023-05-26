package ch.ilv.notenberechnung.schoolsubject;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolSubjectService {
    private final SchoolSubjectRepository schoolSubjectRepository;

    SchoolSubjectService(SchoolSubjectRepository schoolSubjectRepository) {
        this.schoolSubjectRepository = schoolSubjectRepository;
    }

    public String createSchoolSubject(SchoolSubject schoolSubject) {
        try {
            schoolSubjectRepository.save(schoolSubject);
            return "subject added successfully";
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public List<SchoolSubject> getSchoolSubject() {
        return schoolSubjectRepository.findAll();
    }

    public String getSchoolSubject(Long schoolsubjectid) {
        try {
            return schoolSubjectRepository.findById(schoolsubjectid).toString();
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String deleteSchoolSubject(long schoolsubject) {
        try {
            SchoolSubject schoolSubject = new SchoolSubject();
            schoolSubject.setId(schoolsubject);
            schoolSubjectRepository.deleteById(schoolSubject.getId());
            return "%s deleted successfully".formatted(schoolsubject);
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String updateSchoolSubject(SchoolSubject schoolSubject) {
        try {
            schoolSubjectRepository.save(schoolSubject);
            return "SchoolSubject updated successfully";
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }
}
