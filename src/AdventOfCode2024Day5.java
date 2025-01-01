import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AdventOfCode2024Day5 {

    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("src/input");
        String input = new String(is.readAllBytes());

        String[] lines = input.split("\r\n");

        List<Map.Entry<Integer, Integer>> rules = new ArrayList<>();

        List<List<Integer>> updates = new ArrayList<>();
        int updateStartPos = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].isEmpty()) {
                updateStartPos = i + 1;
                break;
            }

            String[] pair = lines[i].split("\\|");

            rules.add(Map.entry(Integer.valueOf(pair[0]), Integer.valueOf(pair[1])));

        }

        updates = Arrays.stream(Arrays.copyOfRange(lines, updateStartPos, lines.length))
                        .map(line -> Arrays.stream(line.split(","))
                                         .map(Integer::valueOf)
                                         .toList())
                        .toList();

        List<Integer> validUpdates = new ArrayList<>();
        List<Integer> invalidUpdates = new ArrayList<>();

        for (int i = 0; i < updates.size(); i++) {
            // List<Map.Entry<Integer, Integer>> applicableRules = new ArrayList<>();
            boolean ok = true;
            for (Map.Entry<Integer, Integer> rule : rules) {
                if (updates.get(i).contains(rule.getKey()) && updates.get(i).contains(rule.getValue())) {
                    int idx1 = 0;
                    int idx2 = 0;

                    idx1 = updates.get(i).indexOf(rule.getKey());
                    idx2 = updates.get(i).indexOf(rule.getValue());

                    if (idx1 < idx2) {
                        continue;
                    }
                    else {
                        invalidUpdates.add(i);
                        ok = false;
                        break;
                    }
                }

            }
            if (ok)
                validUpdates.add(i);
        }

        //System.out.println(validUpdates);
        // Part 1: Get middle nums of all valid updates
        int sum = 0;
        for (int validIdx : validUpdates) {
            sum += updates.get(validIdx).get(updates.get(validIdx).size() / 2);
        }

        System.out.println("Part 1: " + sum);

        // Part 2: Fix invalid updates then get middle num
        int sum2 = 0;
        for (int invalidIdx : invalidUpdates) {
            List<Integer> update = new ArrayList<>(updates.get(invalidIdx));
            for (int i = 0; i < rules.size(); i++) {
                int key = rules.get(i).getKey();
                int value = rules.get(i).getValue();

                // apply rule if both nums are in the list
                if (update.contains(key) && update.contains(value)) {
                    int idx1 = 0;
                    int idx2 = 0;

                    idx1 = update.indexOf(key);
                    idx2 = update.indexOf(value);

                    if (idx1 > idx2) {
                        int temp = update.get(idx1);
                        update.set(idx1, update.get(idx2));
                        update.set(idx2, temp);
                        i = 0;
                    }



                }
            }
            sum2 += update.get(update.size() / 2);
            //System.out.println(update);
        }

        System.out.println("Part 2: " + sum2);
    }
}
