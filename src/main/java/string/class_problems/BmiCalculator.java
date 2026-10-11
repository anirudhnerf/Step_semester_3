package string.class_problems;

import java.util.Random;

public class BmiCalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s %-12s %-12s %-8s %s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-8d %-12.2f %-12.1f %-8.2f %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        int team = 10;
        double[] heights = new double[team];
        double[] weights = new double[team];
        Random random = new Random();

        // Random values for a quick demo: height 1.50-2.00 m, weight 45-110 kg
        for (int i = 0; i < team; i++) {
            heights[i] = Math.round((1.5 + random.nextDouble() * 0.5) * 100) / 100.0;
            weights[i] = 45 + random.nextInt(66);
        }

        printWellnessReport(heights, weights);
    }
}