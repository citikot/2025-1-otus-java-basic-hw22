package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayServiceTest {

    private final ArrayService arrayService = new ArrayService();

    @Test
    void testModifyArrayWhenArrayIsEmpty() {
        int[] array = new int[]{};
        assertThrows(IllegalArgumentException.class, () -> arrayService.modifyArray(array));
    }

    @Test
    void testModifyArrayWhenArrayHasNoOne() {
        int[] array = new int[]{2, 2, 2, 2};
        assertThrows(IllegalArgumentException.class, () -> arrayService.modifyArray(array));
    }

    @Test
    void testModifyArrayWhenArrayHasOne() {
        int[] array = new int[]{1, 1, 1, 1};
        int[] result = arrayService.modifyArray(array);
        assertEquals(0, result.length);
    }

    @Test
    void testModifyArrayWhenArrayHasTwo() {
        int[] array = new int[]{1, 2, 1, 2};
        int[] result = arrayService.modifyArray(array);
        assertEquals(1, result.length);
        assertEquals(2, result[0]);
    }

    @Test
    void testModifyArrayWhenArrayHasThree() {
        int[] array = new int[]{1, 2, 1, 2, 1, 2, 3, 4};
        int[] result = arrayService.modifyArray(array);
        assertEquals(3, result.length);
    }

    @ParameterizedTest
    @MethodSource("provideArraysForIsFilledByOneTwoArray")
    void testIsFilledByOneTwoArray(int[] inputArray, boolean expected) {
        boolean result = arrayService.isFilledByOneTwoArray(inputArray);
        assertEquals(expected, result);
    }

    static Stream<Arguments> provideArraysForIsFilledByOneTwoArray() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2}, true),
                Arguments.of(new int[]{1, 1, 1, 1}, false),
                Arguments.of(new int[]{2, 2, 2, 2}, false),
                Arguments.of(new int[]{1, 2, 3}, false),
                Arguments.of(new int[]{}, false),
                Arguments.of(new int[]{1}, false),
                Arguments.of(new int[]{2}, false),
                Arguments.of(new int[]{1, 2}, true)
        );
    }


}
