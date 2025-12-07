package tsygvintsev;

public interface Reduction<T> {
    T reduction(T result, T value);
}
