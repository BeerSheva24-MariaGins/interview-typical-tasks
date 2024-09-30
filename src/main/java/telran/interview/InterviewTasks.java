package telran.interview;

import java.util.HashSet;
import java.util.Set;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *         summing of which gives the value equaled to a given "sum" value
     */
   
    static public boolean hasSumTwo(int[] array, int sum) {
    Set<Integer> seenNumbers = new HashSet<>();
    boolean flag = false;

    for (int num : array) {
        int target = sum - num;           

        if (seenNumbers.contains(target)) {
            flag = true;
        }        
        seenNumbers.add(num);
    }    
    return flag;
}
}