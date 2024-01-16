# Quick Union

## Background
Here, we consider a completely different approach. We consider the use of trees. Every element can be
thought of as a tree node and starts off in its own component. Under this representation, it is likely
that at any given point, we might have a forest of trees, and that's perfectly fine. The root node of each tree
simply represents the component / set of all elements in the same set. <br>
Note that the trees here are not necessarily binary trees. In fact, more often than not, we will have nodes
with multiple children nodes.

### Union
Between the two components, decide on the component to represent the combined set as before.
Now, union is simply assigning the root node of one tree to be the child of the root node of another. Hence, its name.
One thing to note is that to identify the component of the object involves traversing to the root node of the
tree.

### Find
For each of the node, we traverse up the tree from the current node until the root. Check if the
two roots are the same

## Complexity Analysis
**Time**: O(n) for Union and Find operations. While union-ing is indeed quick, it is possibly undermined
by O(n) traversal in the case of a degenerate tree. Note that at this stage, there is nothing to ensure the trees
are balanced.

**Space**: O(n), implementation still involves wrapping the n elements with some structure / wrapper (e.g. Node class).

# Weighted Union
## Background
Now, we improve upon the Quick Union structure by ensuring trees constructed are 'balanced'. Balanced
trees have a nice property that the height of the tree will be upper-bounded by O(log(n)). This considerably speeds
up Union operations. <br>
We additionally track the size of each tree and ensure that whenever there is a union between 2 elements, the smaller
tree will be the child of a larger tree. 
It can be mathematically (induction) shown the height of the tree is bounded by O(log(n)).

## Complexity Analysis
**Time**: O(log(n)) for Union and Find operations.

**Space**: Remains at O(n)

### Path Compression
We can further improve on the time complexity of Weighted Union by introducing path compression. Specifically, during
the traversal of a node up to the root, we re-assign each node's parent to be the root (or as shown in CS2040s,
assigning to its grandparent actually suffice and yield the same big-O upper-bound! This allows path compression to be
done in a single pass.). By doing so, we greatly reduce the height of the trees formed.

The analysis with compression is a bit trickier here and talks about the inverse-Ackermann function. 
Interested readers can find out more [here](https://dl.acm.org/doi/pdf/10.1145/321879.321884)

**Time**: O(alpha)
**Space**: O(n)

## Notes