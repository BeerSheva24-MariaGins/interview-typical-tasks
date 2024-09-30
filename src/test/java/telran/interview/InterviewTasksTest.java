package telran.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.interview.InterviewTasks.*;

import org.junit.jupiter.api.Test;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        int[] arr = { 1, 2, 3 };
        assertTrue(hasSumTwo(arr, 5));
        assertFalse(hasSumTwo(arr, 6));
    }
}