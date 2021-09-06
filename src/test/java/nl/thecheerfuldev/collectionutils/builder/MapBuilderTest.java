package nl.thecheerfuldev.collectionutils.builder;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MapBuilderTest {

    @Test
    void builder_creates_map_with_same_content() {
        Map<String, Integer> actual = new MapBuilder<String, Integer>()
                .put("A", 1)
                .put("B", 2)
                .build();

        Map<String, Integer> expected = Map.of("A", 1, "B", 2);

        assertThat(actual).containsExactlyEntriesOf(expected);
    }

    @Test
    void builder_with_initial_map_creates_map_with_same_content() {
        Map<String, Integer> initial = Map.of("A", 1, "B", 2);

        Map<String, Integer> actual = new MapBuilder<>(initial)
                .put("C", 3)
                .put("D", 4)
                .build();

        Map<String, Integer> expected = Map.of("A", 1, "B", 2, "C", 3, "D", 4);

        assertThat(actual).containsExactlyEntriesOf(expected);
    }
}