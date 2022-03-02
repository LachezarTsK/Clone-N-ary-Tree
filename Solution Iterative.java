
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {

    class Pair {
        Node original;
        Node clone;

        public Pair(Node original, Node clone) {
            this.original = original;
            this.clone = clone;
        }
    }

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Pair> queue = new LinkedList<>();
        Node clonedRoot = new Node(root.val);
        queue.add(new Pair(root, clonedRoot));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();
            List<Node> children = current.original.children;
            List<Node> clonedChildren = current.clone.children;

            for (Node node : children) {
                Node clonedNode = new Node(node.val);
                clonedChildren.add(clonedNode);
                queue.add(new Pair(node, clonedNode));
            }
        }
        return clonedRoot;
    }
}

class Node {

    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
