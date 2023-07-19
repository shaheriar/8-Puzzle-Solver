import java.util.Arrays;

public class unitTest {
    //test up
    public static void testUp() {
        int[][] state = {{1, 2, 3}, 
                         {4, 5, 6}, 
                         {7, 8, 0}};
        int[][] expected = {{1, 2, 3}, 
                            {4, 5, 0}, 
                            {7, 8, 6}};
        Problem problem = new Problem(state, 4);
        int[][] actual = problem.up(state);
        System.out.println(Arrays.deepToString(actual));
        if (Arrays.deepEquals(actual, expected)) {
            System.out.println("testUp passed");
        } else {
            System.out.println("testUp failed");
        }
    }
    //test down
    public static void testDown() {
        int[][] state = {{1, 2, 3}, 
                         {4, 5, 6}, 
                         {7, 8, 0}};
        int[][] expected = {{1, 2, 3}, 
                            {4, 5, 6}, 
                            {7, 8, 0}};
        Problem problem = new Problem(state, 4);
        int[][] actual = problem.down(state);
        System.out.println(Arrays.deepToString(actual));
        if (Arrays.deepEquals(actual, expected)) {
            System.out.println("testDown passed");
        } else {
            System.out.println("testDown failed");
        }
    }
    //test left
    public static void testLeft() {
        int[][] state = {{1, 2, 3}, 
                         {4, 5, 6}, 
                         {7, 8, 0}};
        int[][] expected = {{1, 2, 3}, 
                            {4, 5, 6}, 
                            {7, 0, 8}};
        Problem problem = new Problem(state, 4);
        int[][] actual = problem.left(state);
        System.out.println(Arrays.deepToString(actual));
        if (Arrays.deepEquals(actual, expected)) {
            System.out.println("testLeft passed");
        } else {
            System.out.println("testLeft failed");
        }
    }
    //test right
    public static void testRight() {
        int[][] state = {{1, 2, 3}, 
                         {4, 5, 6}, 
                         {7, 8, 0}};
        int[][] expected = {{1, 2, 3}, 
                            {4, 5, 6}, 
                            {7, 8, 0}};
        Problem problem = new Problem(state, 4);
        int[][] actual = problem.right(state);
        System.out.println(Arrays.deepToString(actual));
        if (Arrays.deepEquals(actual, expected)) {
            System.out.println("testRight passed");
        } else {
            System.out.println("testRight failed");
        }
    }
    public static void main(String[] args) {
        testUp();
        testDown();
        testLeft();
        testRight();
    }
}
