package iteratorsAndComparators.bookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int titleCompare = o1.title().compareTo(o2.title());

        if (titleCompare != 0) {
            return titleCompare;
        }
        return o1.year() - o2.year();
    }
}
