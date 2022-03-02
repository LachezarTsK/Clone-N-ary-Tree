
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
 * @param {Node} original
 * @param {Node} clone
 */
function Pair(original, clone) {
    this.original = original;
    this.clone = clone;
}

/**
 * @param {Node|null} root
 * @return {Node|null}
 */
var cloneTree = function (root) {
    if (root === null) {
        return null;
    }

    const queue = new Queue();
    const clonedRoot = new Node(root.val);
    queue.enqueue(new Pair(root, clonedRoot));

    while (!queue.isEmpty()) {

        const current = queue.dequeue();
        const children = current.original.children;
        const clonedChildren = current.clone.children;

        for (const node of children) {
            const clonedNode = new Node(node.val);
            clonedChildren.push(clonedNode);
            queue.enqueue(new Pair(node, clonedNode));
        }
    }
    return clonedRoot;
};
