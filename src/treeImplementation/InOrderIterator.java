package treeImplementation;
import java.util.NoSuchElementException;
import utilities.Iterator;


/**
 * An iterator for traversing a binary search tree in in-order traversal.
 *
 * @param <E> The type of elements in the binary search tree.
 */
public class InOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {

    private BSTreeNode<E> current;
    private BSTreeNode<E> root;

    /**
     * Constructs an InOrderIterator starting from the given root node.
     *
     * @param root The root node of the binary search tree.
     */
    public InOrderIterator(BSTreeNode<E> root) {
        this.current = root;
        this.root = root;
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
    }

    /**
     * Checks if there is another element in the binary search tree.
     *
     * @return True if there is another element, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return current != null;
    }

    /**
     * Gets the next element in the binary search tree.
     *
     * @return The next element in the binary search tree.
     * @throws NoSuchElementException If there is no next element.
     */
    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E data = current.getData();
        if (current.getRight() != null) {
            current = findMin(current.getRight());
        } else {
            current = findSuccessor(current);
        }
        return data;
    }

    /**
     * Finds the node with the smallest element in the tree.
     *
     * @param node The root node of the tree.
     * @return The node with the smallest element in the tree.
     */
    private BSTreeNode<E> findMin(BSTreeNode<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Finds the successor of the given node.
     *
     * @param node The node to find the successor of.
     * @return The successor of the given node.
     */
    private BSTreeNode<E> findSuccessor(BSTreeNode<E> node) {
        BSTreeNode<E> successor = null;
        BSTreeNode<E> ancestor = root;

        while (ancestor != node) {
            if (node.getData().compareTo(ancestor.getData()) < 0) {
                successor = ancestor;
                ancestor = ancestor.getLeft();
            } else {
                ancestor = ancestor.getRight();
            }
        }

        return successor;
    }
}