package treeImplementation;

import utilities.BSTreeADT;
import utilities.Iterator;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
    private BSTreeNode<E> root;

    @Override
    public BSTreeNode<E> getRoot() {
        return root;
    }

    @Override
    public int getHeight() {
        return calculateHeight(root);
    }

    @Override
    public int size() {
        return calculateSize(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;

    }

    @Override
    public boolean contains(E entry) throws NullPointerException {
        return searchNode(root, entry) != null;
    }

    @Override
    public boolean add(E newEntry) throws NullPointerException {
        if (newEntry == null) {
            throw new NullPointerException("Cannot add a null value to the tree.");
        }
        root = insert(root, newEntry);
        return true;
    }

    private int calculateHeight(BSTreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(node.getLeft());
            int rightHeight = calculateHeight(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private int calculateSize(BSTreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            return calculateSize(node.getLeft()) + calculateSize(node.getRight()) + 1;
        }
    }

    private BSTreeNode<E> searchNode(BSTreeNode<E> node, E entry) {
        if (node == null || entry.equals(node.getData())) {
            return node;
        }

        if (entry.compareTo(node.getData()) < 0) {
            return searchNode(node.getLeft(), entry);
        } else {
            return searchNode(node.getRight(), entry);
        }
    }

    private BSTreeNode<E> insert(BSTreeNode<E> node, E newEntry) {
        if (node == null) {
            return new BSTreeNode<>(newEntry);
        }

        int comparisonResult = newEntry.compareTo(node.getData());

        if (comparisonResult < 0) {
            node.setLeft(insert(node.getLeft(), newEntry));
        } else if (comparisonResult > 0) {
            node.setRight(insert(node.getRight(), newEntry));
        }

        return node;
    }

    @Override
    public BSTreeNode<E> search(E entry) throws NullPointerException {
        if (entry == null) {
            throw new NullPointerException("Cannot search for a null value in the tree.");
        }
        return searchEntry(root, entry);
    }

    public BSTreeNode<E> searchEntry(BSTreeNode<E> node, E entry) {
        if (node == null || entry.compareTo(node.getData()) == 0) {
            return node;
        }

        if (entry.compareTo(node.getData()) < 0) {
            return searchEntry(node.getLeft(), entry);
        } else {
            return searchEntry(node.getRight(), entry);
        }
    }

    @Override
    public BSTreeNode<E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        BSTreeNode<E> minNode = findMin(root);
        root = removeEntry(root, minNode.getData());
        return minNode;
    }

    private BSTreeNode<E> findMin(BSTreeNode<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public BSTreeNode<E> removeMax() {
        if (isEmpty()) {
            return null;
        }
        BSTreeNode<E> maxNode = findMax(root);
        root = removeEntry(root, maxNode.getData());
        return maxNode;
    }

    private BSTreeNode<E> findMax(BSTreeNode<E> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    private BSTreeNode<E> removeEntry(BSTreeNode<E> node, E entry) {
        if (node == null) {
            return null;
        }

        int comparison = entry.compareTo(node.getData());
        if (comparison < 0) {
            node.setLeft(removeEntry(node.getLeft(), entry));
        } else if (comparison > 0) {
            node.setRight(removeEntry(node.getRight(), entry));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setData(findMin(node.getRight()).getData());
            node.setRight(removeEntry(node.getRight(), node.getData()));
        }

        return node;
    }

    @Override
    public Iterator<E> inorderIterator() {
        return new InOrderIterator<E>(root);
    }

    @Override
    public Iterator<E> preorderIterator() {
        return new PreOrderIterator<E>(root);
    }

    @Override
    public Iterator<E> postorderIterator() {
        return new PostOrderIterator<E>(root);
    }

    
}
