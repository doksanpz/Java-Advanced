package iteratorsAndComparatorsExercise.froggy;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lake implements Iterable<Integer>{

    private Integer[] numbers;

    public Lake(Integer... numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

   private class Frog implements Iterator<Integer> {
        private int totalCount;
        private int evenNumbersStartIndex;
        private int oddNumbersStartIndex;
        private int counter;

       public Frog() {
           this.totalCount = 0;
           this.evenNumbersStartIndex = 0;
           this.oddNumbersStartIndex = 1;
           this.counter = 0;
       }

       private int getIndex() {
            int limit = numbers.length % 2 == 0 ? numbers.length / 2 - 1 : numbers.length / 2;
            if (counter <= limit) {
                this.counter++;
                this.totalCount++;
                int index = this.evenNumbersStartIndex;
                this.evenNumbersStartIndex += 2;
                return index;
            }
            this.counter++;
            this.totalCount++;
            int index = this.oddNumbersStartIndex;
            this.oddNumbersStartIndex += 2;
            return index;
        }

       @Override
       public boolean hasNext() {
           return totalCount < numbers.length;
       }

       @Override
       public Integer next() {
           if (this.hasNext()) {
               return numbers[this.getIndex()];
           }
           throw new NoSuchElementException();
       }
   }
}
