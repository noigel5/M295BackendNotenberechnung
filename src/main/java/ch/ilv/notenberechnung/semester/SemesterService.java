package ch.ilv.notenberechnung.semester;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {

    private final SemesterRepository semesterRepository;

    SemesterService(SemesterRepository semesterRepository) {
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

    public List<Semester> getSemester() {
        return semesterRepository.findAll();
    }

    public String getSemester(Long semesterid) {
        try {
            return semesterRepository.findById(semesterid).toString();
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String deleteSemester(Long semesterid) {
        try {
            Semester semester = new Semester();
            semester.setId(semesterid);
            semesterRepository.deleteById(semester.getId());
            return "%s deleted successfully".formatted(semesterid);
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String updateSemester(Semester semester) {
        try {
            semesterRepository.save(semester);
            return "Semester updated successfully";
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }
}
