package genericsExercise.threeuple;

public class Threeuple<K, V1, V2> {
    private K key;
    private V1 value1;
    private V2 value2;

    public Threeuple(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    public K key() {
        return key;
    }

    public V1 value1() {
        return value1;
    }

    public V2 value2() {
        return value2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", key(), value1(), value2());
    }
}
