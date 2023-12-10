package treeImplementation;

import java.util.NoSuchElementException;
import utilities.Iterator;

public class PreOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {

    private BSTreeNode<E> current;
    private BSTreeNode<E> root;

    public PreOrderIterator(BSTreeNode<E> root) {
        this.root = root;
        this.current = root;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

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
    
    private BSTreeNode<E> findLeftmost(BSTreeNode<E> node) {
        // Helper method to find the leftmost node in a subtree
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}
