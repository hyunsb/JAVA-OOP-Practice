package smartStore_FastCampus.util.arrays;

public interface Collections<T> {
    int size();
    T get(int index);
    T set(int index, T object);
    int indexOf(T object);
    void add(T object);
    void add(int index, T object);
    T pop();
    T pop(int index);
    T pop(T object);
}
