package com.grades.notenberechnung.gradegroup;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradeGroupController {

    private final GradeGroupService gradeGroupService;
    GradeGroupController(GradeGroupService gradeGroupService1) {
        this.gradeGroupService = gradeGroupService1;
    }

    @PostMapping("/creategroup")
    public String creategroup(@RequestBody String groupname) {
        return gradeGroupService.createGroup(groupname);
    }

    @GetMapping("/getgroup")
    public String getgroup() {
        return gradeGroupService.getGroup();
    }

    @PostMapping("/deletegroup")
    public String deletegroup(@RequestBody long groupid) {
        return gradeGroupService.deleteGroup(groupid);
    }
}
