
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        Node clonedNode = new Node(root.val);
        for (Node node : root.children) {
            clonedNode.children.add(cloneTree(node));
        }
        return clonedNode;
    }
}

// Class Node is in-built in the solution file on leetcode.com. 
// When running the code on the website, do not include this class.
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
