package nl.thecheerfuldev.collectionutils.difference;

import java.util.List;

public class Lists {

    public static <T> List<T> intersection(List<T> list1, List<T> list2) {
        return List.copyOf(CollectionsUtil.intersection(list1, list2));
    }

    public static <T> List<T> symmetric(List<T> list1, List<T> list2) {
        return List.copyOf(CollectionsUtil.symmetric(list1, list2));
    }

    public static <T> List<T> difference(List<T> list1, List<T> list2) {
        return List.copyOf(CollectionsUtil.difference(list1, list2));
    }

    public static <T> List<T> union(List<T> list1, List<T> list2) {
        return List.copyOf(CollectionsUtil.union(list1, list2));
    }

}
