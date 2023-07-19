import java.util.Scanner;

public class PuzzleSolver {
    public static void main(String[] args) {
        System.out.println("Puzzle Solver");
        int[][] initstate = new int[3][3];

        System.out.println("Select a puzzle to solve:");
        System.out.println("1. Trivial");
        System.out.println("2. Very Easy");
        System.out.println("3. Easy");
        System.out.println("4. Doable");
        System.out.println("5. Hard");
        System.out.println("6. Impossible");
        System.out.println("7. Enter your own puzzle");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.close();
        
        switch (choice) {
            case 1:
                initstate = new int[][]{{1, 2, 3}, 
                                        {4, 5, 6}, 
                                        {7, 8, 0}};
                break;
            case 2:
                initstate = new int[][]{{1, 2, 3}, 
                                        {4, 5, 6}, 
                                        {7, 0, 8}};
                break;
            case 3:
                initstate = new int[][]{{1, 2, 0}, 
                                        {4, 5, 3}, 
                                        {7, 8, 6}};
                break;
            case 4:
                initstate = new int[][]{{0, 1, 2}, 
                                        {4, 5, 3}, 
                                        {7, 8, 6}};
                break;
            case 5:
                initstate = new int[][]{{8, 7, 1}, 
                                        {6, 0, 2}, 
                                        {5, 4, 3}};
                break;
            case 6:
                initstate = new int[][]{{1, 2, 3}, 
                                        {4, 5, 6}, 
                                        {8, 7, 0}};
                break;
            case 7:
                System.out.println("Enter your puzzle, use a zero to represent the blank");
                System.out.println("Enter the first row, use space or tabs between numbers");
                int[] row1 = new int[3];
                for (int i = 0; i < 3; i++) {
                    row1[i] = scanner.nextInt();
                }
                System.out.println("Enter the second row, use space or tabs between numbers");
                int[] row2 = new int[3];
                for (int i = 0; i < 3; i++) {
                    row2[i] = scanner.nextInt();
                }
                System.out.println("Enter the third row, use space or tabs between numbers");
                int[] row3 = new int[3];
                for (int i = 0; i < 3; i++) {
                    row3[i] = scanner.nextInt();
                }
                initstate = new int[][]{row1, row2, row3};
                break;
            default:
                System.out.println("Invalid choice");
                break;
            }

        Problem problem = new Problem(initstate, choice);
        Search.AStarSearch(problem);
    }
}
