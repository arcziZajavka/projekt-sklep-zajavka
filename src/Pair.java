public class Pair<U, V> {
    private final U u;
    private final V v;

    public Pair(U u, V v) {
        this.u = u;
        this.v = v;
    }

    public U getU() {
        return u;
    }

    public V getV() {
        return v;
    }

    @Override
    public String toString() {
        return u+ "| ilość sprzedanych: "+ v;
    }
}
