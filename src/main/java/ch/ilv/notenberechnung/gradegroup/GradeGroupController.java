package ch.ilv.notenberechnung.gradegroup;

import ch.ilv.notenberechnung.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "bearerAuth")
@RestController
public class GradeGroupController {

    private final GradeGroupService gradeGroupService;
    GradeGroupController(GradeGroupService gradeGroupService1) {
        this.gradeGroupService = gradeGroupService1;
    }

    @RolesAllowed(Roles.Admin)
    @PostMapping("/creategroup")
    public String creategroup(@RequestBody String groupname) {
        return gradeGroupService.createGroup(groupname);
    }

    @RolesAllowed(Roles.Read)
    @GetMapping("/getgroup")
    public String getgroup() {
        return gradeGroupService.getGroup();
    }

    @RolesAllowed(Roles.Admin)
    @PostMapping("/deletegroup")
    public String deletegroup(@RequestBody long groupid) {
        return gradeGroupService.deleteGroup(groupid);
    }
}
