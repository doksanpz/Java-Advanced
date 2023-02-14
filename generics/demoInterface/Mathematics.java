package generics.demoInterface;

public interface Mathematics<T extends Number> {
    int multiplyBy2(T number);
}
