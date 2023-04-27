package ch.ilv.notenberechnung.grade;

import ch.ilv.notenberechnung.schoolsubject.SchoolSubject;
import ch.ilv.notenberechnung.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "bearerAuth")
@RestController
public class GradeController {

    private final GradeService gradeService;
    GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @RolesAllowed(Roles.Admin)
    @PostMapping("/grade")
    public ResponseEntity<String> addgrade(@RequestBody Grade grade) {
        return new ResponseEntity<>(gradeService.addGrade(grade), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/grade")
    public ResponseEntity<String> getgrade() {
        return new ResponseEntity<>(gradeService.getgrade(), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/grade/{gradeid}")
    public ResponseEntity<String> getgrade(@PathVariable Long gradeid) {
        return new ResponseEntity<>(gradeService.getgrade(gradeid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @DeleteMapping("/grade/{gradeid}")
    public ResponseEntity<String> deletegrade(@PathVariable Long gradeid) {
        return new ResponseEntity<>(gradeService.deletegrade(gradeid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @PutMapping("/grade")
    public ResponseEntity<String> updategrade(@RequestBody Grade grade) {
        return new ResponseEntity<>(gradeService.updateGrade(grade), HttpStatus.OK);
    }
}
