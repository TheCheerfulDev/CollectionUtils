package nl.thecheerfuldev.collectionutils.difference;

import java.util.Set;

public class Sets {

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        return Set.copyOf(CollectionsUtil.intersection(set1, set2));
    }

    public static <T> Set<T> symmetric(Set<T> set1, Set<T> set2) {
        return Set.copyOf(CollectionsUtil.symmetric(set1, set2));
    }

    public static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        return Set.copyOf(CollectionsUtil.difference(set1, set2));
    }

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        return Set.copyOf(CollectionsUtil.union(set1, set2));
    }

}
