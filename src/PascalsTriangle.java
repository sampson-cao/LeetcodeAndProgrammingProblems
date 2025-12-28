import java.util.*;

public class PascalsTriangle {

    public static List<List<Integer>> pascalsTriangle (int numRows) {

        List<List<Integer>> pascals = new ArrayList<>();
        List<Integer> currRow = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();

        if (numRows > 0) {
            prevRow.add(1);
            pascals.add(new ArrayList<>(prevRow));
        }
        if (numRows > 1) {
            prevRow.add(1);
            pascals.add(new ArrayList<>(prevRow));
        }

        for (int i = 3; i <= numRows; i++) {
            currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 0; j < prevRow.size() - 1; j++) {

                currRow.add(prevRow.get(j) + prevRow.get(j+1));

            }
            currRow.add(1);
            //System.out.println("curr row: " + currRow);
            pascals.add(new ArrayList<>(currRow));
            prevRow = currRow;
        }

        return pascals;
    }

    public static List<Integer> pascalsTriangle2 (int rowIndex) {
        List<Integer> currRow = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {

            currRow.add(1);
            for (int j = currRow.size() - 2; j > 0; j--) {
                currRow.set(j, currRow.get(j) + currRow.get(j - 1));

            }
            //System.out.println(currRow);
        }

        return currRow;
    }

    public static void main (String[] args) {
        System.out.println(pascalsTriangle2(5));
    }

}
