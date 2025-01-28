package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }


        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] tokens = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token);
                if (num < 0) {
                    negatives.add(num);
                }
                sum += num;
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " + String.join(", ", negatives.stream().map(String::valueOf).toArray(String[]::new)));
        }
        return sum;
    }
}
