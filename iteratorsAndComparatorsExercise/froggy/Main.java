package iteratorsAndComparatorsExercise.froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Integer[] collection = Arrays.stream(line.split("[\\s,]+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Lake lake = new Lake(collection);

        Iterator<Integer> iterator = lake.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
