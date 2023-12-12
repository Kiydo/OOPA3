package treeImplementation;

import java.util.NoSuchElementException;
import utilities.Iterator;

/**
 * An iterator for traversing a binary search tree in pre-order traversal.
 *
 * @param <E> The type of elements in the binary search tree.
 */
public class PreOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {

    private BSTreeNode<E> current;
    private BSTreeNode<E> root;

    /**
     * Constructs a PreOrderIterator starting from the given root node.
     *
     * @param root The root node of the binary search tree.
     */
    public PreOrderIterator(BSTreeNode<E> root) {
        this.root = root;
        this.current = root;
    }


    /**
     * Checks if there is another element in the iteration sequence.
     *
     * @return True if there is another element, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return current != null;
    }

    /**
     * Gets the next element in the iteration sequence.
     *
     * @return The next element in the iteration sequence.
     * @throws NoSuchElementException If there is no next element.
     */
    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E data = current.getData();
        System.out.println("data: " + data);
        // First, check the left subtree
        if (current.getLeft() != null) {
            current = current.getLeft();
        }
        // If left subtree is null, check the right subtree
        else if (current.getRight() != null) {
            current = current.getRight();
        }
        // If both subtrees are null, find the next node by going up the tree
        else {
            current = findSuccessor(current);
        }

        return data;
    }

    /**
     * Finds the successor node of the given node in the binary search tree.
     *
     * @param node The node for which the successor is to be found.
     * @return The successor node of the given node.
     */
    private BSTreeNode<E> findSuccessor(BSTreeNode<E> node) {
        // Helper method to find the next node when both left and right subtrees are null

        // If the current node is the root, there is no successor
        if (node == root) {
            return null;
        }

        // Traverse up the tree to find the first ancestor
        // whose left child is also an ancestor of the current node
        BSTreeNode<E> ancestor = root;

        while (ancestor != null) {
            if (ancestor.getLeft() == node) {
                if (ancestor.getRight() != null) {
                    return findLeftmost(ancestor.getRight());
                } else {
                    node = ancestor;
                    ancestor = ancestor.getParent();
                }
            } else {
                ancestor = ancestor.getRight();
            }
        }

        return null; // No successor found
    }
    
    /**
     * Finds the leftmost node in the subtree of the given node.
     *
     * @param node The node to start searching from.
     * @return The leftmost node in the subtree of the given node.
     */
    private BSTreeNode<E> findLeftmost(BSTreeNode<E> node) {
        // Helper method to find the leftmost node in a subtree
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}
