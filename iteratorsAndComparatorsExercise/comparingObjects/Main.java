package iteratorsAndComparatorsExercise.comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Person> persons = new ArrayList<>();

        while (!line.equals("END")) {

            String[] tokens = line.split("\\s+");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

            persons.add(person);

            line = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());

        Person personToCompare = persons.get(n);

        int equals = 0;
        int diff = 0;
        for (Person person : persons) {
            int result = personToCompare.compareTo(person);
            if (result == 0) {
                equals++;
            } else {
                diff++;
            }
        }
        if (equals == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(equals + " " + diff + " " + persons.size());
        }
    }
}
