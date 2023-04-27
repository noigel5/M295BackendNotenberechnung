package ch.ilv.notenberechnung.schoolsubject;

import org.springframework.stereotype.Service;

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

    public String getSchoolSubject() {
        try {
            return schoolSubjectRepository.findAll().toString();
        } catch (Exception e) {
            return String.valueOf(e);
        }
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
}
