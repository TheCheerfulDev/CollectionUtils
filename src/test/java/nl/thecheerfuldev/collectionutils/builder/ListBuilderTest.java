package nl.thecheerfuldev.collectionutils.builder;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListBuilderTest {

    @Test
    void builder_creates_set_with_same_content() {
        List<String> actual = new ListBuilder<String>()
                .add("A")
                .add("B")
                .add("C")
                .build();

        List<String> expected = List.of("A", "B", "C");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void builder_with_initial_set_creates_set_with_same_content() {
        List<String> initial = List.of("A", "B", "C");

        List<String> actual = new ListBuilder<>(initial)
                .add("D")
                .add("E")
                .add("F")
                .build();

        List<String> expected = List.of("A", "B", "C", "D", "E", "F");

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
