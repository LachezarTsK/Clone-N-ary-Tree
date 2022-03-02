
#include <queue>
#include <vector>
using namespace std;

// Struct Node is in-built in the solution file on leetcode.com. 
// When running the code on the website, do not include this struct.

class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};

struct Pair {
    Node* original;
    Node* clone;

    Pair(Node* original, Node* clone) {
        this->original = original;
        this->clone = clone;
    }
};

class Solution {
public:

    Node* cloneTree(Node* root) {
        if (root == nullptr) {
            return nullptr;
        }

        queue<Pair> queue;
        Node* clonedRoot = new Node(root->val);
        queue.push(Pair(root, clonedRoot));

        while (!queue.empty()) {

            Pair current = queue.front();
            queue.pop();

            vector<Node*> children = current.original->children;
            vector<Node*>& clonedChildren = current.clone->children;

            for (const auto& node : children) {
                Node* clonedNode = new Node(node->val);
                clonedChildren.push_back(clonedNode);
                queue.push(Pair(node, clonedNode));
            }
        }
        return clonedRoot;
    }
};
