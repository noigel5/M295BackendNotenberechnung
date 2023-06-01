package ch.ilv.notenberechnung.schoolsubject;

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
public class SchoolSubjectController {

    private final SchoolSubjectService schoolSubjectService;
    SchoolSubjectController(SchoolSubjectService schoolSubjectService1) {
        this.schoolSubjectService = schoolSubjectService1;
    }

    @RolesAllowed(Roles.Admin)
    @PostMapping("/schoolsubject")
    @Operation(summary = "Fach hinzufügen", description = "Fügt ein Fach einem Semester hinzu, dafür ist die Semester Id nötig. Fach Id ist nicht notwendig")
    public ResponseEntity<SchoolSubject> addschoolsubject(@RequestBody SchoolSubject schoolSubject) {
        return new ResponseEntity<>(schoolSubjectService.createSchoolSubject(schoolSubject), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/schoolsubject")
    @Operation(summary = "Fächer ausgeben", description = "Gibt alle Fächer aus")
    public ResponseEntity<List<SchoolSubject>> getschoolsubject() {
        return new ResponseEntity<>(schoolSubjectService.getSchoolSubject(), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/schoolsubject/{schoolsubjectid}")
    @Operation(summary = "bestimmtes Fach ausgeben", description = "Id des Fachs eingeben, um das bestimmte Fach zu bekommen")
    public ResponseEntity<SchoolSubject> getschoolsubject(@PathVariable Long schoolsubjectid) {
        return new ResponseEntity<>(schoolSubjectService.getSchoolSubject(schoolsubjectid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/schoolsubjectbysemester/{semesterid}")
    @Operation(summary = "bestimmtes Fach ausgeben", description = "Id des Fachs eingeben, um das bestimmte Fach zu bekommen")
    public ResponseEntity<List<SchoolSubject>> getSchoolSubjectBySemesterId(@PathVariable Long semesterid) {
        return new ResponseEntity<>(schoolSubjectService.getSchoolSubjectBySemester(semesterid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @DeleteMapping("/schoolsubject/{schoolsubjectid}")
    @Operation(summary = "Fach löschen", description = "Id des Fachs eingeben, um es zu löschen")
    public ResponseEntity<SchoolSubject> deleteschoolsubject(@PathVariable Long schoolsubjectid) {
        return new ResponseEntity<>(schoolSubjectService.deleteSchoolSubject(schoolsubjectid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @PutMapping("/schoolsubject")
    @Operation(summary = "Fach bearbeiten", description = "id des Fachs eingeben und der Rest, um es direkt nach den Angaben zu bearbeiten")
    public ResponseEntity<SchoolSubject> updateschoolsubject(@RequestBody SchoolSubject schoolSubject) {
        return new ResponseEntity<>(schoolSubjectService.updateSchoolSubject(schoolSubject), HttpStatus.OK);
    }
}
