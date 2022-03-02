
// Function Node is in-built in the solution file on leetcode.com. 
// When running the code on the website, do not include this function.

/**
 * @param {number} val
 * @param {Node[]} children
 */
function Node(val, children) {
    this.val = val === undefined ? 0 : val;
    this.children = children === undefined ? [] : children;
}

/**
 * @param {Node|null} root
 * @return {Node|null}
 */
var cloneTree = function (root) {
    if (root === null) {
        return null;
    }

    const clonedNode = new Node(root.val);
    for (const node of root.children) {
        clonedNode.children.push(cloneTree(node));
    }
    return clonedNode;
};
