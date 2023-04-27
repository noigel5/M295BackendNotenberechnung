package ch.ilv.notenberechnung.semester;

import ch.ilv.notenberechnung.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "bearerAuth")
@RestController
public class SemesterController {
    private final SemsterService semesterService;
    SemesterController(SemsterService semesterService) {
        this.semesterService = semesterService;
    }

    @RolesAllowed(Roles.Admin)
    @PostMapping("/semester")
    public ResponseEntity<String> createsemester(@RequestBody String semester) {
        return new ResponseEntity<>(semesterService.createSemester(semester), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/semester")
    public ResponseEntity<String> getsemester() {
        return new ResponseEntity<>(semesterService.getSemester(), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/semester/{semesterid}")
    public ResponseEntity<String> getsemester(@PathVariable Long semesterid) {
        return new ResponseEntity<>(semesterService.getSemester(semesterid), HttpStatus.OK);
    }

    @RolesAllowed(Roles.Admin)
    @DeleteMapping("/semester/{semesterid}")
    public ResponseEntity<String> deletesemester(@PathVariable Long semesterid) {
        return new ResponseEntity<>(semesterService.deleteSemester(semesterid), HttpStatus.OK);
    }
}
