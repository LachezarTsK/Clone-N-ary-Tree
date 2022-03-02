
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

class Solution {
public:

    Node* cloneTree(Node* root) {
        if (root == nullptr) {
            return nullptr;
        }

        Node* clonedNode = new Node(root->val);
        for (const auto& node : root->children) {
            clonedNode->children.push_back(cloneTree(node));
        }
        return clonedNode;
    }
};
