package treeImplementation;

import java.util.NoSuchElementException;
import utilities.Iterator;


public class PostOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {

    private BSTreeNode<E> current;

    public PostOrderIterator(BSTreeNode<E> root) {
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
        current = findPredecessor(current);
        return data;
    }

    // private void goToRightmostLeaf() {
    //     while (current != null && (current.getRight() != null || current.getLeft() != null)) {
    //         if (current.getRight() != null) {
    //             current = current.getRight();
    //         } else {
    //             current = current.getLeft();
    //         }
    //     }
    // }

    private BSTreeNode<E> findPredecessor(BSTreeNode<E> node) {
        if (node.getLeft() != null) {
            // If the left subtree exists, find the rightmost node in the left subtree
            return findRightmost(node.getLeft());
        } else {
            // If the left subtree is null, traverse up the tree to find the first ancestor
            // whose right child is also an ancestor of the current node
            BSTreeNode<E> ancestor = node.getParent();

            while (ancestor != null && (ancestor.getRight() == null || ancestor.getRight() == node)) {
                node = ancestor;
                ancestor = ancestor.getParent();
            }

            return ancestor;
        }
    }

    private BSTreeNode<E> findRightmost(BSTreeNode<E> node) {
        // Helper method to find the rightmost node in a subtree
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }
}