public class Node {
    public int[][] state = new int[3][3];
    public Node parent;
    public Node up;
    public Node down;
    public Node left;
    public Node right;
    int cost, h, f;
    String move;
    public Node(int[][] state) {
        this.state = state;
        this.parent = null;
        this.up = null;
        this.down = null;
        this.left = null;
        this.right = null;
        this.cost = 0;
        this.h = 0;
        this.f = 0;
        this.move = "ROOT";
    }
    public Node(int[][] state, Node parent, String move, int h) {
        this.state = state;
        this.parent = parent;
        this.up = null;
        this.down = null;
        this.left = null;
        this.right = null;
        this.cost = parent.cost + 1;
        this.h = h;
        this.f = this.cost + h;
        this.move = move;
    }
}