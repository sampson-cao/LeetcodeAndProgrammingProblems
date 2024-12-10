import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Queue;

public class AdventOfCode2024Day3 {

    public static void main (String[] args) throws IOException {

        InputStream is = new FileInputStream("src/input");
        String input = new String(is.readAllBytes());
        input = input.replaceAll("\r\n", "");
        long sum = 0;
        boolean calc = true;
        for (int i = 0; i < input.length() - 7; i++) {
            String substr = input.substring(i, i + 7);
            if (substr.equals("don't()")) {
                calc = false;
                i += 7;
            }
            if (substr.contains("do()")) {
                calc = true;
                i += 4;
            }
            System.out.println(substr);
            if (substr.contains("mul") && calc) {
                System.out.println("multiply: " + substr);
                // grab the parameters of mul e.g. (123,456)
                String values;
                if (i + 12 > input.length()) {
                    values = input.substring(i + 3);
                }
                else {
                    values = input.substring(i + 3, i + 12);
                }
                System.out.println(values);

                i += values.length();

                if (values.matches(".*\\(\\d+,\\d+\\).*")) {
                    String cleanedValues = values.replaceAll("(?=[^,])(\\D+)", "");
                    String[] nums = cleanedValues.split(",");


                    int a = Integer.parseInt(nums[0]);
                    int b = Integer.parseInt(nums[1]);


                    System.out.println(substr+values + "   " + cleanedValues + " " + a + " " + b + " " + (a*b));
                    sum += (long) a * b;
                }

            }

        }

        System.out.println(sum);


    }
}
