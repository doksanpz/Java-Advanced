package examPreparation_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02treasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = dimensions[0];
        int m = dimensions[1];

        char[][] map = new char[n][];

        //пълним матрицата като махаме празните пространства
        for (int i = 0; i < map.length; i++) {
            char[] row = scanner.nextLine().replace(" ", "").toCharArray();
            map[i] = row;
        }

        int x = -1;
        int y = -1;

        int t1 = -1;
        int t2 = -1;

        //намираме наща позиция и позицията на съкровището
        for (int i = 0; i < map.length; i++) {
            char[] chars = map[i];
            for (int j = 0; j < chars.length; j++) {
                char ch = chars[j];
                if (ch == 'Y') {
                    x = i;
                    y = j;
                }
                if (ch == 'X') {
                    t1 = i;
                    t2 = j;
                }
            }
        }

        List<String> path = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    if (x > 0) {
                        char pos = map[--x][y];
                        if (pos == 'T') {
                            x++;
                        } else {
                            path.add(command);
                        }
                    }
                    break;
                case "down":
                    if (x < map.length - 1) {
                        char pos = map[++x][y];
                        if (pos == 'T') {
                            x--;
                        } else {
                            path.add(command);
                        }
                    }
                    break;
                case "right":
                    if (y < m - 1) {
                        char pos = map[x][++y];
                        if (pos == 'T') {
                            y--;
                        } else {
                            path.add(command);
                        }
                    }
                    break;
                case "left":
                    if (y > 0) {
                        char pos = map[x][--y];
                        if (pos == 'T') {
                            y++;
                        } else {
                            path.add(command);
                        }
                    }
                    break;

            }
            command = scanner.nextLine();
        }
        if (x == t1 && y == t2) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            String move = String.join(", ", path);
            System.out.println(move);
        } else {
            System.out.println("The map is fake!");
        }
    }
}
