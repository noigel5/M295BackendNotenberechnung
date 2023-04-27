package ch.ilv.notenberechnung.schoolsubject;

import ch.ilv.notenberechnung.security.Roles;
import ch.ilv.notenberechnung.semester.Semester;
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
    public ResponseEntity<String> addschoolsubject(@RequestBody SchoolSubject schoolSubject) {
        return new ResponseEntity<>(schoolSubjectService.createSchoolSubject(schoolSubject), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/schoolsubject")
    public ResponseEntity<String> getschoolsubject() {
        return new ResponseEntity<>(schoolSubjectService.getSchoolSubject(), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/schoolsubject/{schoolsubjectid}")
    public ResponseEntity<String> getschoolsubject(@PathVariable Long schoolsubjectid) {
        return new ResponseEntity<>(schoolSubjectService.getSchoolSubject(schoolsubjectid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @DeleteMapping("/schoolsubject/{schoolsubjectid}")
    public ResponseEntity<String> deleteschoolsubject(@PathVariable Long schoolsubjectid) {
        return new ResponseEntity<>(schoolSubjectService.deleteSchoolSubject(schoolsubjectid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @PutMapping("/schoolsubject")
    public ResponseEntity<String> updateschoolsubject(@RequestBody SchoolSubject schoolSubject) {
        return new ResponseEntity<>(schoolSubjectService.updateSchoolSubject(schoolSubject), HttpStatus.OK);
    }
}
