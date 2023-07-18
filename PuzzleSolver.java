public class PuzzleSolver {
    public static void main(String[] args) {
        System.out.println("Puzzle Solver");
        int[][] initstate = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Problem problem = new Problem(initstate, 4);
        Search.AStarSearch(problem);
    }
}
