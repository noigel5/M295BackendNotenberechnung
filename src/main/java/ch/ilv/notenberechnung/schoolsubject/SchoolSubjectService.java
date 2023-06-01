package ch.ilv.notenberechnung.schoolsubject;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolSubjectService {
    private final SchoolSubjectRepository schoolSubjectRepository;

    SchoolSubjectService(SchoolSubjectRepository schoolSubjectRepository) {
        this.schoolSubjectRepository = schoolSubjectRepository;
    }

    public SchoolSubject createSchoolSubject(SchoolSubject schoolSubject) {
        schoolSubjectRepository.save(schoolSubject);
        return schoolSubject;
    }

    public List<SchoolSubject> getSchoolSubject() {
        return schoolSubjectRepository.findAll();
    }

    public SchoolSubject getSchoolSubject(Long schoolsubjectid) {
        Optional<SchoolSubject> schoolSubject = schoolSubjectRepository.findById(schoolsubjectid);
        return schoolSubject.get();
    }

    public List<SchoolSubject> getSchoolSubjectBySemester(Long semesterId) {
        return schoolSubjectRepository.findBySemesterId(semesterId);
    }

    public SchoolSubject deleteSchoolSubject(long schoolsubject) {
        SchoolSubject schoolSubject = new SchoolSubject();
        schoolSubject.setId(schoolsubject);
        schoolSubjectRepository.deleteById(schoolSubject.getId());
        return schoolSubject;
    }

    public SchoolSubject updateSchoolSubject(SchoolSubject schoolSubject) {
        schoolSubjectRepository.save(schoolSubject);
        return schoolSubject;
    }
}
