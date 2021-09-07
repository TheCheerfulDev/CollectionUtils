package nl.thecheerfuldev.collectionutils.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListBuilder<T> {

    private final List<T> list;

    public ListBuilder() {
        list = new ArrayList<>();
    }

    public ListBuilder(T input) {
        this();
        list.add(input);
    }

    public ListBuilder(Collection<? extends T> input) {
        this();
        list.addAll(input);
    }

    public static <T> ListBuilder<T> builder(T input) {
        return new ListBuilder<>(input);
    }

    public static <T> ListBuilder<T> builder(Collection<? extends T> input) {
        return new ListBuilder<>(input);
    }

    public ListBuilder<T> add(T input) {
        list.add(input);
        return this;
    }

    public List<T> build() {
        return List.copyOf(list);
    }
}
