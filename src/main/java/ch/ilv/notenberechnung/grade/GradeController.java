package ch.ilv.notenberechnung.grade;

import ch.ilv.notenberechnung.security.Roles;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
@RestController
public class GradeController {

    private final GradeService gradeService;
    GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @RolesAllowed(Roles.Admin)
    @PostMapping("/grade")
    @Operation(summary = "Note hinzufügen", description = "Fügt Noten einem Fach hinzu, dafür ist die Fach Id nötig. Id der Note ist nicht notwendig")
    public ResponseEntity<String> addgrade(@RequestBody Grade grade) {
        return new ResponseEntity<>(gradeService.addGrade(grade), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/grade")
    @Operation(summary = "Noten ausgeben", description = "Gibt alle Noten aus")
    public ResponseEntity<List<Grade>> getgrade() {
        return new ResponseEntity<>(gradeService.getgrade(), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/grade/{gradeid}")
    @Operation(summary = "bestimmte Note ausgeben", description = "Id der bestimmten Note eingeben, um bestimmte Note zu bekommen")
    public ResponseEntity<String> getgrade(@PathVariable Long gradeid) {
        return new ResponseEntity<>(gradeService.getgrade(gradeid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/gradebyschoolsubjectid/{schoolsubjectid}")
    @Operation(summary = "bestimmte Note ausgeben", description = "Id der bestimmten schoolsubject eingeben, um bestimmte Note zu bekommen")
    public ResponseEntity<List<Grade>> getgradebyschoolsubjectid(@PathVariable Long schoolsubjectid) {
        return new ResponseEntity<>(gradeService.getGradeBySchoolSubjectId(schoolsubjectid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @DeleteMapping("/grade/{gradeid}")
    @Operation(summary = "Note löschen", description = "Id der Note eingeben, um sie zu löschen")
    public ResponseEntity<String> deletegrade(@PathVariable Long gradeid) {
        return new ResponseEntity<>(gradeService.deletegrade(gradeid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @PutMapping("/grade")
    @Operation(summary = "Noten bearbeiten", description = "id der Note eingeben und der Rest, um sie direkt nach den Angaben zu bearbeiten")
    public ResponseEntity<String> updategrade(@RequestBody Grade grade) {
        return new ResponseEntity<>(gradeService.updateGrade(grade), HttpStatus.OK);
    }
}
