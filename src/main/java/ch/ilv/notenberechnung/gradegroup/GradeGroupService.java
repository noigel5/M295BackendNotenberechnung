package ch.ilv.notenberechnung.gradegroup;

import org.springframework.stereotype.Service;

@Service
public class GradeGroupService {
    private final GradeGroupRepository gradeGroupRepository;
    GradeGroupService(GradeGroupRepository gradeGroupRepository) {
        this.gradeGroupRepository = gradeGroupRepository;
    }
    public String createGroup(String groupname) {
        try {
            GradeGroup gradeGroup = new GradeGroup();
            gradeGroup.setSubject(groupname);
            gradeGroupRepository.save(gradeGroup);
            return "%s created successfully".formatted(groupname);
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String getGroup() {
        try {
            return gradeGroupRepository.findAll().toString();
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String deleteGroup(long groupid) {
        try {
            GradeGroup gradeGroup = new GradeGroup();
            gradeGroup.setId(groupid);
            gradeGroupRepository.deleteById(gradeGroup.getId());
            return "%s deleted successfully".formatted(groupid);
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }
}
