package ch.ilv.notenberechnung.semester;

import org.springframework.stereotype.Service;

@Service
public class SemsterService {

    private final SemesterRepository semesterRepository;
    SemsterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }
    
    public String createSemester(String semestername) {
        try {
            Semester semester = new Semester();
            semester.setName(semestername);
            semesterRepository.save(semester);
            return "%s created successfully".formatted(semestername);
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String getSemester() {
        try {
            return semesterRepository.findAll().toString();
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String deleteSemester(long semesterid) {
        try {
            Semester semester = new Semester();
            semester.setId(semesterid);
            semesterRepository.deleteById(semester.getId());
            return "%s deleted successfully".formatted(semesterid);
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }
}
