package genericsExercise.genericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(data);
            boxes.add(box);
        }

        List<Integer> indexes = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        swap(boxes, indexes.get(0), indexes.get(1));
        for (Box box : boxes) {
            System.out.println(box);
        }
    }
    public static <T> void swap(List<T> data, int firstIndex, int secondIndex) {
        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);

        data.set(firstIndex, secondElement);
        data.set(secondIndex, firstElement);
    }
}
