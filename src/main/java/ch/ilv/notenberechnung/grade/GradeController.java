package ch.ilv.notenberechnung.grade;

import ch.ilv.notenberechnung.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "bearerAuth")
@RestController
public class GradeController {

    private final GradeService gradeService;
    GradeController(GradeService gradeService1) {
        this.gradeService = gradeService1;
    }

    @RolesAllowed(Roles.Admin)
    @PostMapping("/grade")
    public String addgrade(@RequestBody Grade grade) {
        return gradeService.addGrade(grade);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/grade")
    public String getgrade() {
        return gradeService.getgrade();
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/grade/{gradeid}")
    public String getgrade(@PathVariable Long gradeid) {
        return gradeService.getgrade(gradeid);
    }

    @RolesAllowed(Roles.Admin)
    @DeleteMapping("/grade/{gradeid}")
    public String deletegrade(@PathVariable Long gradeid) {
        return gradeService.deletegrade(gradeid);
    }
}
