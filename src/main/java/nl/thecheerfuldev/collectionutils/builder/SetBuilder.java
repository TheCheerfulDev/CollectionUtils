package nl.thecheerfuldev.collectionutils.builder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SetBuilder<T> {

    private final Set<T> set;

    public SetBuilder() {
        set = new HashSet<>();
    }

    public SetBuilder(T input) {
        this();
        set.add(input);
    }

    public SetBuilder(Collection<? extends T> input) {
        this();
        set.addAll(input);
    }

    public static <T> SetBuilder<T> builder(T input) {
        return new SetBuilder<>(input);
    }

    public static <T> SetBuilder<T> builder(Collection<? extends T> input) {
        return new SetBuilder<>(input);
    }

    public SetBuilder<T> add(T input) {
        set.add(input);
        return this;
    }

    public Set<T> build() {
        return Set.copyOf(set);
    }
}
