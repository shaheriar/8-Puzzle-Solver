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
    // helper function to print path to goal
    public static void printPath(Node node) {
        if (node.move == "ROOT") {
            printState(node.state);
            return;
        }
        printPath(node.parent);
        printState(node.state);
        System.out.println(node.move);
    }
    // A* search algorithm using euclidean distance that takes in a problem and prints the path to the goal
    public static void AStarSearch(Problem problem) {
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
        Node up = new Node(problem.up(root.state), root, "UP", h(problem.up(root.state), problem.goalstate));
        Node down = new Node(problem.down(root.state), root, "DOWN", h(problem.down(root.state), problem.goalstate));
        Node left = new Node(problem.left(root.state), root, "LEFT", h(problem.left(root.state), problem.goalstate));
        Node right = new Node(problem.right(root.state), root, "RIGHT", h(problem.right(root.state), problem.goalstate));

        root.up = up;
        root.down = down;
        root.left = left;
        root.right = right;

        System.out.println(Arrays.deepToString(up.state));

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

            System.out.println("The best state to expand with a g(n) = " + node.cost + " and h(n) = " + node.h + " is...");
            printState(node.state);
            System.out.println("Expanding this node...");
            System.out.println();

            if (Arrays.deepEquals(node.state,problem.goalstate)) {
                System.out.println("Goal!!!");
                System.out.println("Printing path to goal...");
                printPath(node);
                return;
            }
            
            if (!visited.containsKey(Arrays.deepToString(problem.up(node.state)))) {
                up = new Node(problem.up(node.state), node, "UP", h(problem.up(node.state), problem.goalstate));
                node.up = up;
                visited.put(Arrays.deepToString(up.state), true);
                frontier.add(up);
            }
            if (!visited.containsKey(Arrays.deepToString(problem.down(node.state)))) {
                down = new Node(problem.down(node.state), node, "DOWN", h(problem.down(node.state), problem.goalstate));
                node.down = down;
                visited.put(Arrays.deepToString(down.state), true);
                frontier.add(down);
            }
            if (!visited.containsKey(Arrays.deepToString(problem.left(node.state)))) {
                left = new Node(problem.left(node.state), node, "LEFT", h(problem.left(node.state), problem.goalstate));
                node.left = left;
                visited.put(Arrays.deepToString(left.state), true);
                frontier.add(left);
            }
            if (!visited.containsKey(Arrays.deepToString(problem.left(node.state)))) {
                right = new Node(problem.right(node.state), node, "RIGHT", h(problem.right(node.state), problem.goalstate));
                node.right = right;
                visited.put(Arrays.deepToString(right.state), true);
                frontier.add(right);
            }
        }

    }

}
