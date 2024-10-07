package telran.interview;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        int sum1 = 8;
        int sum2 = Integer.MIN_VALUE;
        int[] arTrue1 = { 1, 2, 3, 4, 4 };
        int[] arTrue2 = { 1, 2, 3, 4, Integer.MAX_VALUE };
        int[] arFalse = { 1, 2, 3, 10, 10 };
        assertTrue(InterviewTasks.hasSumTwo(arTrue1, sum1));
        assertTrue(InterviewTasks.hasSumTwo(arTrue2, sum2));
        assertFalse(InterviewTasks.hasSumTwo(arFalse, sum1));
    }
}