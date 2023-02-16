import java.util.ArrayList;
import java.util.List;

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
        char lastCharacter = 'a';
        boolean hasRepetitions = false;
        String numberString = null;

        do {
            N++;
            hasRepetitions = false;
            numberString = Integer.toString(N);
            for (int i = 0; i < numberString.length(); i++){
                char c = numberString.charAt(i);
                if (c == lastCharacter) hasRepetitions = true;
                lastCharacter = c;
            }
        } while (hasRepetitions);

        return Integer.parseInt(numberString);
    }

    //Returns the fair index given two arrays, where their indexes sums accordingly to the index assumed to be fair are equal
    public int fairIndexProblem(int[] A, int[] B) {
        int fairIndexes = 0;
        for (int i = 0; i < A.length; i++) {
            int firstSumA = 0;
            int secondSumA = 0;
            int firstSumB = 0;
            int secondSumB = 0;

            for (int j = 0; j < A.length; j++) {
                if (j <= i) {
                    if (j == 0) {
                        firstSumA = A[j];
                        firstSumB = B[j];
                    } else {
                        firstSumA += A[j];
                        firstSumB += B[j];
                    }
                }
                if (A.length-1-j == i) break;
                else {
                    secondSumA += A[A.length-1-j];
                    secondSumB += B[B.length-1-j];
                }
            }

            if (firstSumA == secondSumA && firstSumA == firstSumB && firstSumA == secondSumB
                    && secondSumA == firstSumB && secondSumA == secondSumB && firstSumB == secondSumB) fairIndexes++;
        }

        return fairIndexes;
    }
}
