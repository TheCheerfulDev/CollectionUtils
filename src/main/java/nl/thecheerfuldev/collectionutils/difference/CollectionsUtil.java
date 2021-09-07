package nl.thecheerfuldev.collectionutils.difference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class CollectionsUtil {

    static <T> Collection<T> intersection(Collection<T> c1, Collection<T> c2) {
        return c1.stream()
                .filter(c2::contains)
                .collect(Collectors.toUnmodifiableList());
    }

    static <T> Collection<T> symmetric(Collection<T> c1, Collection<T> c2) {
        Collection<T> copyCollection1 = new ArrayList<>(c1);
        Collection<T> copyCollection2 = new ArrayList<>(c2);

        copyCollection1.removeAll(c2);
        copyCollection2.removeAll(c1);

        Collection<T> result = new ArrayList<>();
        result.addAll(copyCollection1);
        result.addAll(copyCollection2);

        return List.copyOf(result);
    }

    static <T> Collection<T> difference(Collection<T> c1, Collection<T> c2) {
        List<T> copyCollection1 = new ArrayList<>(c1);
        copyCollection1.removeAll(c2);

        return List.copyOf(copyCollection1);
    }

    static <T> Collection<T> union(Collection<T> c1, Collection<T> c2) {
        List<T> result = new ArrayList<>(c1);
        result.addAll(c2);
        return List.copyOf(result);
    }

}
