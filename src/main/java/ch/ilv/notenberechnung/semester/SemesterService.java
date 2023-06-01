package ch.ilv.notenberechnung.semester;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {

    private final SemesterRepository semesterRepository;

    SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public Semester createSemester(String semestername) {
        Semester semester = new Semester();
        semester.setName(semestername);
        semesterRepository.save(semester);
        return semester;
    }

    public List<Semester> getSemester() {
        return semesterRepository.findAll();
    }

    public Semester getSemester(Long semesterid) {
        Optional<Semester> semester = semesterRepository.findById(semesterid);
        return semester.get();
    }

    public Semester deleteSemester(Long semesterid) {
        Semester semester = new Semester();
        semester.setId(semesterid);
        semesterRepository.deleteById(semester.getId());
        return semester;
    }

    public Semester updateSemester(Semester semester) {
        semesterRepository.save(semester);
        return semester;
    }
}
