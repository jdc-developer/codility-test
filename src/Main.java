public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] array = new int[]{4, 0, 3, 0};
        Solution solution = new Solution();
        System.out.println(solution.stacksProblem(array));

        System.out.println(solution.consecutiveNumberProblem(1765));

        int[] fairIndexArray1 = new int[]{1, 4, 2, -2, 5};
        int[] fairIndexArray2 = new int[]{7, -2, -2, 2, 5};
        System.out.println(solution.fairIndexProblem(fairIndexArray1, fairIndexArray2));
    }


}