package ch.ilv.notenberechnung.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(Calculator calculator) {
        if (calculator.getMaxPoints() == 0) {
            if (calculator.getAchievedPoints() == 0) {
                int listSize = calculator.getGrades().size();
                double AVG = 0;
                for (int i = 0; i < listSize; i++) {
                    AVG += calculator.getGrades().get(i);
                }
                return AVG/listSize;
            }
        }
         return calculator.getAchievedPoints() / calculator.getMaxPoints() * 5 + 1;
    }
}
