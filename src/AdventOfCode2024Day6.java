import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AdventOfCode2024Day6 {

    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("src/input");
        String input = new String(is.readAllBytes());
        String[] lines = input.split("\r\n");

        char[][] grid = new char[lines[0].length()][lines.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = lines[i].charAt(j);
            }
        }

        System.out.println(grid.length);
        System.out.println(grid[0].length);

        // Get initial position
        Direction dir = Direction.UP;

        int x = 0;
        int y = 0;

        int loops = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '^') {
                    x = j;
                    y = i;
                    grid[i][j] = 'X';
                }
            }
        }

        printGrid(grid);
        System.out.println("x: " + x + " y: " + y);

        // traverse
        int i = y, j = x;
        while (true) {
            switch(dir) {
                case UP:
                    i--;
                    break;
                case DOWN:
                    i++;
                    break;
                case LEFT:
                    j--;
                    break;
                case RIGHT:
                    j++;
                    break;
            }

            if ((i < 0 || i >= grid.length) || (j < 0 || j > grid[0].length)) {
                break;
            }

            // backtrack if moving makes us hit an obstacle
            if (grid[i][j] == '#') {
                if (dir == Direction.UP) {
                    i++;
                }
                else if (dir == Direction.DOWN) {
                    i--;
                }
                else if (dir == Direction.LEFT) {
                    j++;
                }
                else if (dir == Direction.RIGHT) {
                    j--;
                }
                dir = turnRight(dir);
            }
            else { // part 2: check for loops
                if (grid[i][j] == 'X') {
                    int tempi = i;
                    int tempj = j;
                    if (dir == Direction.UP) {
                        while (j < grid[0].length && grid[i][tempj] == 'X') {
                            tempj++;
                            if (grid[i][tempj] == '#') {
                                loops++;
                                break;
                            }
                        }
                    }
                    else if (dir == Direction.RIGHT) {
                        while (j < grid[0].length && grid[tempi][j] == 'X') {
                            tempi++;
                            if (grid[tempi][j] == '#') {
                                loops++;
                                break;
                            }
                        }
                    }
                    else if (dir == Direction.DOWN) {
                        while (j < grid[0].length && grid[i][tempj] == 'X') {
                            tempj--;
                            if (grid[i][tempj] == '#') {
                                loops++;
                                break;
                            }
                        }
                    }
                    else if (dir == Direction.LEFT) {
                        while (j < grid[0].length && grid[tempi][j] == 'X') {
                            tempi--;
                            if (grid[tempi][j] == '#') {
                                loops++;
                                break;
                            }
                        }
                    }
                    System.out.println("x: " + j + " y: " + i);
                    printGrid(grid);
                }
                // mark as traversed (part 1 & 2)
                grid[i][j] = 'X';
            }

            //System.out.println(dir);
            //printGrid(grid);
            //System.out.println();
        }

        System.out.println("Steps travelled: " + countSteps(grid));
        System.out.println("Loops: " + loops);
    }

    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static int countSteps(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public static Direction turnRight(Direction dir) {
        if (dir == Direction.UP) {
            return Direction.RIGHT;
        }
        else if (dir == Direction.RIGHT) {
            return Direction.DOWN;
        }
        else if (dir == Direction.DOWN) {
            return Direction.LEFT;
        }
        else if (dir == Direction.LEFT) {
            return Direction.UP;
        }
        else {
            System.out.println("Error");
            return Direction.UP;
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}


