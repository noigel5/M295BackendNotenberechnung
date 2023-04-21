package ch.ilv.notenberechnung.schoolsubject;

import ch.ilv.notenberechnung.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "bearerAuth")
@RestController
public class SchoolSubjectController {

    private final SchoolSubjectService schoolSubjectService;
    SchoolSubjectController(SchoolSubjectService schoolSubjectService1) {
        this.schoolSubjectService = schoolSubjectService1;
    }

    @RolesAllowed(Roles.Admin)
    @PostMapping("/schoolsubject")
    public String createschoolsubject(@RequestBody String schoolsubjectname) {
        return schoolSubjectService.createSchoolSubject(schoolsubjectname);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/schoolsubject")
    public String getschoolsubject() {
        return schoolSubjectService.getSchoolSubject();
    }

    @RolesAllowed(Roles.Admin)
    @DeleteMapping("/schoolsubject/{schoolsubject}")
    public String deleteschoolsubject(@PathVariable Long schoolsubject) {
        return schoolSubjectService.deleteSchoolSubject(schoolsubject);
    }
}
