package ch.ilv.notenberechnung.calculator;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "bearerAuth")
@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;
    CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculator")
    public ResponseEntity<Double> calculate(@RequestBody Calculator calculator) {
        return new ResponseEntity<>(calculatorService.calculate(calculator), HttpStatus.OK);
    }

    @GetMapping("/calculator/{subjectid}")
    public ResponseEntity<Double> AVGSubject(@PathVariable Long subjectid) {
        return new ResponseEntity<>(calculatorService.AvgSubject(subjectid), HttpStatus.OK);
    }

    @GetMapping("/calculators/{semesterid}")
    public ResponseEntity<Double> AVGSemester(@PathVariable Long semesterid) {
        return new ResponseEntity<>(calculatorService.AvgSemester(semesterid), HttpStatus.OK);
    }
}
