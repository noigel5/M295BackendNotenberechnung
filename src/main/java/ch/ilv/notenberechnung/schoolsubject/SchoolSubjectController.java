package ch.ilv.notenberechnung.schoolsubject;

import ch.ilv.notenberechnung.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createschoolsubject(@RequestBody String schoolsubjectname) {
        return new ResponseEntity<>(schoolSubjectService.createSchoolSubject(schoolsubjectname), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/schoolsubject")
    public ResponseEntity<String> getschoolsubject() {
        return new ResponseEntity<>(schoolSubjectService.getSchoolSubject(), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @DeleteMapping("/schoolsubject/{schoolsubject}")
    public ResponseEntity<String> deleteschoolsubject(@PathVariable Long schoolsubject) {
        return new ResponseEntity<>(schoolSubjectService.deleteSchoolSubject(schoolsubject), HttpStatus.OK);
    }
}
