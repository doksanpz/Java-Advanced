package genericsExercise.genericCountMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            Box<String> box = new Box<>(data);
            boxes.add(box);
        }

        Box<String> boxToCompare = new Box<>(scanner.nextLine());

        int count = 0;
        for (Box box: boxes) {
            int res = box.compareTo(boxToCompare);
            if (res > 0) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
