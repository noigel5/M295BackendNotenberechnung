package ch.ilv.notenberechnung.calculator;

import lombok.Data;

import java.util.List;

@Data
public class Calculator {
    private List<Double> grades;
    private double maxPoints;
    private double achievedPoints;
}
