package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] tokens = numbers.split(",");
        int sum = 0;

        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token);

                sum += num;
            }
        }
        return sum;
    }
}
