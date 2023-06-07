public class Pair<T extends Comparable<T>, U> implements Comparable<Pair<T,U>>{
    private T first;
    private U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public U getSecond() {
        return second;
    }
    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public int compareTo(Pair<T, U>  o) {
        return this.first.compareTo(o.getFirst());
    }
}