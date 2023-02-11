import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {

    private final int EXCHANGE_COST = 2;

    //Returns the number of remaining stacks, where each stack trades two for one with its neighbour
    public int stacksProblem(int[] A) {
        List<Integer> result = new ArrayList<>();
        int nextStack = 0;
        int count = 0;
        boolean arrayNotFinished = true;

        do {
            int arrayValue = 0;

            try {
                arrayValue = A[count];
            } catch (ArrayIndexOutOfBoundsException e) {
                arrayNotFinished = false;
            }
            int stack = arrayValue + nextStack;

            if (stack % this.EXCHANGE_COST == 0) {
                nextStack = stack / this.EXCHANGE_COST;
                if (nextStack == 0) result.add(stack);
            } else if (stack > this.EXCHANGE_COST) {
                stack--;
                nextStack = stack / this.EXCHANGE_COST;
                result.add(1);
            } else if (stack == 1) {
                nextStack = 0;
                result.add(stack);
            }
            count++;
        } while (nextStack != 0 || arrayNotFinished);

        int sum = 0;
        for (Integer value : result) sum = sum + value;

        return sum;
    }

    //Gives the highest integer which does not contain consecutives number
    public int consecutiveNumberProblem(int N) {
        Character lastCharacter = null;
        boolean hasRepetitions = false;
        String numberString = null;

        do {
            N++;
            hasRepetitions = false;
            numberString = Integer.toString(N);
            for (Character character: numberString.toCharArray()) {
                if (character == lastCharacter) hasRepetitions = true;
                lastCharacter = character;
            }
        } while (hasRepetitions);

        return Integer.parseInt(numberString);
    }

    //Returns the fair index given two arrays, where their indexes sums accordingly to the index assumed to be fair are equal
    public int fairIndexProblem(int[] A, int[] B) {
        int fairIndex = 0;
        for (int i = 0; i < A.length; i++) {
            int firstSumA = 0;
            int secondSumA = 0;
            for (int j = 0; j < A.length; j++) {
                if (j <= i) {
                    if (j == 0) firstSumA = A[j];
                    else firstSumA += A[j];
                }
                if (A.length-1-j == i) break;
                secondSumA += A[A.length-1-j];
            }

            int firstSumB = 0;
            int secondSumB = 0;
            for (int j = 0; j < B.length; j++) {
                if (j <= i) {
                    if (j == 0) firstSumB = B[j];
                    else firstSumB += B[j];
                }
                if (B.length-1-j == i) break;
                secondSumB += B[B.length-1-j];
            }

            if (Objects.equals(firstSumA, secondSumA) && Objects.equals(firstSumA, firstSumB) && Objects.equals(firstSumA, secondSumB)
                && Objects.equals(secondSumA, firstSumB) && Objects.equals(secondSumA, secondSumB) && Objects.equals(firstSumB, secondSumB)) {
                fairIndex = i;
                break;
            }
        }

        return fairIndex;
    }
}
