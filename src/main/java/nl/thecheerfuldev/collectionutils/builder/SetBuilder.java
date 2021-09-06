package nl.thecheerfuldev.collectionutils.builder;

import java.util.HashSet;
import java.util.Set;

public class SetBuilder<T> {

    private final Set<T> set;

    public SetBuilder() {
        set = new HashSet<>();
    }

    public SetBuilder(Set<T> input) {
        this();
        set.addAll(input);
    }

    public SetBuilder<T> add(T input) {
        set.add(input);
        return this;
    }

    public Set<T> build() {
        return Set.copyOf(set);
    }
}
