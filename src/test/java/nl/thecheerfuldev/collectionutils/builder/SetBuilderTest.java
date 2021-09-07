package nl.thecheerfuldev.collectionutils.builder;


import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetBuilderTest {

    @Test
    void builder_creates_set_with_same_content() {
        Set<String> actual = new SetBuilder<String>()
                .add("A")
                .add("B")
                .add("C")
                .build();

        Set<String> expected = Set.of("A", "B", "C");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void builder_method_creates_set_with_same_content() {
        Set<String> actual = SetBuilder.builder("A")
                .add("B")
                .add("C")
                .build();

        Set<String> expected = Set.of("A", "B", "C");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void builder_with_initial_set_creates_set_with_same_content() {
        Set<String> initial = Set.of("A", "B", "C");

        Set<String> actual = new SetBuilder<>(initial)
                .add("D")
                .add("E")
                .add("F")
                .build();

        Set<String> expected = Set.of("A", "B", "C", "D", "E", "F");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void builder_method_with_initial_set_creates_set_with_same_content() {
        Set<String> initial = Set.of("A", "B", "C");

        Set<String> actual = SetBuilder.builder(initial)
                .add("D")
                .add("E")
                .add("F")
                .build();

        Set<String> expected = Set.of("A", "B", "C", "D", "E", "F");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
