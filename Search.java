import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Search {
    //define node comparator
    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node x, Node y) {
            if (x.f < y.f) {
                return -1;
            }
            if (x.f > y.f) {
                return 1;
            }
            return 0;
        }
    }
    // euclidean distance
    public static int h(int[][] state, int[][] goalstate) {
        int h = 0;
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                int value = state[i][j];
                if (value != 0) {
                    for (int k = 0; k < goalstate.length; k++) {
                        for (int l = 0; l < goalstate.length; l++) {
                            if (value == goalstate[k][l]) {
                                h += Math.abs(i - k) + Math.abs(j - l);
                            }
                        }
                    }
                }
            }
        }
        return h;
    }
    // helper function to print state
    public static void printState(int[][] state) {
        System.out.println("---------");
        for (int i = 0; i < state.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < state.length; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    
    // A* search algorithm using euclidean distance that takes in a problem and prints the path to the goal
    public static void AStarSearch(Problem problem) {
        int count = 0;
        PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        Node root = new Node(problem.initstate);
        if (Arrays.deepEquals(root.state,problem.goalstate)) {
            printState(root.state);
            return;
        }

        root.h = h(root.state, problem.goalstate);
        root.f = root.cost + root.h;
        frontier.add(root);
        
        int[][] upstate = problem.up(root.state);
        int[][] downstate = problem.down(root.state);
        int[][] leftstate = problem.left(root.state);
        int[][] rightstate = problem.right(root.state);

        Node up = new Node(upstate, root, "UP", h(upstate, problem.goalstate));
        Node down = new Node(downstate, root, "DOWN", h(downstate, problem.goalstate));
        Node left = new Node(leftstate, root, "LEFT", h(leftstate, problem.goalstate));
        Node right = new Node(rightstate, root, "RIGHT", h(rightstate, problem.goalstate));

        root.up = up;
        root.down = down;
        root.left = left;
        root.right = right;

        visited.put(Arrays.deepToString(up.state), true);
        visited.put(Arrays.deepToString(down.state), true);
        visited.put(Arrays.deepToString(left.state), true);
        visited.put(Arrays.deepToString(right.state), true);

        // add all children to frontier
        frontier.add(up);
        frontier.add(down);
        frontier.add(left);
        frontier.add(right);

        while (!frontier.isEmpty()) {
            Node node = frontier.poll();
            count++;
            System.out.println("The best state to expand with a g(n) = " + node.cost + " and h(n) = " + node.h + " is...");
            printState(node.state);
            System.out.println(node.move);
            System.out.println("Expanding this node...");
            System.out.println();

            if (Arrays.deepEquals(node.state,problem.goalstate)) {
                System.out.println("Goal!!!");
                System.out.println("Expanded a total of " + count + " nodes.");
                return;
            }

            upstate = problem.up(node.state);
            downstate = problem.down(node.state);
            leftstate = problem.left(node.state);
            rightstate = problem.right(node.state);

            if (!visited.containsKey(Arrays.deepToString(upstate))) {
                up = new Node(upstate, root, "UP", h(upstate, problem.goalstate));
                node.up = up;
                visited.put(Arrays.deepToString(up.state), true);
                frontier.add(up);
            }
            if (!visited.containsKey(Arrays.deepToString(downstate))) {
                down = new Node(downstate, root, "DOWN", h(downstate, problem.goalstate));
                node.down = down;
                visited.put(Arrays.deepToString(down.state), true);
                frontier.add(down);
            }
            if (!visited.containsKey(Arrays.deepToString(leftstate))) {
                left = new Node(leftstate, root, "LEFT", h(leftstate, problem.goalstate));
                node.left = left;
                visited.put(Arrays.deepToString(left.state), true);
                frontier.add(left);
            }
            if (!visited.containsKey(Arrays.deepToString(rightstate))) {
                right = new Node(rightstate, root, "RIGHT", h(rightstate, problem.goalstate));
                node.right = right;
                visited.put(Arrays.deepToString(right.state), true);
                frontier.add(right);
            }
        }
        System.out.println("No solution found");
    }

}
