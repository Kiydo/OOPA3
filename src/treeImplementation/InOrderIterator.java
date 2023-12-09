package treeImplementation;
import java.util.NoSuchElementException;
import utilities.Iterator;


public class InOrderIterator<E extends Comparable<? super E>> implements Iterator<E> {

    private BSTreeNode<E> current;
    private BSTreeNode<E> root;

    public InOrderIterator(BSTreeNode<E> root) {
        this.current = root;
        this.root = root;
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
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
        if (current.getRight() != null) {
            current = findMin(current.getRight());
        } else {
            current = findSuccessor(current);
        }
        return data;
    }

    private BSTreeNode<E> findMin(BSTreeNode<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

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